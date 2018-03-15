package hu.miskolc.uni.iit.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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

}
