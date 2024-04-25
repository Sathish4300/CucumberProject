package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Modules.AcademicPage;
import Modules.BranchFields;
import Modules.CourseFields;
import Modules.DashboardModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class CourseModule {
	public AcademicPage acaPage;
	public BranchFields branch;
	public CourseFields course;
	DriverSet context;
	public CourseModule(DriverSet context) {
		this.context = context;
	}
	@Given("Once user enter the homepage click the Course menu.")
	public void once_user_enter_the_homepage_click_the_course_menu() {
	   DashboardModule dashboard = new DashboardModule(context);
	   dashboard.clickCourse();
	}
	@Given("User click the addCourse icon.")
	public void user_click_the_add_course_icon() {
	     acaPage = new AcademicPage(context);
	     acaPage.clickAddAca();
	    
	}
	@When("Without enter any data")
	public void without_enter_any_data() {
	    
	}
	@Then("Click the submit icon.")
	public void click_the_submit_icon() {
	    branch =  new BranchFields(context);
	    branch.clickSubmit();
	}
	@And("Check how it behaves in course menu.")
	public void check_how_it_behaves_in_course_menu() {
		 String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/course/add%20course";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	// Course created successfully
	
	@When("Enter the all credentials like {string},{string},{string},{string},{string},{string}")
	public void enter_the_all_credentials_like(String string, String string2, String string3, String string4, String string5, String string6) {
	   course = new CourseFields(context);
	   course.enterCourseName(string);
	   course.enterCourseID(string2);
	   course.enterCourseDur(string3);
	   course.enterCourseCode(string4);
	   course.enterCourseKey(string5);
	   course.enterCourseDes(string6);
	}
	@Then("Check the data present in Course page.")
	public void check_the_data_present_in_course_page() throws Exception {
		 WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Course created successfully']"));
			
			WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(findElement1));
			String errorMessage = findElement1.getText();
			String errorMessage1 = "Course created successfully";
			Assert.assertEquals(errorMessage, errorMessage1);
			
			String cha = "IT Dep";
			List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
	    	for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals(cha)) {
	    			System.out.println("Fine");
	    		}
	    		else {
	    			// throw new Exception("Not Matching");
	    			System.out.println("Not Matching");

	    		}
	    	}
	}
	
	@When("Enter the all data like {string},{string},{string},{string},{string} but don't enter courseID")
	public void enter_the_all_data_like_but_don_t_enter_course_id(String string, String string2, String string3, String string4, String string5) {
		course = new CourseFields(context);
		   course.enterCourseName(string);
		   course.enterCourseDur(string2);
		   course.enterCourseCode(string3);
		   course.enterCourseKey(string4);
		   course.enterCourseDes(string5);
	}
	// Course ID is already exist
	@Then("Error Message showing or not in course page.")
	public void error_message_showing_or_not_in_course_page() {
		WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Course ID is already exist']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "Course ID is already exist";
		Assert.assertEquals(errorMessage, errorMessage1);
	}
	
	@Given("User click the edit icon in course page.")
	public void user_click_the_edit_icon_in_course_page() {
	    context.driver.findElement(By.xpath("//div[@id='row-2']//a//*[name()='svg']//*[name()='path' and contains(@d,'M402.6 83.')]")).click();
	}
	
	@When("Check all values showing or not.")
	public void check_all_values_showing_or_not() throws Exception {
	    throw new Exception("Keyword Showing wrong");
	}
	@When("Edit some values.")
	public void edit_some_values() throws InterruptedException {
		course = new CourseFields(context);
		Thread.sleep(2000);
		course.enterCourseName("1");
		context.driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	@Then("Check edited data showing or not.")
	public void check_edited_data_showing_or_not() {
		String cha = "IT Dep1";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals(cha)) {
    			System.out.println("Fine");
    		}
    		else {
    			// throw new Exception("Not Matching");
    			System.out.println("Not Matching");

    		}
    	}
	}
	@Given("User search the some word in search box like {string} in course.")
	public void user_search_the_some_word_in_search_box_like_in_course(String string) {
		acaPage = new AcademicPage(context);
	     acaPage.enterSearch(string);
	}
	@Then("Grab all the text and check all the word this char is present or not in course menu.")
	public void grab_all_the_text_and_check_all_the_word_this_char_is_present_or_not_in_course_menu() {
		String cha = "m";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.contains(cha)) {
    			System.out.println("It Contains M word");
    		}
    		else {
    			// throw new Exception("Not Matching");
    			System.out.println("Not Matching");

    		}
    	}
	}
	@Given("User search irrelevant word like {string} in course.")
	public void user_search_irrelevant_word_like_in_course(String string) {
		acaPage = new AcademicPage(context);
	     acaPage.enterSearch(string);
	}
	@Then("Error Text is showing or not in course.")
	public void error_text_is_showing_or_not_in_course() throws Exception {
		Thread.sleep(2000);
	    String text = context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div/div/div/div")).getText();
	    
	    String expected = "There are no records to display";
	    if(text.equals(expected)) {
	    	System.out.println("Conditions true");
	    }
	    else {
	    	throw new Exception("ConditionFalse");
	    }
	}
	
	@Given("User click the delete icon in course")
	public void user_click_the_delete_icon_in_course() {
	    context.driver.findElement(By.xpath("//div[@id='row-2']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]")).click();
	}
	@When("User click yes option in course")
	public void user_click_yes_option_in_course() {
	   context.driver.findElement(By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']")).click();
	}
	@Then("Check deleted data is showing or not.")
	public void check_deleted_data_is_showing_or_not() throws Exception {
		String cha = "IT Dep1";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		System.out.println(text);
    		if(text.equals(cha)) {
    			throw new Exception("Deleted Not Successfuly");
    		}
    		else {
    			System.out.println("Working Fine");
    			}
    	}
	}

	
	
}
