package ione.view.impl;

import ione.view.EdgeView;
import ione.view.GraphEditorView;
import ione.view.NodeView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import lombok.NonNull;
import lombok.Setter;

public class FxGraphEditorView extends Pane implements GraphEditorView
{
    @Setter
    private Listener listener;
    
    @Override
    public void addEdgeView(EdgeView view)
    {
        Node fxNode = (Node)view;
        getChildren().add(fxNode);
        fxNode.toFront();
    }
    
    @Override
    public void addNodeView(@NonNull NodeView view)
    {
        Node fxNode = (Node)view;
        getChildren().add(fxNode);
        fxNode.toBack();
    }
    
    @Override
    public void setup()
    {
        setOnMouseClicked(event ->
        {
            for (Node node : getChildren())
            {
                if (node instanceof FxNodeView)
                {
                    FxNodeView fxNode = (FxNodeView)node;
                    System.out.println(fxNode.getLayoutBounds());
                }
            }
            if (listener != null)
            {
                listener.onTestClick();
            }
        });
    }
}
