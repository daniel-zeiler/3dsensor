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
public class Xcomparator implements Comparator<WeightedPoint>{


    @Override
    public int compare(WeightedPoint PointOne, WeightedPoint PointTwo) {
        double PointOneX = PointOne.getX();
        double PointTwoX = PointTwo.getX();
        if(PointOneX < PointTwoX) return -1;
        if(PointOneX > PointTwoX) return 1;
        return 0;
    }
    
}
