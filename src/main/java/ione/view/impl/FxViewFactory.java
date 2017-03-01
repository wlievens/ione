package ione.view.impl;

import ione.view.EdgeView;
import ione.view.GraphEditorView;
import ione.view.NodeView;
import ione.view.ViewFactory;

public class FxViewFactory implements ViewFactory
{
    @Override
    public EdgeView createEdgeView()
    {
        return new FxEdgeView();
    }
    
    @Override
    public GraphEditorView createGraphEditorView()
    {
        return new FxGraphEditorView();
    }
    
    @Override
    public NodeView createNodeView()
    {
        return new FxNodeView();
    }
}
