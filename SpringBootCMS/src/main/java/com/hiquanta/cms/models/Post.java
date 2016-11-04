package com.hiquanta.cms.models;


import com.hiquanta.cms.models.support.PostFormat;
import com.hiquanta.cms.models.support.PostStatus;
import com.hiquanta.cms.models.support.PostType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hiquanta on 2016/10/23.
 */

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends BaseModel {
    private static final SimpleDateFormat SLUG_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String title;
    @Type(type = "text")
    private String content;
    @Type(type = "text")
    private String renderedContent;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus = PostStatus.PUBLISHED;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostFormat postFormat = PostFormat.MARKDOWN;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostType postType = PostType.POST;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "posts_tags",
            joinColumns = {@JoinColumn(name = "post_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false, updatable = false)}
    )
    private Set<Tag> tags = new HashSet<>();

    private String permalink;

    public String getRenderedContent() {
        if (this.postFormat == PostFormat.MARKDOWN)
            return renderedContent;

        return getContent();
    }

    public void setPermalink(String permalink) {
        String token = permalink.toLowerCase().replace("\n", " ").replaceAll("[^a-z\\d\\s]", " ");
        this.permalink = StringUtils.arrayToDelimitedString(StringUtils.tokenizeToStringArray(token, " "), "-");
    }

    public String subContent(int n) {
        //格式化字符串长度，超出部分显示省略号,区分汉字跟字母。汉字2个字节，字母数字一个字节
        String temp = "";

        if (content.length() < n) {//如果长度比需要的长度n小,返回原字符串
            return content;
        } else {
            int t = 0;
            char[] tempChar = content.toCharArray();
            for (int i = 0; i < tempChar.length && t < n; i++) {
                if ((int) tempChar[i] >= 0x4E00 && (int) tempChar[i] <= 0x9FA5)//是否汉字
                {
                    temp += tempChar[i];
                    t += 2;
                } else {
                    temp += tempChar[i];
                    t++;
                }
            }
            return (temp + "");
        }
    }
}
