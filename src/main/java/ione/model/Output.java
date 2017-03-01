package ione.model;

import java.util.Optional;

public interface Output extends Port
{
    Optional<Edge> getEdgeTo(Input input);
}
