package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features",glue = {"stepDefinitions","hooks"},monochrome = true,dryRun = !true,plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNGRunner2 extends AbstractTestNGCucumberTests{
	
}
