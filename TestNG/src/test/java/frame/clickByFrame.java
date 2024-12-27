package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class clickByFrame {
	WebDriver driver;
	Actions actions;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node01sf5tde79n0ci1x1ygi6nf912k7948422.node0");
		driver.manage().window().maximize();

	}

	@Test
	public void clickMe() {
		WebElement frame1 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/iframe"));
		driver.switchTo().frame(frame1);
		WebElement click1 = driver.findElement(By.id("Click"));
		/*
		 * We can use Mouse Hover Actions also: actions = new Actions(driver);
		 * actions.doubleClick(click1).perform();
		 */
		click1.click();

	}

	@Test
	public void clickMe2() {
		
		driver.switchTo().frame("frame2");
		WebElement click2 = driver.findElement(By.id("Click"));
		// We can use Mouse Hover Actions also:
		actions = new Actions(driver);
		actions.doubleClick(click2).perform();

	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}
}
