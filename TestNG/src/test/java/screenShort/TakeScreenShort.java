package screenShort;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeScreenShort {
	
	WebDriver driver;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://leafground.com/messages.xhtml");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void takeScreenShort() throws IOException {
		 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File practicescreenshort= new File("D:\\ScreenShrotSelenium\\practice.png");
		 FileUtils.copyFile(src, practicescreenshort);		 
	}
}
