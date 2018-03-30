package hu.miskolc.uni.iit.model;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Alex Toth
 *
 */
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
public class Point implements Comparable<Point> {

	private final long x;
	private final long y;

	/**
	 * Returns the distance of the actual and the parameter point. Actually, it is
	 * the length of the vector created from the 2 points.
	 * 
	 * @param point
	 *            The point from which the distance must be calculated.
	 * @return The distance of the 2 points.
	 */
	public double distance(Point point) {
		return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
	}

	@Override
	public int compareTo(Point o) {
		if (this.y > o.y) {
			return 1;
		}
		if (this.y < o.y) {
			return -1;
		}
		return (int) Math.signum(this.x - o.x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (x ^ (x >>> 32));
		result = prime * result + (int) (y ^ (y >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		return y == other.y;
	}

	@Override
	public String toString() {
		return String.format("%d %d", x, y);
	}

	@AllArgsConstructor
	public static final class PolarAngleComparator implements Comparator<Point> {

		@NonNull
		private Point lowestPoint;

		@Override
		public int compare(Point point1, Point point2) {
			if (point1.equals(point2)) {
				return 0;
			}

			double theta1 = Math.atan2(point1.y - lowestPoint.y, point1.x - lowestPoint.x);
			double theta2 = Math.atan2(point2.y - lowestPoint.y, point2.x - lowestPoint.x);

			if (theta1 < theta2) {
				return -1;
			} else if (theta1 > theta2) {
				return 1;
			} else {
				double distance1 = Math.sqrt(((lowestPoint.x - point1.x) * (lowestPoint.x - point1.x))
						+ ((lowestPoint.y - point1.y) * (lowestPoint.y - point1.y)));
				double distance2 = Math.sqrt(((lowestPoint.x - point2.x) * (lowestPoint.x - point2.x))
						+ ((lowestPoint.y - point2.y) * (lowestPoint.y - point2.y)));

				if (distance1 < distance2) {
					return -1;
				} else {
					return 1;
				}
			}
		}

	}

}
