/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.util.ArrayList;

/**
 *
 * @author dan
 */
class centroidCollection {
    private int numClusters;
    private int totalData;
    private double samples[][] = new double[][];
    private static ArrayList<WeightedPoint> dataSet = new ArrayList<WeightedPoint>();
    private static ArrayList<Centroid> centroids = new ArrayList<Centroid>();
    
    centroidCollection(pixelManipulator pixelManip,int numClusters, int totalData) {
        
    }
    
}
