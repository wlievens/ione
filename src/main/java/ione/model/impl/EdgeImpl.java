package ione.model.impl;

import ione.model.Edge;
import ione.model.EdgeValue;
import ione.model.Input;
import ione.model.Output;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class EdgeImpl implements Edge
{
    @Getter
    private final Output origin;
    
    @Getter
    private final Input target;
    
    @Getter
    @Setter
    private EdgeValue value;
}
