/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 *
 * @author dan
 */
public class FastRGB {

    private final int width;
    private final int height;
    private final boolean hasAlphaChannel;
    private int pixelLength;
    private final byte[] pixels;

    public FastRGB(BufferedImage image) {
        pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        width = image.getWidth();
        height = image.getHeight();
        hasAlphaChannel = image.getAlphaRaster() != null;
        pixelLength = 3;
        if (hasAlphaChannel) {
            pixelLength = 4;
        }
    }

    public int getRGB(int x, int y) {
        int pos = (y * pixelLength * width) + (x * pixelLength);
        int argb = -16777216;
        if (hasAlphaChannel) {
            argb = (((int) pixels[pos++] & 0xff) << 24);
        }
        argb += ((int) pixels[pos++] & 0xff);
        argb += (((int) pixels[pos++] & 0xff) << 8);
        argb += (((int) pixels[pos++] & 0xff) << 16);
        return argb;
    }
}
