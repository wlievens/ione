package ione.view;

import ione.view.impl.FxViewFactory;

public interface ViewFactory
{
    static ViewFactory createJavaFX()
    {
        return new FxViewFactory();
    }
    
    EdgeView createEdgeView();
    
    GraphEditorView createGraphEditorView();
    
    NodeView createNodeView();
}
