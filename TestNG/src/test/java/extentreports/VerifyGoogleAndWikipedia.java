package extentreports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class VerifyGoogleAndWikipedia {
	WebDriver driver;
	ExtentReports extentreport;
	ExtentSparkReporter sparkreport;
	ExtentTest testcase;

	@BeforeTest
	public void openChrome() {
		extentreport = new ExtentReports();
		sparkreport = new ExtentSparkReporter("Report.html");
		extentreport.attachReporter(sparkreport);
		extentreport.setSystemInfo("Tester", "Ranjith");
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void closeChrome() {
		if (driver != null) {
			driver.quit();
			extentreport.flush();
		}
	}

	@Test
	public void openGoogle() {
		testcase = extentreport.createTest("Verify google title");
		testcase.info("Open google");
		String googleUrl = "https://www.google.com/";
		driver.get(googleUrl);
		String actualgoogleTitle = driver.getTitle();
		String expectedgoogleTitle = "Google";
		if (actualgoogleTitle.equalsIgnoreCase(expectedgoogleTitle)) {
			System.out.println("Google Title: " + actualgoogleTitle);
			testcase.pass("TC1 Pass");
		} else {
			testcase.fail("TC2 Fail");
		}
	}

	@Test(priority = 1)
	public void openwikipedia() {
		testcase = extentreport.createTest("Verify bing title");
		testcase.info("Open wikipedia");
		String wifipediaUrl = "https://www.wikipedia.org/";
		driver.get(wifipediaUrl);
		String actualTitle = driver.getTitle();
		String expectedTitle = "wikipedia";
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Bing Title: " + actualTitle);
			testcase.pass("TC2 Pass");
		} else {
			testcase.fail("TC2 Fail");
		}
	}
}
