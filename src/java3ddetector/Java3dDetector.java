/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author dan
 */
public class Java3dDetector {

    static ArrayList<weightedPoint> list = new ArrayList<>();

    protected static ArrayList getPointsFromImage(ArrayList list) throws IOException {
        BufferedImage bi = ImageIO.read(new File("filename.txt")); //Reads in the image
        int biWidth = bi.getWidth();
        int biHeight = bi.getHeight();

        //Color you are searching for
        Color red = new Color(255,0,0);
        Color blue = new Color(0,0,255);
        Color green = new Color(0,255,0);
        Color white = new Color(255,255,255);
        Color[] allColors = new Color[]{red,green,blue,white};
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.addAll(Arrays.asList(allColors));


        for (int x = 0; x < biWidth; x++) {
            for (int y = 0; y < biHeight; y++) {
                Color pixelColor = new Color(bi.getRGB(x, y));
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();
                double distance = sqrt(pow((baseLineRed - red), 2) + (pow((baseLineGreen - green), 2)) + (pow(baseLineBlue - blue, 2)));
                if (distance < 50) {
                    list.add(new weightedPoint(x, y));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        pointCollection pointCollect = new pointCollection();
        linearRegressionCollection linearRegressionCollection = new linearRegressionCollection();
        centroidCollection centroidCollect = new centroidCollection();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        ArrayList<weightedPoint> projectionLists = new ArrayList<>();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int height = dimension.height;
        int width = dimension.width;
        BufferedImage imageMap = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = imageMap.createGraphics();
        g2.drawImage(imageMap,0,0,null);
    }
}
