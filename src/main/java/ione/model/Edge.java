package ione.model;

public interface Edge
{
    Output getOrigin();
    
    Input getTarget();
    
    EdgeValue getValue();
    
    void setValue(EdgeValue value);
}
