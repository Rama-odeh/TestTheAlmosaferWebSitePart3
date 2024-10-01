import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestData {

	// Initialize WebDriver to access the browser (Chrome) and the website
	protected static WebDriver driver = new ChromeDriver();

	// URL of the websit
	protected static String url = "https://www.almosafer.com/ar/";

	// Random instance for generating random values
	Random random = new Random();

	// Setup environment before running the tests
	@BeforeTest
	public void setup() {
		// Navigate to the URL
		driver.get(url);

		// Delete all cookies to start with a clean browser state
		driver.manage().deleteAllCookies();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Click on the button to select the Saudi Arabia site and prices in SAR
		driver.findElement(By.cssSelector(".sc-jTzLTM.eJkYKb.cta__button.cta__saudi.btn.btn-primary")).click();
	}
}
