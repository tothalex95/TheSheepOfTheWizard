package hu.miskolc.uni.iit.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hu.miskolc.uni.iit.model.Point;

/**
 * @author Alex Toth
 *
 */
public class PointReader {

	
	/**
	 * @param path	 The path to the file containing points coordinates.
	 * @return	The list of points from the file.
	 * @throws FileNotFoundException
	 */
	public List<Point> readPointsFromFile(String path) throws FileNotFoundException {
		List<Point> points = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File(path))) {
			int numberOfPoints = scanner.nextInt();

			for (int i = 0; i < numberOfPoints; i++) {
				points.add(new Point(scanner.nextInt(), scanner.nextInt()));
			}
		}

		return points;
	}

}
