package ione.model;

import java.util.List;

public interface Port
{
    Edge addEdge(Edge edge);
    
    List<Edge> getEdges();
    
    Node getNode();
    
    PortValue getValue();
    
    void setValue(PortValue value);
    
    Edge removeEdge(Edge edge);
}
