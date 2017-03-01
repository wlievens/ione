package ione.view;

public interface NodeView
{
    interface Listener
    {
        int getInputCount();
        
        int getOutputCount();
        
        String getTitle();
    }
    
    void setBox(double x, double y, double width, double height);
    
    void setListener(Listener listener);
    
    void setup();
}
