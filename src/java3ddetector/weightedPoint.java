/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Point;
import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class weightedPoint extends Point {

    ArrayList<weightedPoint> connections;
    int z = 0;

    public weightedPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public weightedPoint(int x, int y) {
        super(x, y);
    }

    public void setConnections(ArrayList<weightedPoint> neighbors) {
        neighbors.stream().forEach((neighbor) -> {
            this.connections.add(neighbor);
        });
    }

    public void setZ(weightedPoint small, weightedPoint large) {
        double deltaX = abs(small.getX() - large.getX());
        double deltaY = abs(small.getY() - large.getY());
        double deltaZ = abs(small.getZ() - large.getZ());
        double rateOfX = deltaX / deltaZ;
        double rateOfY = deltaY / deltaZ;
        if (rateOfX == 0) {
            this.z = (int) (this.y * rateOfY);
        } else if (rateOfY == 0) {
            this.z = (int) (this.x * rateOfX);
        } else {
            this.z = (int) ((this.y * rateOfY) + (this.x * rateOfX) / 2);
        }
    }
    
    public void setZ(int z){
        setZCoord(z);
    }

    protected void setZCoord(int z) {
        this.z = z;
    }

    protected int getZ() {
        return this.z;
    }
}
