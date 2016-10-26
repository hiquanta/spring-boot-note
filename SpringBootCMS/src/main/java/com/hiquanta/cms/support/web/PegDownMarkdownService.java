package com.hiquanta.cms.support.web;

import com.hiquanta.cms.support.web.MarkdownService;
import org.pegdown.*;
import org.pegdown.ast.RootNode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by hiquanta on 2016/10/24.
 */
@Service
@Qualifier("pegdown")
public class PegDownMarkdownService implements MarkdownService {
    private final PegDownProcessor pegdown;

    public PegDownMarkdownService() {
        pegdown = new PegDownProcessor(Extensions.ALL);
    }
    @Override
    public String renderToHtml(String markdownSource) {
        synchronized (pegdown) {
            RootNode astRoot = pegdown.parseMarkdown(markdownSource.toCharArray());
            ToHtmlSerializer serializer = new ToHtmlSerializer(new LinkRenderer(),
                    Collections.singletonMap(VerbatimSerializer.DEFAULT, PygmentsVerbatimSerializer.INSTANCE));
            return serializer.toHtml(astRoot);
        }
    }
}
