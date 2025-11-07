package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class TestListener implements ITestListener {

	private static ThreadLocal<ExtentTest> tlTest = new ThreadLocal<ExtentTest>();
	private static ExtentReports reports = ExtentManager.getReports();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = reports.createTest(result.getMethod().getMethodName());
		tlTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tlTest.get().log(Status.INFO, result.getMethod().getMethodName() + " is PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		tlTest.get().log(Status.INFO, result.getThrowable());
		tlTest.get().fail(result.getThrowable());
		ScreenShotUtil.getScreenShot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
