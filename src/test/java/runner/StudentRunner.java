package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features/College8_Student.feature",glue = {"stepDefinitions","hooks"},monochrome = true,dryRun = true)
public class StudentRunner extends AbstractTestNGCucumberTests {

}
