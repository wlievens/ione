package ione.util;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Color
{
    public static Color BLACK = new Color(0.0, 0.0, 0.0);
    public static Color WHITE = new Color(1.0, 1.0, 1.0);
    
    private double red;
    private double green;
    private double blue;
    private double alpha;
    
    public Color(double red, double green, double blue)
    {
        this(red, green, blue, 1.0);
    }
}
