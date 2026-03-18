package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features", glue= {"stepdefinitions"},
plugin = {"html:target/cucumber.html"}, tags = "@wip", monochrome = true, dryRun=false)
public class TestRunner extends AbstractTestNGCucumberTests{

}
