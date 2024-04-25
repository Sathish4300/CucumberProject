package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class BranchPage {
	
	DriverSet context;
	
	public BranchPage(DriverSet context) {
		this.context = context;
	}
	
	By addBranch = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button");
	By search = By.xpath("//input[@type='text']");
	By edit = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[1]/div[12]/div/a");
	By delete = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div[3]/div[12]/div/svg[2]/path[2]");
	By deleteYes = By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']");
	By deleteNo = By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']");
	public void clickAddBranch() {
		context.driver.findElement(addBranch).click();
	}
	public void enterSearch(String name) {
		context.driver.findElement(search).sendKeys(name);
	}
	public void clickEdit() {
		context.driver.findElement(edit).click();
	}
	public void clickDelete() {
		context.driver.findElement(delete).click();
	}
	public void clickDeleteYes() {
		context.driver.findElement(deleteYes).click();
	}
	public void clickDeleteNo() {
		context.driver.findElement(deleteNo).click();
	}
	
}
