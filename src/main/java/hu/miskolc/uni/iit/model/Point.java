/**
 * 
 */
package hu.miskolc.uni.iit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

	public double distance(Point point) {
		return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
	}

	@Override
	public int compareTo(Point o) {
		if (this.y > o.y)
			return 1;
		if (this.y < o.y)
			return -1;
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
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d %d", x, y);
	}

}
