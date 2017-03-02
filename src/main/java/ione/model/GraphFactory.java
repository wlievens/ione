package ione.model;

import ione.model.impl.GraphFactoryImpl;

public interface GraphFactory
{
    static GraphFactory create()
    {
        return new GraphFactoryImpl();
    }
    
    Edge createEdge(Graph graph, Output origin, Input target, EdgeValue value);
    
    default Edge createEdge(Graph graph, Output origin, Input target)
    {
        return createEdge(graph, origin, target, null);
    }
    
    Graph createGraph();
    
    default Input createInput(Node node)
    {
        return createInput(node, null);
    }
    
    Input createInput(Node node, PortValue value);
    
    default Node createNode(Graph graph)
    {
        return createNode(graph, null);
    }
    
    Node createNode(Graph graph, NodeValue value);
    
    default Output createOutput(Node node)
    {
        return createOutput(node, null);
    }
    
    Output createOutput(Node node, PortValue value);
}
