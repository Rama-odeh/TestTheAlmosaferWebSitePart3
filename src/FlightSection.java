import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FlightSection extends TestData {

	// Method to check the language of the website
	public void languageOfTheWebsiteTest() {
		String ExpectedEnLanguage = "en"; // Expected language for English version
		String ExpectedArLanguage = "ar"; // Expected language for Arabic version
		String[] language = { "https://www.almosafer.com/ar/", "https://www.almosafer.com/en/" };

		// Select a random language from the array
		int randomIndex = random.nextInt(language.length);
		driver.get(language[randomIndex]);

		// Verify the language based on the URL
		if (driver.getCurrentUrl().contains("en")) {
			WebElement HtmlTag = driver.findElement(By.tagName("html"));
			String ActualLanguage = HtmlTag.getAttribute("lang");
			Assert.assertEquals(ActualLanguage, ExpectedEnLanguage); // Assert that the language is English
		}

		if (driver.getCurrentUrl().contains("ar")) {
			WebElement HtmlTag = driver.findElement(By.tagName("html"));
			String ActualLanguage = HtmlTag.getAttribute("lang");
			Assert.assertEquals(ActualLanguage, ExpectedArLanguage); // Assert that the language is Arabic
		}
	}

	// Method to select random cities for the flight
	public void randomCityTest() {

		if (driver.getCurrentUrl().contains("en")) {
			// List of available cities in English
			List<String> cities = Arrays.asList("Amman", "Dubai", "Cairo", "London", "Paris", "New York");
			String fromCity = cities.get(random.nextInt(cities.size())); // Select a random city

			// Enter the selected city in the "from" input field
			WebElement fromCityInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__FromAirportInput']"));
			fromCityInput.sendKeys(fromCity);
			Assert.assertEquals(fromCityInput.getAttribute("value"), fromCity); // Verify the correct city is entered

			// Select a random city for the "to" input field
			String toCity = cities.get(random.nextInt(cities.size()));
			WebElement toCityInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__ToAirportInput']"));
			toCityInput.sendKeys(toCity);
			Assert.assertEquals(toCityInput.getAttribute("value"), toCity); // Verify the correct city is entered
		}

		if (driver.getCurrentUrl().contains("ar")) {
			// List of available cities in Arabic
			List<String> cities = Arrays.asList("عمان", "دبي", "القاهرة", "لندن", "باريس", "نيويورك");

			// Select a random city in the "from" input field
			String fromCity = cities.get(random.nextInt(cities.size()));
			WebElement fromCityInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__FromAirportInput']"));
			fromCityInput.sendKeys(fromCity);
			Assert.assertEquals(fromCityInput.getAttribute("value"), fromCity); // Verify the correct city is entered

			// Select a random city in the "to" input field
			String toCity = cities.get(random.nextInt(cities.size()));
			WebElement toCityInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__ToAirportInput']"));
			toCityInput.sendKeys(toCity);
			Assert.assertEquals(toCityInput.getAttribute("value"), toCity); // Verify the correct city is entered
		}
	}

	// Method to set departure and return dates
	public void depatureDateAndReturnDateTest() {
		// Click on the departure date input field
		WebElement departureDateInput = driver
				.findElement(By.xpath("//div[@data-testid='FlightSearchBox__FromDateButton']"));
		departureDateInput.click();

		if (driver.getCurrentUrl().contains("en")) {
			String departureMonth = "February"; // The expected departure month
			WebElement selectedReturnDate;
			WebElement selectedDepartureDate;
			while (true) {
				// Find the currently displayed month
				WebElement month = driver
						.findElement(By.xpath("//span[contains(@class, 'sc-jDwBTQ') and contains(@class, 'fKZNof')]"));
				String monthAsText = month.getText();

				// Check if the current month is February
				if (monthAsText.equals(departureMonth)) {
					// Select the first day of February
					selectedDepartureDate = driver
							.findElement(By.xpath("//span[@data-testid='FlightSearchCalendar__2025-02-01']"));
					selectedDepartureDate.click();

					// Select the last day of February
					selectedReturnDate = driver
							.findElement(By.xpath("//span[@data-testid='FlightSearchCalendar__2025-02-28']"));
					selectedReturnDate.click();

					break;
				} else {
					// If not, go to the next month
					driver.findElement(By.xpath("//div[@data-testid='FlightSearchCalendar__NextMonthButton']")).click();
				}
			}
		}

		if (driver.getCurrentUrl().contains("ar")) {
			String departureMonth = "فبراير"; // The expected month in Arabic
			WebElement selectedDepartureDate;
			WebElement selectedReturnDate;
			while (true) {
				// Find the currently displayed month
				WebElement month = driver
						.findElement(By.xpath("//span[contains(@class, 'sc-jDwBTQ') and contains(@class, 'iOJoIg')]"));
				String monthAsText = month.getText();

				// Check if the current month is "فبراير" (February)
				if (monthAsText.equals(departureMonth)) {
					// Select the first day of February
					selectedDepartureDate = driver
							.findElement(By.xpath("//span[@data-testid='FlightSearchCalendar__2025-02-01']"));
					selectedDepartureDate.click();

					// Select the last day of February
					selectedReturnDate = driver
							.findElement(By.xpath("//span[@data-testid='FlightSearchCalendar__2025-02-28']"));
					selectedReturnDate.click();

					break;
				} else {
					// If not, go to the next month
					driver.findElement(By.xpath("//div[@data-testid='FlightSearchCalendar__NextMonthButton']")).click();
				}
			}
		}
	}

	// Method to change the class type for the flight
	public void changeTheClassTest() {
		// Click on the cabin type dropdown
		WebElement cabinDropdown = driver
				.findElement(By.xpath("//div[@data-testid='FlightSearchBox__CabinTypeDropdown']"));
		cabinDropdown.click();

		// Select "Business Class"
		WebElement businessClassOption = driver
				.findElement(By.xpath("//div[@data-testid='FlightSearchCabinSelection__BusinessOption']"));
		businessClassOption.click();

		// Click on the search button
		WebElement searchButton = driver
				.findElement(By.xpath("//button[@data-testid='FlightSearchBox__SearchButton']"));
		searchButton.click();
	}

}
