package steps;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void beforeScenario() 
	{
		DriverFactory.initializeBrowser();
	}
	
	@After
	public void afterScenario(Scenario scenario) 
	{
		if(scenario.isFailed()) 
		{
			utils.ScreenShotUtil.getScreenShot();
		}
		
		DriverFactory.quitBrowser();
	}
}
