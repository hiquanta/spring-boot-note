package com.hiquanta.cms.support.web;

import org.pegdown.Printer;
import org.pegdown.VerbatimSerializer;
import org.pegdown.ast.VerbatimNode;

/**
 * Created by hiquanta on 2016/10/24.
 */
public class PygmentsVerbatimSerializer implements VerbatimSerializer{
    public static final PygmentsVerbatimSerializer INSTANCE = new PygmentsVerbatimSerializer();

    private SyntaxHighlightService syntaxHighlightService = new PygmentsService();
    @Override
    public void serialize(VerbatimNode node, Printer printer) {
        printer.print(syntaxHighlightService.highlight(node.getText()));
    }
}
