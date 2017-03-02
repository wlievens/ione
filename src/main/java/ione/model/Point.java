package ione.model;

import lombok.NonNull;
import lombok.Value;

import static java.lang.Math.sqrt;

@Value
public class Point
{
    public static final Point ORIGIN = new Point(0, 0);
    
    private final double x;
    private final double y;
    
    public double distance(@NonNull Point other)
    {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return sqrt(dx * dx + dy * dy);
    }
}
