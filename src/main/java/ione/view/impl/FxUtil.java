package ione.view.impl;

import ione.util.Color;

public class FxUtil
{
    public static javafx.scene.paint.Color fxColor(Color color)
    {
        return new javafx.scene.paint.Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
}
