package ione.model.impl;

import ione.model.Edge;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import lombok.NonNull;

import java.util.Optional;

public class OutputImpl extends PortImpl implements Output
{
    public OutputImpl(@NonNull  Node node)
    {
        super(node);
    }
    
    @Override
    public Optional<Edge> getEdgeTo(@NonNull Input input)
    {
        return edges.stream()
                .filter(edge -> edge.getTarget().equals(input))
                .findFirst();
    }
}
