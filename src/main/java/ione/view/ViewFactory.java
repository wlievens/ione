package ione.view;

import ione.view.impl.FxViewFactory;

public interface ViewFactory
{
    static ViewFactory createJavaFX()
    {
        return new FxViewFactory();
    }
    
    GraphEditorView createGraphEditorView();
    
    NodeView createNodeView();
}
