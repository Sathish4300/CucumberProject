package Modules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class SupportFields {
	
	
	DriverSet context;
	public SupportFields(DriverSet context){
		this.context = context;
	}
	
	By emailID = By.xpath("//input[@name='emailId']");
	By pointOfContact = By.xpath("//input[@name='pointOfContact']");
	By mobileNo = By.xpath("//input[@name='mobileNumber']");
	By suportType = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div/div[4]/div/div");
	By technical = By.xpath("//li[@data-value='Technical']");
	By support = By.xpath("//li[@data-value='General']");
	By priority = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div/div[5]/div/div");
	By low = By.xpath("//li[@data-value='Low']");
	By medium = By.xpath("//li[@data-value='Medium']");
	By high = By.xpath("//li[@data-value='High']");
	By subject = By.xpath("//input[@name='subject']");
	By des = By.xpath("//textarea[@name='description']");
	By upload = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div/label");
	
	public void enterEmail(String name) {
		context.driver.findElement(emailID).sendKeys(name);
	}
	public void enterPOC(String name) {
		context.driver.findElement(pointOfContact).sendKeys(name);
	}
	public void enterMobileNO(String name) {
		context.driver.findElement(mobileNo).sendKeys(name);
	}
	public void clickTechnical() {
		context.driver.findElement(suportType).click();
		context.driver.findElement(technical).click();
	}
	public void clickGeneral() {
		context.driver.findElement(suportType).click();
		context.driver.findElement(support).click();
	}
	public void lowPriority() {
		context.driver.findElement(priority).click();
		context.driver.findElement(low).click();
	}
	public void mediumPriority() {
		context.driver.findElement(priority).click();
		context.driver.findElement(medium).click();
	}
	public void highPriority() {
		context.driver.findElement(priority).click();
		context.driver.findElement(high).click();
	}
	public void enterSubject(String name) {
		context.driver.findElement(subject).sendKeys(name);
	}
	public void enterDes(String name) {
		context.driver.findElement(des).sendKeys(name);
	}
	
	public void uploadDOC() throws Exception {
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
	
	public void uploadVideos() throws Exception {
		context.driver.findElement(upload).click();
		Thread.sleep(3000);
		String file1 = "C:\\Users\\dinesh\\Downloads\\Cricket Bowling 150fps 1200.avi";
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
}
