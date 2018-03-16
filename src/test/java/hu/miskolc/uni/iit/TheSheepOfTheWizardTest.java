package hu.miskolc.uni.iit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.miskolc.uni.iit.model.PointTest;
import hu.miskolc.uni.iit.util.PointReaderTest;

@RunWith(Suite.class)
@SuiteClasses({
	PointTest.class,
	PointReaderTest.class,
	GrahamScanTest.class,
	PointFinderTest.class
})
public class TheSheepOfTheWizardTest {

}
