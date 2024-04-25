package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class AcademicPage {
	
	DriverSet context;
	public AcademicPage(DriverSet context) {
		this.context = context;
	}
	// /html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button
	By search = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div/input");
	By addAca = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button");
	
	
	public void clickAddAca() {
		context.driver.findElement(addAca).click();
	}
	
	public void enterSearch(String name) {
		context.driver.findElement(search).sendKeys(name);
	}
}
