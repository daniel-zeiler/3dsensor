/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dan
 */
public class ProjectorImage {
    int red = 0xFF0000;
    int green = 0x00FF00;
    int blue = 0x0000FF;
    int white = 0xFFFFFF;
    Integer[] allColors = new Integer[]{red,green,blue,white};
    ArrayList<Integer> colorList = new ArrayList<>();
    int yDimension;
    int xDimension;
    ArrayList<BufferedImage> allImages = new ArrayList<>();

    /**
     * This function generates a number of structured light Images that are projected onto surfaces
     * @param height
     * @param width
     * @param xResolution
     * @param yResolution 
     */
    public ProjectorImage(int height,int width, int xResolution, int yResolution){
        this.yDimension=height;
        this.xDimension=width;
        colorList.addAll(allColors.asList(allColors));
        int leftPosition=0;
        int rightPosition=xDimension;
        int amountOfSets=(int) floor(this.yDimension / (2*(this.colorList.size() * xResolution)));
        int amountOfPoints = this.yDimension/xResolution;
        for(int i = 0; i<amountOfSets; i++){
            BufferedImage anImage = new BufferedImage(height,width,TYPE_INT_RGB);
            for(int j = 0; j<amountOfSets; j++){
                int currentColor = this.allColors[j];
                leftPosition+=xResolution;
                rightPosition-=xResolution;
                for(int k = 0; k<amountOfPoints; k++){
                    anImage.setRGB(leftPosition,k,currentColor);
                    anImage.setRGB(rightPosition,k,currentColor);
                }
            }
            allImages.add(anImage);
        }
    }

    public ArrayList<BufferedImage> getImages(){
        return this.allImages;
    }
}
