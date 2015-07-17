/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
class pixelManipulator {

    private static int width;
    private static int height;
    private static double pointXResolution;
    private static double pointYResolution;
    private static final Color red = new Color(255, 0, 0);
    private static final Color green = new Color(0, 255, 0);
    private static final Color blue = new Color(0, 0, 255);
    private static final Color white = new Color(255, 255, 255);
    private static ArrayList<WeightedPoint> redArrayList = new ArrayList();
    private static ArrayList<WeightedPoint> greenArrayList = new ArrayList();
    private static ArrayList<WeightedPoint> blueArrayList = new ArrayList();
    private static ArrayList<WeightedPoint> whiteArrayList = new ArrayList();

    pixelManipulator(FastRGB newRGB, int width, int height, int numberOfRows, int numberOfColumns, double amountOfSets) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int currentColor = newRGB.getRGB(i, j);
                Color threeDColor = new Color(currentColor);
                if (colorDistance(threeDColor, red) < 5) {
                    redArrayList.add(new WeightedPoint(i, j));
                } else if (colorDistance(threeDColor, green) < 5) {
                    greenArrayList.add(new WeightedPoint(i, j));
                } else if (colorDistance(threeDColor, blue) < 5) {
                    blueArrayList.add(new WeightedPoint(i, j));
                } else if (colorDistance(threeDColor, white) < 5) {
                    whiteArrayList.add(new WeightedPoint(i, j));
                }
            }
        }
    }

    private double colorDistance(Color threeDColor, Color testColor) {
        float dRed = threeDColor.getRed() - testColor.getRed();
        float dGreen = threeDColor.getGreen() - testColor.getGreen();
        float dBlue = threeDColor.getBlue() - testColor.getBlue();

        return Math.sqrt(dRed * dRed + dGreen * dGreen + dBlue * dBlue);
    }
}
