package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority {

	@BeforeMethod
	public void openBrowser() {
		System.out.println("Open Chrome Browser.");
	}

	@Test // we dont need to give priority = 0 for this because defaulty it takes.
	public void openGmail() {
		System.out.println("Search Gmail and open...");
	}

	@Test(priority = 1)
	public void openWhatsApp() {
		System.out.println("Search Whatsapp and open...");
	}
    
	@Test(priority = 2)
	public void openGoogleSheet() {
		System.out.println("Search Google Sheet and open...");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Close the Chrome Browser.");
	}
}
