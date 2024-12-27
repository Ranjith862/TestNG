package TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvocateandEnabled {

	@BeforeTest
	public void open() {
		System.out.println("open");
	}
	
	@Test(enabled = false)
	public void one() {
		System.out.println("one");
	}
	
	@Test(priority = 1, invocationCount = 5,invocationTimeOut = 3)
	public void two() {
		System.out.println("two");
	}
	
	@Test(priority = 2)
	public void three() {
		System.out.println("three");
	}
	
	@Test(priority = 3)
	public void four() {
		System.out.println("four");
	}
    @AfterTest
    public void close() {
    	System.out.println("close");
    }
}
