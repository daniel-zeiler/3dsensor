package java3ddetector;


import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dan
 */
public class YComparator implements Comparator<WeightedPoint>{


    @Override
    public int compare(WeightedPoint PointOne, WeightedPoint PointTwo) {
        double PointOneY = PointOne.getY();
        double PointTwoY = PointTwo.getY();
        if(PointOneY < PointTwoY) return -1;
        if(PointOneY > PointTwoY) return 1;
        return 0;
    }
    
}
