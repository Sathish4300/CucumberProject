package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webdriver.DriverSet;

public class SetUpAndTearDown {
	
	DriverSet context;
	public SetUpAndTearDown(DriverSet context) {
		this.context = context;
	}
	
	@Before
	public void browserSetUp(Scenario scenario) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			context.driver = new ChromeDriver();
		}
		context.driver.get(url);
		context.driver.manage().window().maximize();
		context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		context.driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dummy@gmail.com");
		context.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
		context.driver.findElement(By.xpath("//button[text()='Login']")).click();
	}
	
	@After
	public void browserTearDown() {
		context.driver.quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File screenshotAs = ((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
			// convert file to byte
			byte[] readFileToByteArray = FileUtils.readFileToByteArray(screenshotAs);
			scenario.attach(readFileToByteArray, "image/png", "image");	
		}
	}

}
