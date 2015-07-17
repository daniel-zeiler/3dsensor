/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

/**
 *
 * @author dan
 */
public class Centroid {
    private double mX = 0.0;
    private double mY = 0.0;
    
    public Centroid(){
    }
    
    public Centroid(double newX, double newY){
        this.mX = newX;
        this.mY = newY;
    }
    
    public void setX(double newX){
    this.mX=newX;
    }
    public void setY(double newY){
    this.mY=newY;
    }
    public double getX(){
    return this.mX;
    }
    public double getY(){
    return this.mY;
    }
}
