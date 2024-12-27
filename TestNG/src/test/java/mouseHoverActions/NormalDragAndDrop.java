package mouseHoverActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NormalDragAndDrop {
	WebDriver driver;
	Actions actions;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void dragDrop() {
		WebElement A = driver.findElement(By.id("column-a"));
		WebElement B = driver.findElement(By.id("column-a"));
		actions = new Actions(driver);
		actions.dragAndDrop(A, B).perform();
	}
	
	@Test
	public void clickandhold() {
		WebElement A = driver.findElement(By.id("column-a"));
		WebElement B = driver.findElement(By.id("column-a"));
		actions = new Actions(driver);
		actions.clickAndHold(A).moveToElement(B).release().perform();
	}

	@AfterTest
	public void closeChrome() {
		if(driver != null) {
			driver.quit();
		}
	}
}
