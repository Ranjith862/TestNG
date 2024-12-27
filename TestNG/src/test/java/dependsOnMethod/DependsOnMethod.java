package dependsOnMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test
	public void start() {
		System.out.println("Start the Car");
	}

	@Test(dependsOnMethods = { "start" })
	public void drive() {
		System.out.println("Drive the Car");
	}

	@Test(dependsOnMethods = { "drive" })
	public void slow() {
		Assert.fail();
		System.out.println("Slow the Car");
	}

	@Test(dependsOnMethods = { "slow" },alwaysRun=true)
	public void stop() {
		System.out.println("Stop the Car");
	}
}
