/**
 * 
 */
package hu.miskolc.uni.iit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.miskolc.uni.iit.model.Point;

/**
 * @author Alex Toth
 *
 */
public class PointFinder {

	/**
	 * @param convexHull
	 * @return
	 * @see Point
	 */
	public Point findBestPoint(List<Point> convexHull) {
		List<Double> angles = new ArrayList<>();

		angles.add(getAngle(convexHull.get(0), convexHull.get(convexHull.size() - 1), convexHull.get(1)));

		for (int i = 1; i < convexHull.size() - 1; i++) {
			angles.add(getAngle(convexHull.get(i), convexHull.get(i - 1), convexHull.get(i + 1)));
		}

		angles.add(getAngle(convexHull.get(convexHull.size() - 1), convexHull.get(convexHull.size() - 2),
				convexHull.get(0)));

		Double minAngle = Collections.min(angles);

		int bestPointsIndex = angles.indexOf(minAngle);
		Point bestPoint = convexHull.get(bestPointsIndex);

		return bestPoint;
	}

	/**
	 * @param point1
	 * @param point2
	 * @param point3
	 * @return
	 */
	private double getAngle(Point point1, Point point2, Point point3) {
		Point ab = new Point(point2.getX() - point1.getX(), point2.getY() - point1.getY());
		Point ac = new Point(point3.getX() - point1.getX(), point3.getY() - point1.getY());

		double abLength = ab.distance(new Point(0, 0));
		double acLength = ac.distance(new Point(0, 0));

		double dotProduct = ab.getX() * ac.getX() + ab.getY() * ac.getY();

		return Math.toDegrees(Math.acos(dotProduct / (abLength * acLength)));
	}

}
