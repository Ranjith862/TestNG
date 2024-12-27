package alertpopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertPoP {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test()
	public void clickForJSAlert() throws InterruptedException {
		WebElement alert1 = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		alert1.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test()
	public void clickForJSConfirm() throws InterruptedException {
		WebElement alert2 = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		alert2.click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	}

	@Test()
	public void clickForJSPromt() throws InterruptedException {
		WebElement alert3 = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		alert3.click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Input Fields");
		driver.switchTo().alert().accept();
	}

	@AfterTest
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
