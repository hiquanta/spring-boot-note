package com.hiquanta.cms.mobile.domain;

import com.hiquanta.cms.models.support.PostFormat;
import com.hiquanta.cms.models.support.PostStatus;
import com.hiquanta.cms.models.support.PostType;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;

/**
 * Created by hiquanta on 2016/10/29.
 */
@Getter
@Setter
public class ModelPost {


    private String title;

    private String content;
    private String renderedContent;

    private PostStatus postStatus = PostStatus.PUBLISHED;

    private PostFormat postFormat = PostFormat.MARKDOWN;

    private PostType postType = PostType.POST;

    private String permalink;

}
