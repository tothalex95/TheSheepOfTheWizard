package hu.miskolc.uni.iit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import hu.miskolc.uni.iit.model.Point;

/**
 * @author Alex Toth
 *
 */
public class GrahamScanTest {

	@Test
	public void testGetConvexHull() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		Point point3 = new Point(10, 0);

		List<Point> points = Arrays.asList(point1, point2, point3);

		GrahamScan grahamScan = new GrahamScan();

		List<Point> convexHull = grahamScan.getConvexHull(points);

		assertThat(convexHull.get(0), is(equalTo(point1)));
		assertThat(convexHull.get(1), is(equalTo(point3)));
		assertThat(convexHull.get(2), is(equalTo(point2)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetConvexHullWithEmptyPointList() {
		GrahamScan grahamScan = new GrahamScan();

		grahamScan.getConvexHull(Collections.emptyList());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetConvexHullWithCollinearPoints() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		Point point3 = new Point(2, 2);

		List<Point> points = Arrays.asList(point1, point2, point3);

		GrahamScan grahamScan = new GrahamScan();

		grahamScan.getConvexHull(points);
	}

}
