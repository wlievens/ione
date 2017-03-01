package ione.model;

import java.util.List;

public interface Graph
{
    Edge addEdge(Edge edge);
    
    Node addNode(Node node);
    
    boolean containsEdge(Edge edge);
    
    boolean containsNode(Node node);
    
    int getEdgeCount();
    
    List<Edge> getEdges();
    
    int getNodeCount();
    
    List<Node> getNodes();
}
