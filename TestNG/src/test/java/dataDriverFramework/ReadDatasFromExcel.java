package dataDriverFramework;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDatasFromExcel {
	WebDriver driver;

	@BeforeTest
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
		}
	}

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = "D:\\DataDriverFramework\\Login.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

		// Create a 2D array to hold the data
		Object[][] data = new Object[rowCount - 1][colCount];

		// Loop through rows and columns to populate the data array
		for (int i = 1; i < rowCount; i++) { // Skip the header row
			Row row = sheet.getRow(i);
			data[i - 1][0] = row.getCell(0).getStringCellValue(); // Username
			data[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
		}

		workbook.close();
		fis.close();

		return data;
	}

	@Test(dataProvider = "loginData")
	public void loginFuntion(String uname, String pword) {
		System.out.println("Username: " + uname + ", Password: " + pword);
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);

		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

		username.sendKeys(uname);
		password.sendKeys(pword);
		loginButton.click();

		// Add assertions if necessary to verify login behavior
	}
}
