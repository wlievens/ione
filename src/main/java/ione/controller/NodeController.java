package ione.controller;

import ione.model.Input;
import ione.model.Node;
import ione.model.NodeValue;
import ione.model.Output;
import ione.model.Point;
import ione.model.PortValue;
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
            public void onPositionUpdated()
            {
                if (listener != null)
                {
                    listener.onPositionUpdated();
                }
            }
        });
        view.setup();
        updateNodeToView();
    }
    
    private void updateNodeToView()
    {
        {
            NodeValue value = node.getValue();
            view.setTitle(value == null ? null : value.getName());
            view.setFillColor(value == null ? null : value.getFillColor());
        }
        for (int index = 0; index < node.getInputs().size(); index++)
        {
            Input input = node.getInputs().get(index);
            PortValue value = input.getValue();
            view.setInputName(index, value == null ? null : value.getName());
        }
        for (int index = 0; index < node.getOutputs().size(); index++)
        {
            Output output = node.getOutputs().get(index);
            PortValue value = output.getValue();
            view.setOutputName(index, value == null ? null : value.getName());
        }
    }
}
