package ione.model.simple;

import ione.model.PortValue;
import lombok.Data;

@Data
public class SimplePortValue implements PortValue
{
    private String name;
}
