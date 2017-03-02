package ione.model.simple;

import ione.model.NodeValue;
import ione.util.Color;
import lombok.Data;

@Data
public class SimpleNodeValue implements NodeValue
{
    private String name;
    
    private Color fillColor;
}
