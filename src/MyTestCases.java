import org.testng.annotations.Test;

public class MyTestCases extends TestData {

	// Instance of the FlightSection class
	FlightSection flightsection = new FlightSection();

	/**
	 * Test case to randomly change the website's language between Arabic and
	 * English.
	 */
	@Test(priority = 1)
	public void languageOfTheWebsite() {
		flightsection.languageOfTheWebsiteTest();
	}

	/**
	 * Test case to select a random city in the "from" and "to" inputs.
	 */
	@Test(priority = 2)
	public void randomCity() {
		flightsection.randomCityTest();
	}

	/**
	 * Test case to change the departure date to the beginning of February and
	 * return date to the end of February.
	 */
	@Test(priority = 3)
	public void departureDateAndReturnDate() {
		flightsection.depatureDateAndReturnDateTest();
	}

	/**
	 * Test case to change the flight class to "Business Class" and click on the
	 * search button.
	 */
	@Test(priority = 4)
	public void changeTheClass() {
		flightsection.changeTheClassTest();
	}

}
