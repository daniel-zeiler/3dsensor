/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dan
 */
class ImageCollection implements Iterable<BufferedImage> {

    private ArrayList<BufferedImage> ImageList = new ArrayList<>();
    private static int width;
    private static int height;
    private static double pointXResolution;
    private static double pointYResolution;
    private static final Color red = new Color(255, 0, 0);
    private static final Color green = new Color(0, 255, 0);
    private static final Color blue = new Color(0, 0, 255);
    private static final Color white = new Color(255, 255, 255);
    private static final ArrayList<Color> colorList = new ArrayList<>();
    private static double amountOfSets;

    public ImageCollection(int numberOfRows, int numberOfColumns, double xResolution, double yResolution) {
        int typeIntRGB = 1;
        colorList.add(red);
        colorList.add(green);
        colorList.add(blue);
        colorList.add(white);
        ImageCollection.pointYResolution = Math.floor(yResolution / numberOfRows);
        ImageCollection.pointXResolution = Math.floor(xResolution / numberOfColumns);
        ImageCollection.width = (int) xResolution;
        ImageCollection.height = (int) yResolution;
        ImageCollection.height = (int) yResolution;
        int amountOfXPoints = numberOfRows;
        double amountOfYPoints = numberOfColumns;
        int rightPosition = width;
        int leftPosition = 0;
        ImageCollection.amountOfSets = Math.floor(height / (2 * (colorList.size()) * pointYResolution));
        for (int i = 0; i < amountOfSets; i++) {
            BufferedImage image = new BufferedImage(width, height, typeIntRGB);
            for (Color currentColor : colorList) {
                rightPosition-=pointXResolution;
                leftPosition+=pointXResolution;
                int otherPointer = 0;
                for (int k = 1; k < amountOfYPoints + 1; k++) {
                    System.out.println(k*pointYResolution);
                    image.setRGB(leftPosition, (int) (k * pointYResolution), currentColor.getRGB());
                    image.setRGB(rightPosition, (int) (k * pointYResolution), currentColor.getRGB());
                }
            }
            ImageList.add(image);
        }
    }

    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public double getXResolution(){
        return pointXResolution;
    }
    
    public double getYResolution(){
        return pointYResolution;
    }
    
    public double getAmountOfSets(){
        return amountOfSets;
    }
    
    @Override
    public Iterator<BufferedImage> iterator() {
        Iterator<BufferedImage> nextImage = ImageList.iterator();
        return nextImage;
    }

    private void generateImages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
