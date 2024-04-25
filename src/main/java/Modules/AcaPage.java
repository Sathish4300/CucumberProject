package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webdriver.DriverSet;

public class AcaPage {
	
	DriverSet context;
	public AcaPage(DriverSet context) {
		this.context = context;
	}
	// /html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button
	// /html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div/div[1]/div/div/button
	By fromCal = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div/div[1]/div/div/button");
	By toCal = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div/div[2]/div/div/button");
	By working = By.xpath("//input[@name='NoOfWorkingdays']");
	
	public void clickFromCal() {
		 context.driver.findElement(fromCal).click();
		//context.driver.executeScript("arguments[0].click()", ele);
	}
	public void clickToCal() {
		WebElement ele = context.driver.findElement(toCal);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	public void enterWork(String name) {
		context.driver.findElement(working).sendKeys(name);
	}

}
