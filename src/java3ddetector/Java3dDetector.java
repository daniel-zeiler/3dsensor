/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dan
 */
public class Java3dDetector {

    static ArrayList<weightedPoint> list = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    /**protected static ArrayList getPointsFromImage(BufferedImage) throws IOException {
        BufferedImage bi = ImageIO.read(new File("filename.txt")); //Reads in the image
        int biWidth = bi.getWidth();
        int biHeight = bi.getHeight();

        //Color you are searching for
        Color baselineRed = new Color(255,0,0);
        Color baselineBlue = new Color(0,0,255);
        Color baselineGreen = new Color(0,255,0);
        Color baselineWhitewhite = new Color(255,255,255);
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
    
    protected static void getColorromImage(Color color, Color pixelColor){
        
    }*/

    public static void main(String[] args) {
        CaptureImage imageGrabber = new CaptureImage();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double xResolution = screenSize.getWidth();
        double yResolution = screenSize.getHeight();
        int numberOfRows = 50;
        int numberOfColumns = 50;
        boolean running = true;
        Regression regressionModel = new Regression();
        ImageCollection Images = new ImageCollection(numberOfRows,numberOfColumns,xResolution,yResolution);
        System.out.println(Images);
        while(running){
            if(!regressionModel.isSet()){
                int numberTests = userEnterNumberOfTests();
                for(int i = 0; i < numberTests; i++){
                    int distanceMeasurement = userEnterDistanceMeasurement();
                    for (Iterator<BufferedImage> it = Images.iterator(); it.hasNext();) {
                        BufferedImage bufferImage = it.next();
                        projectImage(bufferImage);
                        BufferedImage currentImage = imageGrabber.getImage();
                        FastRGB newRGB = new FastRGB(currentImage);
                        pixelManipulator pixelManip = new pixelManipulator(newRGB,currentImage.getWidth(),currentImage.getHeight(),numberOfRows,numberOfColumns,Images.getAmountOfSets());
                        //regressionModel.detectPoints(detection);
                        //regressionModel.addData(i,distanceMeasurement,detection);
                    }
                }
                regressionModel.save();
                System.out.println("initialization complete");
                running=false;
            }
            threeDModel threeDModel = new threeDModel();
            for (Iterator<BufferedImage> it = Images.iterator(); it.hasNext();){
                BufferedImage bufferImage = it.next();
                projectImage(bufferImage);
                BufferedImage currentImage = imageGrabber.getImage();
                FastRGB newRGB = new FastRGB(currentImage);
                //BufferedImage detection = detectImage();
                //threeDModel.updateModel(regressionModel);
            }
            threeDModel.display();
            running = false;
        }
    }

    private static int userEnterDistanceMeasurement() {
      System.out.println("Please enter the the distance at this increments");
        return Integer.parseInt(in.nextLine());
    }

    private static int userEnterNumberOfTests() {
        System.out.println("Please enter the number of tests you'd like to use");
        return Integer.parseInt(in.nextLine());
    }

    private static void projectImage(BufferedImage bufferImage) {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(bufferImage)));
        frame.pack();
        frame.setVisible(true);
    }
}