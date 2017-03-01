package ione.model.impl;

import ione.model.Edge;
import ione.model.Input;
import ione.model.Output;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EdgeImpl implements Edge
{
    @Getter
    private final Output origin;
    
    @Getter
    private final Input target;
}
