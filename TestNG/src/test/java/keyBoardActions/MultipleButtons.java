package keyBoardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleButtons {
	WebDriver driver;
	Actions ac;

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
	public void firstName() {
		WebElement enterFirstName = driver.findElement(By.id("j_idt100:firstname"));
		enterFirstName.sendKeys("Ranjith");
		
		String firstNameActualText = enterFirstName.getAttribute("value");
		System.out.println("FirstName Actual Text: "+ firstNameActualText);
		
		ac = new Actions(driver);
		// Press Ctrl + A Select All:
		ac.keyDown(Keys.CONTROL); // Press Ctrl
		ac.sendKeys("A"); // Press A
		ac.keyUp(Keys.CONTROL); // Release Ctrl
		ac.perform(); // Perform actions.

		// Press Ctrl + C Copy:
		ac.keyDown(Keys.CONTROL); // Press Ctrl
		ac.sendKeys("C"); // Press C
		ac.keyUp(Keys.CONTROL); // Release Ctrl
		ac.perform(); // Perform actions.

		// Click TAB:
		ac.sendKeys(Keys.TAB).perform();

		// Press Ctrl + V Copy:
		ac.keyDown(Keys.CONTROL); // Press Ctrl
		ac.sendKeys("V"); // Press C
		ac.keyUp(Keys.CONTROL); // Release Ctrl
		ac.perform(); // Perform actions.
		
		WebElement lastName = driver.findElement(By.id("j_idt100:lastname"));
		String lastNameActualText = lastName.getAttribute("value"); //This method get's actual text in the input field.
		System.out.println("LastName Actual Text: "+lastNameActualText);
		
		if(firstNameActualText.equals(lastNameActualText)) {
			System.out.println("Copyied and paste successfully...");
		}
		else {
			System.out.println("Not copied..");
		}

	}
}
