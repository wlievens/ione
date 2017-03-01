package ione.view;

import ione.model.Point;

public interface NodeView
{
    interface Listener
    {
        int getInputCount();
        
        int getOutputCount();
        
        String getTitle();
        
        void onPositionUpdated();
    }
    
    Point getInputLocation(int index);
    
    Point getOutputLocation(int index);
    
    void setBox(double x, double y, double width, double height);
    
    void setListener(Listener listener);
    
    void setup();
}
