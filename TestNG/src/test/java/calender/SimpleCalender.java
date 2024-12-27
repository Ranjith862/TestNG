package calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleCalender {
	WebDriver driver;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void simpleDatePicker() {
		//find Element
		WebElement frame1= driver.findElement(By.className("demo-frame"));
		 // Switch to the iframe
        driver.switchTo().frame(frame1);

        // Locate the Datepicker input field
        WebElement dateField = driver.findElement(By.id("datepicker"));

        // Send the date
        dateField.sendKeys("14/12/2024");

        // Optional: Verify the value
        System.out.println("Date entered: " + dateField.getAttribute("value"));
		
		
	}
}
