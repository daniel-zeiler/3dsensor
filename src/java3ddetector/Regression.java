/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author dan
 */
class Regression {
    private int xDim;
    private int yDim;
    private int zDim;
    private Point[][][] pointArray;
    private RegressionModels[][] regressions;
    
    public Regression(){
        getDatasheet();
        if(this.dataSheet!=null){
            for(int x = 0; x<xDim; x++){
                for(int y = 0; y<yDim; y++){
                    for(int z = 0; z<xDim; z++){
                        pointArray[xDim][yDim][zDim] = new Point(dataSheet.read(),dataSheet.Read());
                    }
                }
            }
            regressions = new RegressionModels[xDim][yDim];
            regressions.buildRegressions();
        }
    }
    
    public boolean isSet(){
        return (datasheet != null);
    }
    
    public void getDataSheet(fileName){
    
    }

    boolean isSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void detectPoints(BufferedImage detection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addData(int i, int distanceMeasurement, BufferedImage detection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
