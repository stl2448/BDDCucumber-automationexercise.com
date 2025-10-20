package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features", glue="steps",
plugin = {"html:target/cucumber.html"}, monochrome = true, dryRun=false)
public class TestRunner extends AbstractTestNGCucumberTests{

}
