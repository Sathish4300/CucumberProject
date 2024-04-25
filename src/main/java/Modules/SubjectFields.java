package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class SubjectFields {
	
	DriverSet context;
	public SubjectFields(DriverSet context) {
		this.context = context;
	}
	// /html/body/div[2]/div[1]
	By subjectName = By.xpath("//input[@name='subjectName']");
	By subjectID = By.xpath("//input[@name='subjectId']");
	By subjectCode = By.xpath("//input[@name='subjectCode']");
	By facname = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[2]/div/div/div");
	By facID = By.xpath("//input[@name='facultyId']");
	By checkBox = By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']");
	public void enterSubjectName(String name) {
		context.driver.findElement(subjectName).sendKeys(name);
	}
	
	public void enterSubjectID(String name) {
		context.driver.findElement(subjectID).sendKeys(name);
	}
	
	public void enterSubjectCode(String name) {
		context.driver.findElement(subjectCode).sendKeys(name);
	}
	
	public void clickFacName() {
		context.driver.findElement(facname).click();
		
	}
	
	public void clickCheckBox() {
		context.driver.findElement(checkBox).click();
	}
	
}
