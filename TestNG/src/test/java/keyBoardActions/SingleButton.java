package keyBoardActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SingleButton {
	WebDriver driver;
	Actions ac;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		driver.manage().window().maximize();

	}
	
	@AfterTest
	public void closeChrome() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void clickEnter() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void clickSpace() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.SPACE).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void clickBackSpace() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void clickEscape() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void clickDelete() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.DELETE).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void clickArrowUp() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_UP).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 6)
	public void clickArrowDown() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 7)
	public void clickArrowLeft() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_LEFT).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 8)
	public void clickArrowRight() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_RIGHT).perform();
		Thread.sleep(3000);
	}
	
	@Test(priority = 9)
	public void clickFunctionsKey() throws InterruptedException{
		ac = new Actions(driver);
		ac.sendKeys(Keys.F3).perform();
		Thread.sleep(3000);
	}
}
