package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile {
	WebDriver driver;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test
	public void uploadFile() throws InterruptedException {
		//Choose File
		WebElement chooseFile= driver.findElement(By.id("file-upload"));
		chooseFile.sendKeys("C:\\Users\\ADMIN\\Pictures\\Screenshots\\Screenshot (113).png"); //Give correct file and fileType.
		
		Thread.sleep(2000);
		//Upload File
		WebElement uploadFile = driver.findElement(By.id("file-submit"));
		uploadFile.click();
	}
}
