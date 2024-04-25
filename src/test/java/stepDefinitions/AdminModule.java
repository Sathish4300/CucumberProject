package stepDefinitions;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Modules.BranchFields;
import Modules.BranchPage;
import Modules.DashboardModule;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class AdminModule {
	public  DashboardModule dashboard ;
	public BranchPage branch;
	  public BranchFields image ;
	DriverSet context;
	public AdminModule(DriverSet context) {
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the admin menu.")
	public void once_user_enter_the_homepage_click_the_admin_menu() {
	  dashboard = new DashboardModule(context);
	  dashboard.clickAdmin();
	}
	@Given("Once user enter the admin page click addadmin button.")
	public void once_user_enter_the_admin_page_click_addadmin_button() {
	  branch = new BranchPage(context);
	  branch.clickAddBranch();
	}
	@When("Enter the  all credials in admin.")
	public void enter_the_all_credials_in_admin() throws InterruptedException, AWTException {
	   image = new BranchFields(context);
	   image.uploadImage();
	   context.driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin1");
	   context.driver.findElement(By.xpath("//input[@name='instituteAdminId']")).sendKeys("Admin001");
	   context.driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("admin1@gmail.com");
	   context.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
	   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("325222");
	   List<WebElement> ele1 = context.driver.findElements(By.xpath("//div[@class='ant-switch-handle']"));
	   for(int i =0;i<ele1.size();i++) {
		 ele1.get(i).click();
	   }
	   image.clickSubmit();
	   
	}
	@Then("Check the data has been present or not in admin page.")
	public void check_the_data_has_been_present_or_not_in_admin_page() {
		 List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-2-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals("Admin1")) {
	    			System.out.println("It Matches");
	    		}
	    		else {
	    			System.out.println("This is not matches");
	    			}
	    	}
	}
	
	@When("Click the submit button in admin page.")
	public void click_the_submit_button_in_admin_page() {
		 image = new BranchFields(context);
		 image.clickSubmit();
	}
	@Then("Check how it behave in admin page.")
	public void check_how_it_behave_in_admin_page() {
		 String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/institute%20admin/add%20instituteadmin";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@When("Click the submit and add button in admin page.")
	public void click_the_submit_and_add_button_in_admin_page() {
		image = new BranchFields(context);
		 image.clickSubmitAndAdd();
	}
	@Then("Check how it behave in admin page whether it shows error message or not.")
	public void check_how_it_behave_in_admin_page_whether_it_shows_error_message_or_not() throws InterruptedException, AWTException {
	    // please upload your Profile picture
		
		WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='please upload your Profile picture']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "please upload your Profile picture";
		Assert.assertEquals(errorMessage, errorMessage1);
		image.uploadImage();
		Thread.sleep(2000);
		image.clickSubmitAndAdd();
		// Request failed with status code 500
        WebElement findElement2 = context.driver.findElement(By.xpath("//div[text()='Request failed with status code 500']"));
		
		WebDriverWait wait2 = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.visibilityOf(findElement2));
		String errorMessage2 = findElement1.getText();
		String errorMessage12 = "Enter all details";
		Assert.assertEquals(errorMessage2, errorMessage12);
	}
	
	@Then("Refresh the page and check.")
	public void refresh_the_page_and_check() throws Exception {
	    throw new Exception("Values Overriding");
	}
	
	@When("Enter the  all credials in admin like {string},{string},{string},{string},{string}.")
	public void enter_the_all_credials_in_admin_like(String string, String string2, String string3, String string4, String string5) throws InterruptedException, AWTException {
		 image = new BranchFields(context);
		   image.uploadImage();
		   context.driver.findElement(By.xpath("//input[@name='name']")).sendKeys(string);
		   context.driver.findElement(By.xpath("//input[@name='instituteAdminId']")).sendKeys(string2);
		   context.driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(string3);
		   context.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(string4);
		   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys(string5);
		   String ele = context.driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value");
		   System.out.println(ele);
		   Thread.sleep(2000);
		   if(ele.equals("Admin2")) {
			   context.driver.findElement(By.xpath("(//div[@class='ant-switch-handle'])[1]")).click();
			   image.clickSubmit();
		   }
		   else if(ele.equals("Admin3")) {
			   context.driver.findElement(By.xpath("(//div[@class='ant-switch-handle'])[2]")).click();
			   image.clickSubmit();
		   }
		   else {
			   context.driver.findElement(By.xpath("(//div[@class='ant-switch-handle'])[3]")).click();
			   image.clickSubmit();
		   }
		  
		  
		  
		   
	}
	@Then("Click the respective role in admin.")
	public void click_the_respective_role_in_admin() throws InterruptedException, AWTException {
		 
	}
	
	@When("Enter the  all credials in admin and click the add permission.")
	public void enter_the_all_credials_in_admin_and_click_the_add_permission() throws InterruptedException, AWTException {
		 image = new BranchFields(context);
		   image.uploadImage();
		   context.driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin2");
		   context.driver.findElement(By.xpath("//input[@name='instituteAdminId']")).sendKeys("Admin002");
		   context.driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("admin2@gmail.com");
		   context.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("9887789988");
		   context.driver.findElement(By.xpath("(//div[@class='ant-switch-handle'])[1]")).click();
		   image.clickSubmit();
	}
	
	@When("Enter the  all credials in admin and click the Edit permission.")
	public void enter_the_all_credials_in_admin_and_click_the_edit_permission() throws InterruptedException, AWTException {
		 image = new BranchFields(context);
		   image.uploadImage();
		   context.driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin3");
		   context.driver.findElement(By.xpath("//input[@name='instituteAdminId']")).sendKeys("Admin003");
		   context.driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("admin3@gmail.com");
		   context.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("7878989");
		   context.driver.findElement(By.xpath("(//div[@class='ant-switch-handle'])[2]")).click();
		   image.clickSubmit();
	}
	
	@When("Enter the  all credials in admin and click the delete permission.")
	public void enter_the_all_credials_in_admin_and_click_the_delete_permission() throws InterruptedException, AWTException {
		image = new BranchFields(context);
		   image.uploadImage();
		   context.driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin4");
		   context.driver.findElement(By.xpath("//input[@name='instituteAdminId']")).sendKeys("Admin004");
		   context.driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("admin4@gmail.com");
		   context.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("7878989");
		   context.driver.findElement(By.xpath("(//div[@class='ant-switch-handle'])[3]")).click();
		   image.clickSubmit();
	}
	
	@Given("User click the edit icon in admin")
	public void user_click_the_edit_icon_in_admin() {
	    context.driver.findElement(By.xpath("//div[@id='row-0']//a//*[name()='svg']")).click();
	}
	@Then("Check all values are present in admin")
	public void check_all_values_are_present_in_admin() throws Exception {
	    throw new Exception("Passqord values didn't shows");
	}
	@Then("Enter the  all credials in admin and dont select permission")
	public void enter_the_all_credials_in_admin_and_dont_select_permission() throws InterruptedException, AWTException {
		image = new BranchFields(context);
		   image.uploadImage();
		   context.driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Admin5");
		   context.driver.findElement(By.xpath("//input[@name='instituteAdminId']")).sendKeys("Admin005");
		   context.driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys("admin5@gmail.com");
		   context.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
		   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("7878989");
	}
	
	@But("If it allow its bug.")
	public void if_it_allow_it_s_bug() throws Exception {
		 List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-2-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals("Admin5")) {
	    			throw new Exception("Permission Validation Must");
	    		}
	    		else {
	    			System.out.println("This is not matches");
	    			}
	    	}
	}


}
