package ione.model;

import java.util.Optional;

public interface Input extends Port
{
    Optional<Edge> getEdgeFrom(Output output);
}
