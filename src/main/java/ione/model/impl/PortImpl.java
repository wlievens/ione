package ione.model.impl;

import ione.model.Edge;
import ione.model.Node;
import ione.model.Port;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class PortImpl implements Port
{
    @Getter
    protected final Node node;
    
    @Getter
    protected final List<Edge> edges = new ArrayList<>();
    
    @Override
    public Edge addEdge(@NonNull Edge edge)
    {
        edges.add(edge);
        return edge;
    }
    
    @Override
    public Edge removeEdge(@NonNull Edge edge)
    {
        edges.remove(edge);
        return edge;
    }
}
