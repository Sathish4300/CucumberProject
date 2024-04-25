package Modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webdriver.DriverSet;

public class StudentFields {
	
	DriverSet context;
	public StudentFields(DriverSet context) {
		this.context = context;
	}
	
	
	By studentName = By.xpath("//input[@name='studentName']");
	By studentID = By.xpath("//input[@name='studentId']");
	By courseName = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[3]/div[1]/div/div");
	By selectCourse = By.xpath("//li[@data-value='Dummy Course']");
	By outerCheckBox = By.xpath("/html/body/div[2]/div[1]");
	By acaYear = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[2]/div/div");
	By selectAcaYear = By.xpath("//li[@data-value='2024-03-2028-03']");
	By sem = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[3]/div[2]/div/div");
	By selectSem = By.xpath("//li[@data-value='semester 2']");
	By secName = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[3]/div/div");
	By selectSect = By.xpath("//li[@data-value='EEE Class 1']");
	By admissionNum = By.xpath("//input[@name='admissionNo']");
	By email = By.xpath("//input[@name='emailId']");
	By doj = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[4]/div/input");
	By mobile = By.xpath("//input[@name='mobileNumber']");
	By dob = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[5]/div/input");
	By pass = By.xpath("//input[@name='password']");
	By cloud = By.xpath("//input[@name='cloudSpace']");
	By parentName = By.xpath("//input[@name='parentName']");
	By gender = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[6]/div/div");
	By selectMale = By.xpath("//li[@data-value='male']");
	By address1 = By.xpath("//input[@name='addressLine1']");
	By address2 = By.xpath("//input[@name='addressLine2']");
	By parentNum = By.xpath("//input[@name='parentNumber']");
	By country = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[3]/div[7]/div/div");
	By selectIndia = By.xpath("//li[@data-value='India']");
	By selectState = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[8]/div/div");
	By selectTamil = By.xpath("//li[@data-value='Tamil Nadu']");
	By selectDis = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[8]/div/div");
	By selectChennai = By.xpath("//li[@data-value='Chennai']");
	By pincode = By.xpath("//input[@name='pincode']");
	By des = By.xpath("//textarea[@name='description']");
	
	
	public void enterStudentName(String name) {
		context.driver.findElement(studentName).sendKeys(name);
	}
	public void enterStudentID(String name) {
		context.driver.findElement(studentID).sendKeys(name);
	}
	public void selectCourses() {
		context.driver.findElement(courseName).click();
		WebElement ele = context.driver.findElement(selectCourse);
		context.driver.executeScript("arguments[0].click()", ele);
		context.driver.findElement(outerCheckBox);
	}
	
	public void academicYear() {
		context.driver.findElement(acaYear).click();
		WebElement ele = context.driver.findElement(selectAcaYear);
		context.driver.executeScript("arguments[0].click()", ele);
		context.driver.findElement(outerCheckBox);
	}
	
	public void semester() {
		context.driver.findElement(sem).click();
		WebElement ele = context.driver.findElement(selectSem);
		context.driver.executeScript("arguments[0].click()", ele);
		context.driver.findElement(outerCheckBox);
	}
	
	public void sectionName() {
		context.driver.findElement(secName).click();
		WebElement ele = context.driver.findElement(selectSect);
		context.driver.executeScript("arguments[0].click()", ele);
		context.driver.findElement(outerCheckBox);
	}
	
	public void enterAdmissionNo(String name) {
		context.driver.findElement(admissionNum).sendKeys(name);
	}
	public void enterEmail(String name) {
		context.driver.findElement(email).sendKeys(name);
	}
	
	public void enterDOJ(String name) {
		context.driver.findElement(doj).sendKeys(name);
	}
	
	public void enterMobile(String name) {
		context.driver.findElement(mobile).sendKeys(name);
	}
	public void enterDOB(String name) {
		context.driver.findElement(dob).sendKeys(name);
	}
	public void enterPassword(String name) {
		context.driver.findElement(pass).sendKeys(name);
	}
	public void enterCloud(String name) {
		context.driver.findElement(cloud).sendKeys(name);
	}
	public void enterParentName(String name) {
		context.driver.findElement(parentName).sendKeys(name);
	}
	public void selectGender() {
		context.driver.findElement(gender).click();
		WebElement ele = context.driver.findElement(selectMale);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	
	public void enterAddress1(String name) {
		context.driver.findElement(address1).sendKeys(name);
	}
	
	public void enterAddress2(String name) {
		context.driver.findElement(address2).sendKeys(name);
	}
	
	public void enterParentNum(String name) {
		context.driver.findElement(parentNum).sendKeys(name);
	}
	public void selectCountry() {
		context.driver.findElement(country).click();
		WebElement ele = context.driver.findElement(selectIndia);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	public void selectStates() {
		context.driver.findElement(selectState).click();
		WebElement ele = context.driver.findElement(selectTamil);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	public void selectDistrict() {
		context.driver.findElement(selectDis).click();
		WebElement ele = context.driver.findElement(selectChennai);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	public void enterPincode(String name) {
		context.driver.findElement(pincode).sendKeys(name);
	}
	public void enterDes(String name) {
		context.driver.findElement(des).sendKeys(name);
	}
	
	
	
}
