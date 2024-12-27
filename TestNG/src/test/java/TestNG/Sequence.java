package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sequence {
	@BeforeMethod
	void Pan() {
		System.out.println("Clean");
	}

	@Test
	void dosa1() {
		System.out.println("Onion Dossa");
	}

	@Test(priority = 1)
	void dosa2() {
		System.out.println("Rava Dossa");
	}

	@Test(priority = 2)
	void dosa3() {
		System.out.println("Masal Dossa");
	}

	@AfterMethod
	void Clean() {
		System.out.println("Clean Pan");
	}
}
