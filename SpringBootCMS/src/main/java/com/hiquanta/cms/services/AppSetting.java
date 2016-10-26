package com.hiquanta.cms.services;

import com.domingosuarez.boot.autoconfigure.jade4j.JadeHelper;

/**
 * Created by hiquanta on 2016/10/23.
 */
@JadeHelper("App")
public class AppSetting {

    private String siteName = "SpringCMS";
    private String siteSlogan = "An interesting place to discover";
    private Integer pageSize = 5;

    public static final String SITE_NAME = "site_name";
    public static final String SITE_SLOGAN = "site_slogan";
    public static final String PAGE_SIZE = "page_size";

    public String getSiteName(){
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;

    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSiteSlogan() {
        return siteSlogan;
    }

    public void setSiteSlogan(String siteSlogan) {
        this.siteSlogan = siteSlogan;

    }
}
