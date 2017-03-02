package ione.model;

import java.util.List;

public interface Node
{
    Input addInput(Input input);
    
    Output addOutput(Output output);
    
    int getInputCount();
    
    List<Input> getInputs();
    
    Point getLocation();
    
    void setLocation(Point point);
    
    int getOutputCount();
    
    List<Output> getOutputs();
    
    NodeValue getValue();
    
    void setValue(NodeValue value);
    
    void setLocation(double x, double y);
}
