package stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Modules.DashboardModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class AnnouncementModule {
	
	DriverSet context;
	public AnnouncementModule(DriverSet context) {
		this.context = context;
	}
	public DashboardModule dashboard ;
	
	@Given("User click the announcement button")
	public void user_click_the_announcement_button() {
	    DashboardModule dashboard = new DashboardModule(context);
	    dashboard.clickAnnouncement();
	}
	@Given("User click the add announcement")
	public void user_click_the_add_announcement() {
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/button")).click();
	}
	@When("User enter the all credentials")
	public void user_enter_the_all_credentials() throws InterruptedException, AWTException {
	   context.driver.findElement(By.xpath("//input[@name='announcementTitle']")).sendKeys("Announcement");
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[1]/div/div")).click();
	   WebElement ele = context.driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[4]"));
	   context.driver.executeScript("arguments[0].click()", ele);
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[2]/div/div")).click();
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]")).click();
	   context.driver.findElement(By.xpath("//input[@name='contactNumber']")).sendKeys("5667789");
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[3]/div/div/button")).click();
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[3]/button[2]")).click();
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button")).click();
	   context.driver.findElement(By.xpath("//input[@name='contactEmailId']")).sendKeys("ass@gmail.com");
	   context.driver.findElement(By.xpath("//input[@name='announcementSubject']")).sendKeys("ffafa");
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[4]/div/div/button")).click();
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[5]")).click();
	   Thread.sleep(3000);
	   context.driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("dfghjnm");
	   // /html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[3]/label
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[3]/label")).click();
		Thread.sleep(3000);
		String file1 = "C:\\Users\\dinesh\\Downloads\\Treasure+Island+Flowchart+(pdf).pdf";
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
	@Then("Click the submit button in announcement")
	public void click_the_submit_button_in_announcement() {
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[4]/div/button[2]")).click();
	}
	@And("Check the data is present or not in announcement module")
	public void check_the_data_is_present_or_not_in_announcement_module() {
		 String cha = "Announcement";
		    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-2-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals(cha)) {
	    			System.out.println("Created Successfully");
	    		}
	    		else {
	    			System.out.println("Created Not successfully");
	    			}
	    	}
	}
	
}
