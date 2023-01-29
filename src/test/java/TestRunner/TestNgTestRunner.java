package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/", glue = "stepDefinationfiles",
monochrome = true, tags = "@mallulaTest", plugin = {"html:target/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}
