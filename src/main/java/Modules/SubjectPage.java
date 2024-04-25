package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class SubjectPage {
	
	DriverSet context;
	
	public SubjectPage(DriverSet context) {
		this.context = context;
	}

	By addSubject = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button");
	
	public void clickAddSubject() {
		context.driver.findElement(addSubject).click();
	}
}
