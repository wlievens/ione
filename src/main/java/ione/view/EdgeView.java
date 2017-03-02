package ione.view;

import ione.util.Color;

public interface EdgeView
{
    interface Listener
    {
    }
    
    void hide();
    
    void setListener(Listener listener);
    
    void setLocation(double x1, double y1, double x2, double y2);
    
    void setColor(Color color);
    
    void setup();
    
    void show();
}
