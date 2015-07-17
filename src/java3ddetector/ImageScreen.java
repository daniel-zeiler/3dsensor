/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3ddetector;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author dan
 */
class ImageScreen extends JPanel {

    private static BufferedImage image;
    private static final long serialVersionUID = 1L;

    public ImageScreen(BufferedImage imageBuffer) {
        System.out.println("imageBuffer width: " +imageBuffer.getWidth());
        System.out.println("imageBuffer height: " + imageBuffer.getHeight());
        setMinimumSize(new Dimension(imageBuffer.getWidth(), imageBuffer.getHeight()));
        image = imageBuffer;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        g2d.dispose();
        //g2d.drawI
    }

}
