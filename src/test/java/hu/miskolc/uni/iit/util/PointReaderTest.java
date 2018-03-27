package hu.miskolc.uni.iit.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hu.miskolc.uni.iit.model.Point;

/**
 * @author Alex Toth
 *
 */
public class PointReaderTest {

	private PointReader pointReader;

	@Before
	public void setUp() {
		pointReader = new PointReader();
	}

	@Test
	public void testReadPointsFromFileWithExistingFile() throws FileNotFoundException {
		Point expectedPoint1 = new Point(0, 0);
		Point expectedPoint2 = new Point(1, 1);
		Point expectedPoint3 = new Point(10, 0);
		List<Point> expectedPoints = Arrays.asList(expectedPoint1, expectedPoint2, expectedPoint3);

		List<Point> actualPoints = pointReader.readPointsFromFile("src/test/resources/A0.in");

		assertThat(actualPoints.size(), is(equalTo(expectedPoints.size())));

		assertThat(actualPoints, contains(expectedPoint1, expectedPoint2, expectedPoint3));
	}

	@Test(expected = FileNotFoundException.class)
	public void testReadPointsFromFileWithNonExistingFile() throws FileNotFoundException {
		pointReader.readPointsFromFile("nonexistingfilename");
	}

}
