package windowsHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandles {
	WebDriver driver;
	String parentWindow;
	Set<String> childTab;

	@BeforeTest
	public void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
	}

	@Test
	public void windowParent() {
		parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window Id: " + parentWindow);
		String parentTitle = driver.getTitle();
		System.out.println("Parent Window Title: " + parentTitle);

		WebElement parentTab = driver.findElement(By.xpath("//span[text()='Open']"));
		parentTab.click();
	}

	@Test(priority = 1)
	public void windowChild() {
		childTab = driver.getWindowHandles();
		for (String handle : childTab) {
			if (!handle.equals(parentWindow)) {
				WebDriver childWindowID = driver.switchTo().window(handle);
				System.out.println("Child Window ID: " + childWindowID);
				String childTitle = driver.getTitle();
				System.out.println("Child Window Title: " + childTitle);
			}
		}

	}

	@AfterTest
	public void closeChromeBrowser() {
		driver.quit();
	}
}
