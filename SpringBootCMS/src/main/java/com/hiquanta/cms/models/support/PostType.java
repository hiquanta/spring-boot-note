package com.hiquanta.cms.models.support;

/**
 * Created by hiquanta on 2016/10/24.
 */
public enum PostType {
    PAGE("Page"),
    POST("Post");

    private String name;

    PostType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId(){
        return name();
    }

    @Override
    public String toString() {
        return getName();
    }
}
