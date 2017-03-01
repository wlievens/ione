package ione.model;

import lombok.Value;

@Value
public class Point
{
    public static final Point ORIGIN = new Point(0, 0);
    
    private final double x;
    private final double y;
}
