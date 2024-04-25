package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webdriver.DriverSet;

public class FacultyFields {
	
	DriverSet context;
	public FacultyFields(DriverSet context) {
		this.context = context;
	}
	// /html/body/div/div/div[1]/div[2]/div[2]/div/form/div[1]/label/span/div
	By upload = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[1]/label/span/div");
	By facultyName = By.xpath("//input[@name='facultyName']");
	By facultyID = By.xpath("//input[@name='facultyId']");
	By employeeCode = By.xpath("//input[@name='employeecode']");
	By qualification = By.xpath("//input[@name='qualification']");
	By gender = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[3]/div/div");
	By selectMale = By.xpath("//li[@data-value='male']");
	By selectFemale = By.xpath("//li[@data-value='female']");
	By email = By.xpath("//input[@name='emailId']");
	By password = By.xpath("//input[@name='password']");
	By mobileNum = By.xpath("//input[@name='mobileNumber']");
	By dob = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[5]/div/input");
	By doj = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[6]/div/input");
	By blood = By.xpath("//input[@name='bloodGroup']");
	By address1 = By.xpath("//input[@name='addressLine1']");
	By area = By.xpath("//input[@name='area']");
	By country = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[8]/div/div");
	By India = By.xpath("//li[@data-value='India']");
	By state = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[8]/div/div");
	By Tamil = By.xpath("//li[@data-value='Tamil Nadu']");
	By district = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[9]/div/div");
	By chennai = By.xpath("//li[@data-value='Chennai']");
	By pincode = By.xpath("//input[@name='pincode']");
	By description = By.xpath("//textarea[@name='description']");
	
	public void enterFacultyName(String name) {
		context.driver.findElement(facultyName).sendKeys(name);
	}
	
	public void enterFacultyID(String name) {
		context.driver.findElement(facultyID).sendKeys(name);
	}
	
	public void enterEmployeeCode(String name) {
		context.driver.findElement(employeeCode).sendKeys(name);
	}
	
	public void enterQualification(String name) {
		context.driver.findElement(qualification).sendKeys(name);
	}
	
	public void selectGender() {
		context.driver.findElement(gender).click();
		context.driver.findElement(selectMale).click();

	}
	
	public void enterEmail(String name) {
		context.driver.findElement(email).sendKeys(name);
	}
	
	public void enterPassword(String name) {
		context.driver.findElement(password).sendKeys(name);
	}
	
	public void enterMobile(String name) {
		context.driver.findElement(mobileNum).sendKeys(name);
	}

	public void enterDOB(String name) {
		context.driver.findElement(dob).sendKeys(name);
	}
	
	public void enterDOJ(String name) {
		context.driver.findElement(doj).sendKeys(name);
	}
	public void enterBlood(String name) {
		context.driver.findElement(blood).sendKeys(name);
	}
	public void enterAddress(String name) {
		context.driver.findElement(address1).sendKeys(name);
	}
	public void enterArea(String name) {
		context.driver.findElement(area).sendKeys(name);
	}
	public void selectCountry() {
		context.driver.findElement(country).click();
		context.driver.findElement(India).click();
		
	}
	
	public void selectState() {
		context.driver.findElement(state).click();
		WebElement ele = context.driver.findElement(Tamil);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	
	public void selectDistrict() {
		context.driver.findElement(district).click();
		WebElement ele = context.driver.findElement(chennai);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	
	public void enterPincode(String name) {
		context.driver.findElement(pincode).sendKeys(name);
	}
	
	public void enterDes(String name) {
		context.driver.findElement(description).sendKeys(name);
	}
}

