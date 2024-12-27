package leafGround;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertBox {
	
	WebDriver driver;
	Alert alert;

	@BeforeTest
	public void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
	}

	@Test
	public void alertSimpleDialog() {
		WebElement alertBox1 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/button/span[2]"));
		alertBox1.click();
		alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void alertConfirmDialog() {
		WebElement alertBox2 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[2]/button/span[2]"));
		alertBox2.click();
		alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public void sweetAlertSimpleDialog() {
		WebElement alertBox3 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[3]/button/span[2]"));
		alertBox3.click();
		WebElement dismiss = driver.findElement(
				By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[3]/div/div[3]/span/button/span[2]"));
		dismiss.click();
	}

	@Test
	public void sweetModelDialog() {
		WebElement alertBox4 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[4]/button/span[2]"));
		alertBox4.click();
		WebElement close = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[4]/div/div[1]/a/span"));
		close.click();
	}

	@Test
	public void alertPromtDialog() {
		WebElement alertBox5 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[1]/button/span[2]"));
		alertBox5.click();
		alert = driver.switchTo().alert();
		alert.sendKeys("Hello Alert Promt..");
		alert.accept();
	}

	@Test
	public void sweetAlertConfirmation() {
		WebElement alertBox6 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[2]/button/span[2]"));
		alertBox6.click();
		WebElement yes = driver.findElement(By.xpath("/html/body/div[7]/div[3]/button[1]/span[2]"));
		yes.click();
	}

	@Test
	public void minimizeMaximize() {
		WebElement alertBox7 = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[3]/button/span[2]"));
		alertBox7.click();
		WebElement maximize = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[3]/div/div[1]/a[2]/span"));
		maximize.click();
		WebElement close = driver
				.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[3]/div/div[1]/a[1]/span"));
		close.click();
	}

	@AfterTest
	public void closeChromeBrowser() {
		driver.quit();
	}

}
