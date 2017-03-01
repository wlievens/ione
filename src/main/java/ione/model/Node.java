package ione.model;

import java.util.List;

public interface Node
{
    Input addInput(Input input);
    
    Output addOutput(Output output);
    
    int getInputCount();
    
    List<Input> getInputs();
    
    Point getLocation();
    
    int getOutputCount();
    
    void setLocation(Point point);
    
    List<Output> getOutputs();
    
    void setLocation(double x, double y);
}
