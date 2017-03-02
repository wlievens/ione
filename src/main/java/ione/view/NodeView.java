package ione.view;

import ione.model.Point;
import ione.util.Color;

public interface NodeView
{
    interface Listener
    {
        int getInputCount();
        
        int getOutputCount();
        
        void onPositionUpdated();
    }
    
    Point getInputLocation(int index);
    
    Point getOutputLocation(int index);
    
    void setBox(double x, double y, double width, double height);
    
    void setFillColor(Color fillColor);
    
    void setInputFillColor(int index, Color fillColor);
    
    void setInputName(int index, String name);
    
    void setListener(Listener listener);
    
    void setOutputFillColor(int index, Color fillColor);
    
    void setOutputName(int index, String name);
    
    void setTitle(String title);
    
    void setup();
}
