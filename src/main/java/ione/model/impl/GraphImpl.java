package ione.model.impl;

import ione.model.Edge;
import ione.model.Graph;
import ione.model.Node;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class GraphImpl implements Graph
{
    private final List<Node> nodes = new ArrayList<>();
    private final List<Edge> edges = new ArrayList<>();
    
    @Override
    public Edge addEdge(@NonNull Edge edge)
    {
        edges.add(edge);
        edge.getOrigin().addEdge(edge);
        edge.getTarget().addEdge(edge);
        return edge;
    }
    
    @Override
    public Node addNode(@NonNull Node node)
    {
        nodes.add(node);
        return node;
    }
    
    @Override
    public boolean containsEdge(@NonNull Edge edge)
    {
        return edges.contains(edge);
    }
    
    @Override
    public boolean containsNode(@NonNull Node node)
    {
        return nodes.contains(node);
    }
    
    @Override
    public int getEdgeCount()
    {
        return edges.size();
    }
    
    @Override
    public List<Edge> getEdges()
    {
        return unmodifiableList(edges);
    }
    
    @Override
    public int getNodeCount()
    {
        return nodes.size();
    }
    
    @Override
    public List<Node> getNodes()
    {
        return unmodifiableList(nodes);
    }
}
