package stepDefinitions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Modules.AcaPage;
import Modules.AcademicPage;
import Modules.BranchFields;
import Modules.DashboardModule;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class AcademicModule {
	
	DriverSet context;
	public AcademicModule(DriverSet context) {
		this.context = context;
	}
	public DashboardModule dashboard;
	public AcademicPage acaPage;
	public  AcaPage acaFields;
	@Given("Once user enter the homepage click the Academic menu.")
	public void once_user_enter_the_homepage_click_the_academic_menu() {
	     dashboard = new DashboardModule(context);
	     dashboard.clickAcademicYear();
	    
	}
	@Given("user click the add academic button.")
	public void user_click_the_add_academic_button() {
	  acaPage = new AcademicPage(context);
	  acaPage.clickAddAca();
	  
	   
	}
	@When("Enter the valid credentials.")
	public void enter_the_valid_credentials() throws InterruptedException {
	   acaFields = new AcaPage(context);
	   Thread.sleep(2000);
	   acaFields.clickFromCal();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='May']")).click();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='2024']")).click();
	   Thread.sleep(2000);
	   acaFields.clickToCal();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='Jun']")).click();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='2024']")).click();
	   acaFields.enterWork("15");
	}
	@Then("Click the submit button.")
	public void click_the_submit_button() {
	    BranchFields branch = new BranchFields(context);
	    branch.clickSubmit();
	}
	@Then("Check values has been shows or not.")
	public void check_values_has_been_shows_or_not() {
		 List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-2-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals("2024-05 to 2024-06")) {
	    			System.out.println("It Matches");
	    		}
	    		else {
	    			System.out.println("This is not matches");
	    			}
	    	}
	}
	@Then("Check how it behave.")
	public void check_how_it_behave() {
		 String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/academic%20year/add%20academicdetails";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@When("Enter the vaid input and enter invalid input")
	public void enter_the_vaid_input_and_enter_invalid_input() throws InterruptedException {
		   Thread.sleep(2000);
		   acaFields = new AcaPage(context);
		   Thread.sleep(2000);
		   acaFields.clickFromCal();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='Aug']")).click();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='2024']")).click();
		   Thread.sleep(2000);
		   acaFields.clickToCal();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='May']")).click();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='2027']")).click();
		   acaFields.enterWork("15");
	}
	@But("If the data is present throw error.")
	public void if_the_data_is_present_throw_error() throws Exception {
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-2-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals("2024-08 to 2027-05")) {
    			throw new Exception("To Validation Must");
    		}
    		
    	}

	}
	
	@When("Enter the invalid data in {string}")
	public void enter_the_invalid_data_in(String string) throws InterruptedException {
		   Thread.sleep(2000);
		   acaFields = new AcaPage(context);
		   Thread.sleep(2000);
		   acaFields.clickFromCal();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='Sep']")).click();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='2024']")).click();
		   Thread.sleep(2000);
		   acaFields.clickToCal();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='Apr']")).click();
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("//button[text()='2028']")).click();
		   acaFields.enterWork(string);
	}
	@Then("If it allows throw error.")
	public void if_it_allows_throw_error() throws Exception {
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals("-21")) {
    			throw new Exception("Negative Value Accept in working days Fields");
    		}
    		
    	}
	}
	

@When("Enter some invalid data in working fields.")
public void enter_some_invalid_data_in_working_fields() throws Exception {
	   Thread.sleep(2000);
	   acaFields = new AcaPage(context);
	   Thread.sleep(2000); Thread.sleep(2000);
	   acaFields.clickFromCal();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='Sep']")).click();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='2024']")).click();
	   Thread.sleep(2000);
	   acaFields.clickToCal();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='Oct']")).click();
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//button[text()='2024']")).click();
	   acaFields.enterWork("60");
	   int input = 60;
	   String startDateStr = "September 2024";
       String endDateStr = "October 2024";

       // Define date format
       SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
       System.out.println(dateFormat);

       try {
           // Parse the input strings to Date objects
           java.util.Date startDate = dateFormat.parse(startDateStr);
           System.out.println(startDate);
           java.util.Date endDate = dateFormat.parse(endDateStr);
           System.out.println(endDate);

           // Calculate the difference in milliseconds
           long difference = endDate.getTime() - startDate.getTime();
           System.out.println(difference);
           // Convert milliseconds to days
           long daysDifference = difference / (1000 * 60 * 60 * 24);
           System.out.println(daysDifference);
           int j = (int) daysDifference;
           // Display the result
           System.out.println("Total number of days between " + startDateStr + " and " + endDateStr + " is: " + daysDifference);
           if(input<=j) {
        	   System.out.println("Working Fine");
           }
           else {
        	   throw new Exception("validtion Must");
           }
           
       } catch (ParseException e) {
           System.out.println("Error parsing dates: " + e.getMessage());
       }   
}
@Given("User click the edit icons")
public void user_click_the_edit_icons() {
    context.driver.findElement(By.xpath("//div[@id='row-1']//a//*[name()='svg']//*[name()='path' and contains(@d,'M402.6 83.')]")).click();
    
}
@When("User change working date values")
public void user_change_working_date_values() throws InterruptedException {
	 acaFields = new AcaPage(context);
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//input[@name='NoOfWorkingdays']")).clear();
	   acaFields.enterWork("400");
}
@Then("User click the update icon")
public void user_click_the_update_icon() {
   context.driver.findElement(By.xpath("//button[text()='Update']")).click();;
}
@Then("Check the data has been changed or not")
public void check_the_data_has_been_changed_or_not() throws Exception {
	List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
    for(int i = 0; i<ele.size();i++) {
		String text = ele.get(i).getText();
		System.out.println(text);
		if(text.equals("15400")) {
			System.out.println("Updated Successfully");
		}
		else {
			System.out.println("fine");
		}
    }

}
@When("Click the submit and add button.")
public void click_the_submit_and_add_button() throws Exception {
	 BranchFields branch = new BranchFields(context);
	    branch.clickSubmitAndAdd();
	    throw new Exception("It created one data");
}


	// setTimeout(function(){debugger;}, 5000)
	
@Given("user click the view icon in aca year.")
public void user_click_the_view_icon_in_aca_year() {
   context.driver.findElement(By.xpath("//div[@id='row-0']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M572.52 24')]")).click();
}
@Then("check all the values present or not.")
public void check_all_the_values_present_or_not() throws Exception {
	throw new Exception("Values didn't shows");
}

}
