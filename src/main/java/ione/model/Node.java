package ione.model;

import java.util.List;

public interface Node
{
    Input addInput(Input input);
    
    Output addOutput(Output output);
    
    List<Input> getInputs();
    
    Point getLocation();
    
    List<Output> getOutputs();
}
