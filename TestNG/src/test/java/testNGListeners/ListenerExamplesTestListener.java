package testNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerExamplesTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test case start");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test case failed with timeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Start before all test case");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("End after all test case");
	}

}
