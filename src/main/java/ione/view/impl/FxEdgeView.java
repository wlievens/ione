package ione.view.impl;

import ione.util.Color;
import ione.view.EdgeView;
import javafx.scene.shape.Line;
import lombok.NonNull;
import lombok.Setter;

import static ione.view.impl.FxUtil.fxColor;

public class FxEdgeView extends Line implements EdgeView
{
    @Setter
    private Listener listener;
    
    @Override
    public void hide()
    {
        setVisible(false);
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
    public void setColor(@NonNull Color color)
    {
        setStroke(fxColor(color));
    }
    
    @Override
    public void setup()
    {
        setColor(Color.BLACK);
        setStrokeWidth(3.0);
    }
    
    @Override
    public void show()
    {
        setVisible(true);
    }
}
