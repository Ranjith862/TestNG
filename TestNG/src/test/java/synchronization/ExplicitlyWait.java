package synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicitlyWait {
	WebDriver driver;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void implicitwait() {

		//Explicitly Wait - WebDriverWait > It is a Class.
		WebDriverWait wait = new WebDriverWait(driver,20);
		//Check condition when the dropdown is visible then the condition satisfied.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Dropdown']")));
		//After waiting click the dropdown.
		WebElement dropDown = driver.findElement(By.xpath("//button[text()='Dropdown']"));
		dropDown.click();
		// Implicitly wait:
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement gmail = driver.findElement(By.linkText("Gmail"));
		gmail.click();

	}
}
