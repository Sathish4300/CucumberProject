package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class ProfileEdit {
	
	DriverSet context;
	public ProfileEdit(DriverSet context) {
		this.context = context;
	}
	
	By close = By.xpath("//span[@class='anticon anticon-close ant-modal-close-icon']");
	By names = By.xpath("//input[@name='first_name']");
	By password = By.xpath("//input[@name='password']");
	By email = By.xpath("//input[@name='emailId']");
	By mobileNum = By.xpath("//input[@name='mobileNumber']");
	By address = By.xpath("//input[@name='addressLine']");
	By area = By.xpath("//input[@name='area']");
	By district = By.xpath("//input[@name='district']");
	By state = By.xpath("//input[@name='state']");
	By country = By.xpath("//input[@name='country']");
	By submit = By.xpath("//button[@type='submit']");
	
	public void clickClose() {
		context.driver.findElement(close).click();
	}
	public void enterName(String name) {
		context.driver.findElement(names).sendKeys(name);
	}
	
	public void enterPassword(String name) {
		context.driver.findElement(password).sendKeys(name);
	}
	public void enterEmail(String name) {
		context.driver.findElement(email).sendKeys(name);
	}
	public void enterMobile(String name) {
		context.driver.findElement(mobileNum).sendKeys(name);
	}
	public void enterAddress(String name) {
		context.driver.findElement(address).sendKeys(name);
	}
	public void enterArea(String name) {
		context.driver.findElement(area).sendKeys(name);
	}
	public void enterDistrict(String name) {
		context.driver.findElement(district).sendKeys(name);
	}
	public void enterState(String name) {
		context.driver.findElement(state).sendKeys(name);
	}
	public void enterCountry(String name) {
		context.driver.findElement(country).sendKeys(name);
	}
	public void clickUpdate() {
		context.driver.findElement(submit).click();
	}
	

}
