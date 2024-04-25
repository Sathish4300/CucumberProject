package Modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import webdriver.DriverSet;

public class BranchFields {
	
	DriverSet context;
	public BranchFields(DriverSet context) {
		this.context = context;
	}
	
	By upload = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[1]/label/span/div");
	By branchName = By.xpath("//input[@name='branchName']");
	By branchId = By.xpath("//input[@name='branchId']");
	By branchType = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[2]/div/div");
	By branchTypeValue = By.xpath("//li[@data-value='College']");
	By email = By.xpath("//input[@name='emailId']");
	By landlineNum = By.xpath("//input[@name='landlineNumber']");
	By mobileNum = By.xpath("//input[@name='mobileNumber']");
	By password = By.xpath("//input[@name='password']");
	By pointOfContact = By.xpath("//input[@name='pointOFContact']");
	By address1 = By.xpath("//input[@name='addressLine1']");
	By address2 = By.xpath("//input[@name='addressLine2']");
	By area = By.xpath("//input[@name='area']");
	By country = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[6]/div/div");
	By selectCountry = By.xpath("//li[@data-value='India']");
	By state = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[7]/div/div");
	By selectTamil = By.xpath("//li[@data-value='Tamil Nadu']");
	By district = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[7]/div/div");
	By selectDistrict = By.xpath("//li[@data-value='Chennai']");
	By pincode = By.xpath("//input[@name='pincode']");
	By cloud = By.xpath("//input[@name='cloudSpace']");
	By VR = By.xpath("(//span[@class='ant-switch-inner'])[2]");
	By reset = By.xpath("//button[text()='Reset']");
	By submit = By.xpath("//button[text()='Submit']");
	By submitAndAdd = By.xpath("//button[text()='Submit & Add']");
	
	public void uploadImage() throws InterruptedException, AWTException {
		
		context.driver.findElement(upload).click();
		Thread.sleep(3000);
		String file1 = "C:\\Users\\dinesh\\Downloads\\profileimage.jpeg";
		StringSelection selection1 = new StringSelection(file1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterBranchName(String name) {
		context.driver.findElement(branchName).sendKeys(name);
	}
	public void enterBranchID(String name) {
		context.driver.findElement(branchId).sendKeys(name);
	}
	public void selectBranch() {
	   context.driver.findElement(branchType).click();
	   context.driver.findElement(branchTypeValue).click();
	}
	public void enterEmail(String name) {
		context.driver.findElement(email).sendKeys(name);
	}
	public void enterLandlineNum(String name) {
		context.driver.findElement(landlineNum).sendKeys(name);
	}
	public void enterMobileNum(String name) {
		
		context.driver.findElement(mobileNum).sendKeys(name);
	}
	
	public void enterPassword(String name) {
		context.driver.findElement(password).sendKeys(name);
	}
	public void enterContact(String name) {
		context.driver.findElement(pointOfContact).sendKeys(name);
	}
	public void enterAddress(String name) {
		context.driver.findElement(address1).sendKeys(name);
	}
	public void enterAddress2(String name) {
		context.driver.findElement(address2).sendKeys(name);
	}
	public void enterArea(String name) {
		context.driver.findElement(area).sendKeys(name);
	}
	public void selectCountry() {
		context.driver.findElement(country).click();
	    context.driver.findElement(selectCountry).click();
	}
	public void selectSate() {
		context.driver.findElement(state).click();
		WebElement ele = context.driver.findElement(selectTamil);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	public void selectDistricts() {
		context.driver.findElement(district).click();
		WebElement ele = context.driver.findElement(selectDistrict);
		context.driver.executeScript("arguments[0].click()", ele);
	}
	public void enterPincode(String name) {
		context.driver.findElement(pincode).sendKeys(name);
	}
	public void enterCloudSpace(String name) {
		context.driver.findElement(cloud).sendKeys(name);
	}
	public void clickReset() {
		context.driver.findElement(reset).click();
	}
	public void clickSubmit() {
		context.driver.findElement(submit).click();
	}
	public void clickSubmitAndAdd() {
		context.driver.findElement(submitAndAdd).click();
	}
}
