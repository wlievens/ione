package ione.view;

public interface GraphEditorView
{
    interface Listener
    {
        void onTestClick();
    }
    
    void addEdgeView(EdgeView view);
    
    void addNodeView(NodeView view);
    
    void setListener(Listener listener);
    
    void setup();
}
