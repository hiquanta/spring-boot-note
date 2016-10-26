package com.hiquanta.cms.utils;

import com.hiquanta.cms.support.web.PegDownMarkdownService;
import com.hiquanta.cms.support.web.MarkdownService;

/**
 * Created by hiquanta on 2016/10/23.
 */
public class Markdown {
    private static final MarkdownService MARKDOWN_SERVICE = new PegDownMarkdownService();
    public static String markdownToHtml(String content){
        return MARKDOWN_SERVICE.renderToHtml(content);
    }
}
