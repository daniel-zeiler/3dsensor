package java3ddetector;

import java.util.ArrayList;

/**
 * This class is one that will
 *
 * @author dan
 */
public class projectionBuilder {

    weightedPoint[][] finalPoints;
    String position;

    public projectionBuilder(int pointAmount, String position) {
        this.finalPoints = new weightedPoint[pointAmount][pointAmount];
        this.position = position;
    }

    public ArrayList createPoints(int pointAmount, int iteration, int resolution) {
        ArrayList<weightedPoint> initialPoints = new ArrayList<>();
        for (int i = 0; i < pointAmount; i++) {
            initialPoints.add(new weightedPoint(resolution + iteration, (i * resolution)));
        }
        return initialPoints;
    }

    public void fillFinalPoints(ArrayList<weightedPoint> points, int iteration) {
        int tracker = 0;
        for (weightedPoint point : points) {
            finalPoints[tracker][iteration] = point;
            tracker++;
        }
    }
}
