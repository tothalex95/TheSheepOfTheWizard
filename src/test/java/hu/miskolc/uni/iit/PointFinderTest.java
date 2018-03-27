package hu.miskolc.uni.iit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import hu.miskolc.uni.iit.model.Point;

/**
 * @author Alex Toth
 *
 */
public class PointFinderTest {

	@Test
	public void testFindBestPoint() {
		Point point1 = new Point(0, 0);
		Point point2 = new Point(1, 1);
		Point point3 = new Point(10, 0);

		List<Point> convexHull = Arrays.asList(point1, point3, point2);

		PointFinder optimalPointFinder = new PointFinder();

		Point bestPoint = optimalPointFinder.findBestPoint(convexHull);

		assertThat(bestPoint, is(equalTo(point3)));
	}

}
