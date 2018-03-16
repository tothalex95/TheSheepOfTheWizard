package hu.miskolc.uni.iit.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import hu.miskolc.uni.iit.model.Point.PolarAngleComparator;

/**
 * @author Alex Toth
 *
 */
public class PointTest {

	@Test
	public void testGetX() {
		Point point = new Point();

		assertThat(point.getX(), is(equalTo(0L)));
	}

	@Test
	public void testGetY() {
		Point point = new Point();

		assertThat(point.getY(), is(equalTo(0L)));
	}

	@Test
	public void testDistanceWithSamePoint() {
		Point point = new Point();

		assertThat(point.distance(point), is(equalTo(0.0)));
	}

	@Test
	public void testDistanceWithDifferentPoints() {
		Point point1 = new Point();
		Point point2 = new Point(10L, 0L);

		assertThat(point1.distance(point2), is(equalTo(10.0)));
	}

	@Test
	public void testCompareToWithSamePoint() {
		Point point = new Point();

		assertThat(point.compareTo(point), is(equalTo(0)));
	}

	@Test
	public void testCompareToWithBiggerY() {
		Point point1 = new Point(1L, 5L);
		Point point2 = new Point(4L, 3L);

		assertThat(point1.compareTo(point2), is(equalTo(1)));
	}

	@Test
	public void testCompareToWithSmallerY() {
		Point point1 = new Point(1L, 2L);
		Point point2 = new Point(4L, 3L);

		assertThat(point1.compareTo(point2), is(equalTo(-1)));
	}

	@Test
	public void testEqualsWithSamePoint() {
		Point point = new Point();

		assertThat(point, is(equalTo(point)));
	}

	@Test
	public void testEqualsWithEqualPoints() {
		Point point1 = new Point();
		Point point2 = new Point();

		assertThat(point1, is(equalTo(point2)));
	}

	@Test
	public void testEqualsWithPointsWithDifferentX() {
		Point point1 = new Point(1, 0);
		Point point2 = new Point(2, 0);

		assertThat(point1, is(not(equalTo(point2))));
	}

	@Test
	public void testEqualsWithPointsWithDifferentY() {
		Point point1 = new Point(0, 1);
		Point point2 = new Point(0, 2);

		assertThat(point1, is(not(equalTo(point2))));
	}

	@Test
	public void testEqualsWithNull() {
		Point point = new Point();

		assertThat(point, is(not(equalTo(null))));
	}

	@Test
	public void testEqualsWithDifferentTypeOfObject() {
		Point point = new Point();

		assertThat(point, is(not(equalTo(new Object()))));
	}

	@Test
	public void testHashCode() {
		Point point = new Point();

		assertThat(point.hashCode(), is(equalTo(961)));
	}

	@Test
	public void testToString() {
		Point point = new Point(7L, 1L);

		assertThat(point.toString(), is(equalTo("7 1")));
	}

	@Test
	public void testPolarAngleComparator() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		Point point3 = new Point(10, 0);

		List<Point> points = Arrays.asList(point1, point2, point3, point2);

		Point lowestPoint = Collections.min(points);

		PolarAngleComparator polarAngleComparator = new PolarAngleComparator(lowestPoint);

		Collections.sort(points, polarAngleComparator);

		assertThat(points.get(0), is(equalTo(point1)));
		assertThat(points.get(1), is(equalTo(point3)));
		assertThat(points.get(2), is(equalTo(point2)));
		assertThat(points.get(3), is(equalTo(point2)));
	}

	@Test(expected = NullPointerException.class)
	public void testPolarAngleComparatorWithNullLowestPoint() {
		new PolarAngleComparator(null);
	}

}
