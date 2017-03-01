package ione.view.impl;

import ione.view.GraphEditorView;
import ione.view.NodeView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import lombok.NonNull;

public class FxGraphEditorView extends Pane implements GraphEditorView
{
    @Override
    public void addNodeView(@NonNull NodeView view)
    {
        getChildren().add((Node)view);
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
        });
    }
}
