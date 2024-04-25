package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class HomePage {
	
	DriverSet context;
	
	public HomePage(DriverSet context) {
		this.context = context;
	}
	
//	String text = driver.findElement(By.xpath("(//h1[normalize-space()='Hello VEC'])[1]")).getText();
//	System.out.println(text);
	
	By hello = By.xpath("(//h1[normalize-space()='Hello VEC - 1'])[1]");
	By facultyCount = By.xpath("(//span[@class='text-3xl'])[1]");
	By studentCount = By.xpath("(//span[@class='text-3xl'])[2]");
	By branchCount = By.xpath("(//span[@class='text-3xl'])[3]");
	By month = By.xpath("//h1[normalize-space()='April, 2024']");
	By profileEdit = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div");
	
	public void clickProfileEdit() {
		context.driver.findElement(profileEdit).click();
	}
	
	
	
	
}
