/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author dan
 */
public class Java3dDetector {

    static ArrayList<weightedPoint> list = new ArrayList<>();

    public static ArrayList<weightedPoint> findNearbyPoints(ArrayList<weightedPoint> pts, weightedPoint centerPt, double radius) {
        ArrayList<weightedPoint> nearbyPtsSet = new ArrayList<>();
        double innerBound = radius * (Math.sqrt(2.0) / 2.0);
        double radiusSq = radius * radius;
        for (weightedPoint pt : pts) {
            double xDist = Math.abs(centerPt.x - pt.x);
            double yDist = Math.abs(centerPt.y - pt.y);
            if (xDist > radius || yDist > radius) {
                continue;
            }
            if (xDist > innerBound || yDist > innerBound) {
                continue;
            }
            if (distSq(centerPt, pt) < radiusSq) {
                nearbyPtsSet.add(pt);
            }
        }
        return nearbyPtsSet;
    }
    
    
    Here's what I would do:

    First filter out all points that are further than D on either x or y. These are certainly outside the circle of radius D. This is a much simpler computation, and it can quickly eliminate a lot of work. This is a outer bounding-box optimization.

    You can also use an inner bounding-box optimization. If the points are closer than D * sqrt(2)/2 on either x or y, then they're certainly within the circle of radius D. This is also cheaper than calculating the distance formula.

    Then you have a smaller number of candidate points that may be within the circle of radius D. For these, use the distance formula. Remember that if D = sqrt(Δx2+Δy2), then D2 = Δx2+Δy2.
    So you can skip the cost of calculating square root.

    
    public static int distSq(weightedPoint centerPt, weightedPoint pt){
        // distance between points
        return null;
    }

    protected static ArrayList getPointsFromImage(ArrayList list) {
        BufferedImage bi = ImageIO.read(new File(fileName)); //Reads in the image
        int biWidth = bi.getWidth();
        int biHeight = bi.getHeight();

        //Color you are searching for
        int color = 0xffff0000; //red
        int baseLineRed = 255;
        int baseLineGreen = 0;
        int baseLineBlue = 0;

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
        
        
        
        
        
        /**
         *         input image from sensor;
        scan image for points;
        input points to r-tree;
        build structure that will house information relating to each region in grid;
        foreach piont in r-tree{
        find closest (x(maybe even every point)) points
        find distance between (x(maybe all)) and that point
        each region that this line passes, the distance will be added;
        }
        foreach region in section{
        count how many passes this region contains;
        average value of region by summating all pass values;
        }
        load regions back onto original image;
        paint each region with value taken from average;
         */ 
        String filename = "filename.png";
        list = getPointsFromImage(list);
        int maxDist = 0;
        filter:
        {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    Point p1 = list.get(i);
                    Point p2 = list.get(j);
                    double distance = Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
                    if (distance > maxDist) {
                        maxDist = (int) distance;
                    }
                    if (distance < 1) {
                        list.remove(i);
                        break filter;
                    }
                }
            }
        }
        RTree tree = new RTree();
        int listSize=list.size();
        for(int k =0; k<listSize;k++){
            weightedPoint point=list.get(k);
            float[] dimensionalArray = {(float)point.getX(),(float)point.getY()};
            tree.insert(dimensionalArray,k);
        }
        tree.visualize();
        
        
        ArrayList<weightedPolygon> polyLists = new ArrayList<>();
        for(weightedPoint points:list){
            //for each point construct a polygon.  Add the closest points to this polygon
            //add this polygon to the list of polygons
            Java3dDetector.findNearbyPoints(list,points,50);
        }
        
        
        
        
        
        ArrayList<weightedPolygon> polyList = new ArrayList<>();
        for (int x = 0; x < 50 * maxDist; x += maxDist) {
            for (int y = 0; y < 50 * maxDist; y += maxDist) {
                weightedPolygon s = new weightedPolygon();
                s.addPoint(x, y);
                s.addPoint(x + maxDist, y);
                s.addPoint(x, y + maxDist);
                s.addPoint(x + maxDist, y + maxDist);
                polyList.add(s);
            }
        }
        for(int k=0; k<list.size();k++){
            for(int l=k+1; l<list.size(); l++){
                for(weightedPolygon polygon:polyList){
                    Point point1=list.get(k);
                    Point point2=list.get(l);
                    double point1X=point1.getX();
                    double point1Y=point1.getY();
                    double point2X=point2.getX();
                    double point2Y=point2.getY();
                    if(SegmentIntersectRectangle(polygon.xpoints[0],polygon.ypoints[0],polygon.xpoints[3],polygon.ypoints[3],point1X,point1Y,point2X,point2Y)){
                        polygon.increaseWeight(l);
                        polygon.
                                }
                }
            }
            /**
             * Perhaps the maximum distance between any two points will be the
             * resolution of this graph
             */
            
            
            /**
             *         input image from sensor;
             * scan image for points;
             * input points to r-tree;
             * build structure that will house information relating to each region in grid;
             * foreach piont in r-tree{
             * find closest (x(maybe even every point)) points
             * find distance between (x(maybe all)) and that point
             * each region that this line passes, the distance will be added;
             * }
             * foreach region in section{
             * count how many passes this region contains;
             * average value of region by summating all pass values;
             * }
             * load regions back onto original image;
             * paint each region with value taken from average;
             */ }
        /**
         *         input image from sensor;
         * scan image for points;
         * input points to r-tree;
        build structure that will house information relating to each region in grid;
        foreach piont in r-tree{
            find closest (x(maybe even every point)) points
            find distance between (x(maybe all)) and that point
            each region that this line passes, the distance will be added;
        }
        foreach region in section{
            count how many passes this region contains;
            average value of region by summating all pass values;
        }
        load regions back onto original image;
        paint each region with value taken from average;
     */

    }

    protected static boolean SegmentIntersectRectangle(double a_rectangleMinX,
            double a_rectangleMinY,
            double a_rectangleMaxX,
            double a_rectangleMaxY,
            double a_p1x,
            double a_p1y,
            double a_p2x,
            double a_p2y) {
        // Find min and max X for the segment

        double minX = a_p1x;
        double maxX = a_p2x;

        if (a_p1x > a_p2x) {
            minX = a_p2x;
            maxX = a_p1x;
        }

    // Find the intersection of the segment's and rectangle's x-projections
        if (maxX > a_rectangleMaxX) {
            maxX = a_rectangleMaxX;
        }

        if (minX < a_rectangleMinX) {
            minX = a_rectangleMinX;
        }

        if (minX > maxX) // If their projections do not intersect return false
        {
            return false;
        }

    // Find corresponding min and max Y for min and max X we found before
        double minY = a_p1y;
        double maxY = a_p2y;

        double dx = a_p2x - a_p1x;

        if (Math.abs(dx) > 0.0000001){
            double a = (a_p2y - a_p1y) / dx;
            double b = a_p1y - a * a_p1x;
            minY = a * minX + b;
            maxY = a * maxX + b;
        }

        if (minY > maxY) {
            double tmp = maxY;
            maxY = minY;
            minY = tmp;
        }

    // Find the intersection of the segment's and rectangle's y-projections
        if (maxY > a_rectangleMaxY) {
            maxY = a_rectangleMaxY;
        }

        if (minY < a_rectangleMinY) {
            minY = a_rectangleMinY;
        }

        return minY <= maxY;
    }
}
