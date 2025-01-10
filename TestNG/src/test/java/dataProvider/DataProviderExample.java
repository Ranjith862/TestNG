package dataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	WebDriver driver;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}

	// Multi dimentinal array for give more than 1 row of datas
	Object[][] validAndInvalidDatas = { { "Invalid", "Invalid", }, { "student", "Password123" } };

	@DataProvider(name = "ValidAndInvalidCases")
	public Object[][] loginWithBothValidAndInvalid() {
		return validAndInvalidDatas;
	}

	@Test(dataProvider = "ValidAndInvalidCases")
	public void loginDemoApp(String uname, String pword) {
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement submitbtn = driver.findElement(By.xpath("//button[@id='submit']"));
		username.sendKeys(uname);
		password.sendKeys(pword);
		submitbtn.click();
	}

	@Test(dependsOnMethods = "loginDemoApp")
	public void logout() {
		WebElement logoutbtn = driver.findElement(By.xpath("//a[text()='Log out']"));
		logoutbtn.click();
	}
}
