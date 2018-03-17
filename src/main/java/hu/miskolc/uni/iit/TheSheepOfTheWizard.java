/**
 * 
 */
package hu.miskolc.uni.iit;

import java.io.FileNotFoundException;
import java.util.List;

import hu.miskolc.uni.iit.model.Point;
import hu.miskolc.uni.iit.util.PointReader;

/**
 * @author Alex Toth
 *
 */
public class TheSheepOfTheWizard {

	public static void main(String[] args) {

		String pathname = args.length < 1 ? "src/main/resources/A1.in" : args[0];

		List<Point> points = null;

		try {
			PointReader pointReader = new PointReader();

			points = pointReader.readPointsFromFile(pathname);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}

		GrahamScan grahamScan = new GrahamScan();

		List<Point> convexHull = grahamScan.getConvexHull(points);

		PointFinder optimalPointFinder = new PointFinder();

		Point bestPoint = optimalPointFinder.findBestPoint(convexHull);

		System.out.println(bestPoint);

	}

}
