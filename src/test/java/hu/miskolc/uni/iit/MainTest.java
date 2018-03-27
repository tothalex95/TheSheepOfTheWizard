package hu.miskolc.uni.iit;

import org.junit.Test;

/**
 * @author Alex Toth
 *
 */
public class MainTest {

	@Test
	public void testMainWithoutArguments() {
		TheSheepOfTheWizard.main(new String[] {});
	}

	@Test
	public void testMainWithNonExistingFile() {
		TheSheepOfTheWizard.main(new String[] { "nonExistingFile" });
	}

	@Test
	public void testMainWithA1() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A1.in" });
	}

	@Test
	public void testMainWithA2() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A2.in" });
	}

	@Test
	public void testMainWithA3() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A3.in" });
	}

	@Test
	public void testMainWithA4() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A4.in" });
	}

	@Test
	public void testMainWithA5() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A5.in" });
	}

	@Test
	public void testMainWithA6() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A6.in" });
	}

	@Test
	public void testMainWithA7() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A7.in" });
	}

	@Test
	public void testMainWithA8() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A8.in" });
	}

	@Test
	public void testMainWithA9() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A9.in" });
	}

	@Test
	public void testMainWithA10() {
		TheSheepOfTheWizard.main(new String[] { "src/main/resources/A10.in" });
	}

}
