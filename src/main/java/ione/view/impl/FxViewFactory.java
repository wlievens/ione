package ione.view.impl;

import ione.view.GraphEditorView;
import ione.view.ViewFactory;

public class FxViewFactory implements ViewFactory
{
    @Override
    public GraphEditorView createGraphEditorView()
    {
        return new FxGraphEditorView();
    }
}