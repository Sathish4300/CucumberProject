package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features",glue = {"stepDefinitions","hooks"},monochrome = true,dryRun = !true,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
