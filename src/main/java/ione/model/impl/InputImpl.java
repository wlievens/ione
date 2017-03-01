package ione.model.impl;

import ione.model.Edge;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import lombok.NonNull;

import java.util.Optional;

public class InputImpl extends PortImpl implements Input
{
    public InputImpl(@NonNull Node node)
    {
        super(node);
    }
    
    @Override
    public Optional<Edge> getEdgeFrom(@NonNull Output output)
    {
        return edges.stream()
                .filter(edge -> edge.getOrigin().equals(output))
                .findFirst();
    }
}
