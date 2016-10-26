package com.hiquanta.cms.models.support;

/**
 * Created by hiquanta on 2016/10/24.
 */
public enum PostFormat {
    HTML("Html"),
    MARKDOWN("Markdown");
    private String displayName;

    PostFormat(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public String getId() {
        return name();
    }

    @Override
    public String toString() {
        return getDisplayName();
    }
}
