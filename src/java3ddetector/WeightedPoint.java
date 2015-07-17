/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Point;

/**
 *
 * @author dan
 */
class WeightedPoint extends Point{
    double x;
    double y;
    
    
    WeightedPoint(int i, int j) {
        this.x=i;
        this.y=j;
    }
}
