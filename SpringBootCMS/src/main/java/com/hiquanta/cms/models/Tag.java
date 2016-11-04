package com.hiquanta.cms.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hiquanta on 2016/10/23.
 */
@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private List<Post> posts = new ArrayList<>();

    public Tag() {

    }

    @Override
    public String toString() {
        return name;
    }

    public Tag(String name) {
        this.setName(name);
    }
}
