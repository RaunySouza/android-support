package com.github.raunysouza.android.support.ui.util;

import android.graphics.Color;

/**
 * @author raunysouza
 */
public final class ColorUtils {
    private ColorUtils() {}

    @SuppressWarnings("UnusedDeclaration")
    public static int lighten(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = 0.2f + 0.8f * hsv[2];
        return Color.HSVToColor(hsv);
    }

    @SuppressWarnings("UnusedDeclaration")
    public static int darker(int color) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= 0.8f;
        return Color.HSVToColor(hsv);
    }
}
