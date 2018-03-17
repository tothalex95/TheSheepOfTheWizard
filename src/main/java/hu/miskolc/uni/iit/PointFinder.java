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
	 * Finds the point from which the rest of the convex hull is seen in the
	 * smallest angle.
	 * 
	 * @param convexHull	The convex hull represented by a list of points.
	 * @return	The point from which the rest is seen in the smallest angle.
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
	 * Returns the included angle of the ab and ac vectors in degrees.
	 * 
	 * @param a	The starting point of the vectors.
	 * @param b	The end point of the ab vector.
	 * @param c	The end point of the ac vector.
	 * @return	The included angle of the ab and ac vectors.
	 */
	private double getAngle(Point a, Point b, Point c) {
		Point ab = new Point(b.getX() - a.getX(), b.getY() - a.getY());
		Point ac = new Point(c.getX() - a.getX(), c.getY() - a.getY());

		double abLength = ab.distance(new Point(0, 0));
		double acLength = ac.distance(new Point(0, 0));

		double dotProduct = ab.getX() * ac.getX() + ab.getY() * ac.getY();

		return Math.toDegrees(Math.acos(dotProduct / (abLength * acLength)));
	}

}
