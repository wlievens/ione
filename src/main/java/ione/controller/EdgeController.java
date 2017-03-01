package ione.controller;

import ione.model.Edge;
import ione.view.EdgeView;
import ione.view.ViewFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class EdgeController
{
    public interface Listener
    {
    }
    
    private final ViewFactory viewFactory;
    
    private final Edge edge;
    
    @Setter
    private Listener listener;
    
    @Getter
    private EdgeView view;
    
    public void setup()
    {
        view = viewFactory.createEdgeView();
        view.setListener(new EdgeView.Listener()
        {
        });
        view.setup();
    }
}
