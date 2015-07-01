/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dan
 */
class ImageCollection implements Iterable<BufferedImage>{
    private ArrayList<BufferedImage> ImageList;
    
    
    public ImageCollection() {
    }

    @Override
    public Iterator<BufferedImage> iterator() {
        Iterator<BufferedImage> nextImage = ImageList.iterator();
        return nextImage;
    }
    
}
