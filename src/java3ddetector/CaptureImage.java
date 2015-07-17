package java3ddetector;

import com.googlecode.javacv.OpenCVFrameGrabber;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.awt.image.BufferedImage;



public class CaptureImage {
    final OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
    public CaptureImage() {
        // 0-default camera, 1 - next...so on

    }
    public BufferedImage getImage(){
        try {
            grabber.start();
            IplImage img = grabber.grab();
            BufferedImage ScreenGrab = img.getBufferedImage();
            grabber.stop();
            return ScreenGrab;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}