package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/College1_Branch.feature",glue = {"stepDefinitions","hooks"},monochrome = true,dryRun = !true,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class BranchPageRunner extends AbstractTestNGCucumberTests{

}
