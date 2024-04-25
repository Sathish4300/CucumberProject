package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class FacultyPage {
	
	DriverSet context;
	public FacultyPage(DriverSet context) {
		this.context = context;
	}
	// /html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button
	By search = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div/input");
	By addFaculty = By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button");
	By edit = By.xpath("//div[@id='row-2']//a//*[name()='svg']");
	By view = By.xpath("//div[@id='row-0']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M572.52 24')]");
	By delete = By.xpath("//div[@id='row-2']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]");
	
	public void clickAddFaculty() {
		context.driver.findElement(addFaculty).click();
	}
	
	public void searchFaculty(String name) {
		context.driver.findElement(search).sendKeys(name);
	}
}

