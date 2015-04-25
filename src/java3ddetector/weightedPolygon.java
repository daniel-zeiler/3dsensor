/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Polygon;

public class weightedPolygon extends Polygon {

    public int polygonWeight = 0;
    public int polygonCount = 0;

    public void increaseWeight(int n) {
        this.polygonWeight += n;
        this.increaseCount();
    }

    public void increaseCount() {
        this.polygonCount++;
    }

    public int averageWeight() {
        return ((this.polygonWeight) / (this.polygonCount));
    }

    public void addOrigin(weightedPoint p) {
        if (!this.contains(p)) {
            this.addPoint((int) p.getX(), (int) p.getY());
        }
    }
}
