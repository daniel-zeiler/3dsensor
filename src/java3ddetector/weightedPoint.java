/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class weightedPoint extends Point {

    ArrayList<weightedPoint> connections;

    weightedPoint(int x, int y) {
        super(x, y);
    }

    public void setConnections(ArrayList<weightedPoint> neighbors) {
        for (weightedPoint neighbor : neighbors) {
            this.connections.add(neighbor);
        }
    }
}
