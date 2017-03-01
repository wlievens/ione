package ione.view;

public interface EdgeView
{
    interface Listener
    {
    }
    
    void setListener(Listener listener);
    
    void setLocation(double x1, double y1, double x2, double y2);
    
    void setup();
}
