package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features/College10_Admin.feature",glue = {"stepDefinitions","hooks"},monochrome = true,dryRun = !true)
public class AdminRunner extends AbstractTestNGCucumberTests{

	
	

}
