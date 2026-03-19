package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import utils.ScreenShotUtil;

public class Hooks {

	public static ThreadLocal<ExtentTest> tlTest = new ThreadLocal<>();

	@Before
	public void beforeScenario(Scenario scenario) {

		// Start browser
		DriverFactory.initializeBrowser();

		// Create Extent test
		ExtentTest test = ExtentManager.getReports().createTest(scenario.getName());
		tlTest.set(test);
	}

	@After
	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {

			String path = ScreenShotUtil.getScreenShot();

			tlTest.get().fail("Test Failed")
					.addScreenCaptureFromPath(path);

		} else {
			tlTest.get().pass("Test Passed");
		}

		// Flush report
		ExtentManager.getReports().flush();

		// Close browser
		DriverFactory.quitBrowser();
	}
}