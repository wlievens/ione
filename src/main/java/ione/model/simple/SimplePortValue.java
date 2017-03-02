package ione.model.simple;

import ione.model.PortValue;
import ione.util.Color;
import lombok.Data;

@Data
public class SimplePortValue implements PortValue
{
    private String name;
    
    private Color fillColor;
}
