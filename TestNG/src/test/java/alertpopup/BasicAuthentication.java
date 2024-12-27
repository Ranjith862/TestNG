package alertpopup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicAuthentication {
	WebDriver driver;

	@Test
	public void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //In URL itself we are giving the data for username and password.
		driver.manage().window().maximize();
		driver.close();
	}

}
