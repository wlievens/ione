package ione.controller;

import ione.model.Node;
import ione.model.Point;
import ione.view.NodeView;
import ione.view.ViewFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class NodeController
{
    public interface Listener
    {
        void onPositionUpdated();
    }
    
    private final ViewFactory viewFactory;
    
    private final Node node;
    
    @Setter
    private Listener listener;
    
    @Getter
    private NodeView view;
    
    public Point getInputLocation(int index)
    {
        return view.getInputLocation(index);
    }
    
    public Point getOutputLocation(int index)
    {
        return view.getOutputLocation(index);
    }
    
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
            
            @Override
            public void onPositionUpdated()
            {
                if (listener != null)
                {
                    listener.onPositionUpdated();
                }
            }
        });
        view.setup();
    }
}
