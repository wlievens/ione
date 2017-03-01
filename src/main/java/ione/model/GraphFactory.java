package ione.model;

import ione.model.impl.GraphFactoryImpl;

public interface GraphFactory
{
    static GraphFactory create()
    {
        return new GraphFactoryImpl();
    }
    
    Edge createEdge(Graph graph, Output origin, Input target);
    
    Graph createGraph();
    
    Input createInput(Node node);
    
    Node createNode(Graph graph);
    
    Output createOutput(Node node);
}
