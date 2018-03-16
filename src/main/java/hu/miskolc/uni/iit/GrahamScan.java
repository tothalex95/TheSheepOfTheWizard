/**
 * 
 */
package hu.miskolc.uni.iit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import hu.miskolc.uni.iit.model.Point;
import hu.miskolc.uni.iit.model.Point.PolarAngleComparator;

/**
 * @author Alex Toth
 *
 */
public class GrahamScan {

	public List<Point> getConvexHull(List<Point> pointList) {
		if (pointList.size() < 3) {
			throw new IllegalArgumentException("Cannot create convex hull from less than 3 points!");
		}

		List<Point> points = new ArrayList<>(pointList);

		Point lowestPoint = Collections.min(points);

		PolarAngleComparator polarAngleComparator = new PolarAngleComparator(lowestPoint);

		Collections.sort(points, polarAngleComparator);

		if (areAllCollinear(points)) {
			throw new IllegalArgumentException("Cannot create convex hull from collinear points!");
		}

		Stack<Point> stack = new Stack<>();
		stack.push(points.get(0));
		stack.push(points.get(1));

		for (int i = 2; i < points.size(); i++) {
			Point head = points.get(i);
			Point middle = stack.pop();
			Point tail = stack.peek();

			long crossProduct = crossProduct(tail, middle, head);

			if (crossProduct > 0) {
				stack.push(middle);
				stack.push(head);
			} else if (crossProduct < 0) {
				--i;
			} else {
				stack.push(head);
			}
		}

		return new ArrayList<>(stack);
	}

	private boolean areAllCollinear(List<Point> points) {
		Point point1 = points.get(0);
		Point point2 = points.get(1);

		return points.subList(2, points.size()).stream().filter(point3 -> crossProduct(point1, point2, point3) != 0l)
				.count() == 0l;
	}

	private long crossProduct(Point point1, Point point2, Point point3) {
		return (point2.getX() - point1.getX()) * (point3.getY() - point1.getY())
				- (point2.getY() - point1.getY()) * (point3.getX() - point1.getX());
	}

}
