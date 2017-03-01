package ione.controller;

import ione.model.Node;
import ione.view.NodeView;
import ione.view.ViewFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NodeController
{
    private final ViewFactory viewFactory;
    
    private final Node node;
    
    @Getter
    private NodeView view;
    
    public void setup()
    {
        view = viewFactory.createNodeView();
        view.setListener(new NodeView.Listener()
        {
            @Override
            public int getInputCount()
            {
                return node.getInputCount();
            }
            
            @Override
            public int getOutputCount()
            {
                return node.getOutputCount();
            }
            
            @Override
            public String getTitle()
            {
                return node.toString();
            }
        });
        view.setup();
    }
}
