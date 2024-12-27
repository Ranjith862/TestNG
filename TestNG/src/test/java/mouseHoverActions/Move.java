package mouseHoverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Move {
	WebDriver driver;
	Actions actions;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void imagesDoubleClick() {
		WebElement images = driver.findElement(By.xpath("//a[text()='Images']"));
		actions = new Actions(driver);
		actions.moveToElement(images).build().perform(); // build() - refresh the action; //perform() - perform the
														// action;
	}

	@AfterTest
	public void closeChrome() {
		driver.quit();
	}
}
