package ione.view.impl;

import ione.view.EdgeView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class FxEdgeView extends Line implements EdgeView
{
    @Override
    public void setListener(Listener listener)
    {
    }
    
    @Override
    public void setLocation(double x1, double y1, double x2, double y2)
    {
        setStartX(x1);
        setStartY(y1);
        setEndX(x2);
        setEndY(y2);
    }
    
    @Override
    public void setup()
    {
        setStroke(Color.BLUEVIOLET);
        setStrokeWidth(3.0);
    }
}
