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
import Modules.StudentFields;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class StudentModule {
	
	public DashboardModule dashboard;
	public BranchPage branch;
	public  BranchFields image;
	public    StudentFields student;
	DriverSet context;
	public StudentModule(DriverSet context){
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the Student menu.")
	public void once_user_enter_the_homepage_click_the_student_menu() {
	   dashboard = new DashboardModule(context);
	   dashboard.clickStudent();
	}
	@Given("User click the add student button")
	public void user_click_the_add_student_button() {
	     branch = new BranchPage(context);
	     branch.clickAddBranch();
	}
	@When("Enter the valid crendials like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}.")
	public void enter_the_valid_crendials_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) throws InterruptedException, AWTException {
	   image = new BranchFields(context);
	   image.uploadImage();
	   student = new StudentFields(context);
	   student.enterStudentName(string);
	   student.enterStudentID(string2);
	   student.selectCourses();
	   student.academicYear();
	   student.semester();
	   student.sectionName();
	   student.enterAdmissionNo(string3);
	   student.enterEmail(string4);
	   //student.enterDOJ(string5);
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[4]/div/div/button")).click();
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[2]")).click();
	   Thread.sleep(2000);
	   student.enterMobile(string6);
	   Thread.sleep(2000);
	  // student.enterDOB(string7);
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[5]/div/div/button")).click();
	   context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[2]")).click();
	   Thread.sleep(2000);
	   student.enterPassword(string8);
	   student.enterCloud(string9);
	   student.enterParentName(string10);
	   student.selectGender();
	   student.enterAddress1(string11);
	   student.enterAddress2(string12);
	   student.enterParentNum(string13);
	   student.selectCountry();
	   student.selectStates();
	   student.selectDistrict();
	   student.enterPincode("12345678");
	   student.enterDes(string14);
	   
	   
	}
	@Then("Click the submit button")
	public void click_the_submit_button() {
	    image.clickSubmit();
	    context.driver.findElement(By.xpath("//button[@id='pagination-last-page']")).click();
	    String cha = "Students - 001";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
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
	@And("Check the count has been increased or not in homepage.")
	public void check_the_count_has_been_increased_or_not_in_homepage() throws InterruptedException {
		String text = context.driver.findElement(By.xpath("//span[@class='sc-bYUneI sc-kMbQoj efFWSV jeKBgP']")).getText();
    	System.out.println(text);
    	String input = text;
    	int lastNumber = Integer.parseInt(input.split(" ")[2]); 
    	System.out.println(lastNumber);
    	String string = Integer.toString(lastNumber);
    	dashboard.clickHome();
    	Thread.sleep(2000);
    	String text2 = context.driver.findElement(By.xpath("(//span[@class='text-3xl'])[2]")).getText();
    	System.out.println(text2);
    	Assert.assertEquals(string, text2);
	}
	
	@When("Without enter any data in student page.")
	public void without_enter_any_data_in_student_page() {
	    
	}
	@Then("Check how it behaves in student menu.")
	public void check_how_it_behaves_in_student_menu() {
		String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/student/add%20student";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@Then("Click the submit button in student page.")
	public void click_the_submit_button_in_student_page() {
	    BranchFields submit = new BranchFields(context);
	    submit.clickSubmit();
	}
	@And("Check the Error message showing or not in student page.")
	public void check_the_error_message_showing_or_not_in_student_page() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Email ID is already exist']"));
			
			WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(findElement1));
			String errorMessage = findElement1.getText();
			String errorMessage1 = "Email ID is already exist";
			Assert.assertEquals(errorMessage, errorMessage1);
	}
	// Student created successfully
	
	@Then("Check error message showing or not like admission id already exists")
	public void check_error_message_showing_or_not_like_admission_id_already_exists() throws Exception {
		throw new Exception("Admission ID Validation Must");
	}
	
	@When("Enter the valid crendials like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}.")
	public void enter_the_valid_crendials_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) throws InterruptedException, AWTException {
		image = new BranchFields(context);
		   image.uploadImage();
		   student = new StudentFields(context);
		   student.enterStudentName(string);
		   student.enterStudentID(string2);
		   student.selectCourses();
		   student.academicYear();
		   student.semester();
		   student.sectionName();
		   student.enterAdmissionNo(string3);
		   student.enterEmail(string4);
		   student.enterMobile(string5);
		  // student.enterDOB(string7);
		   Thread.sleep(2000);
		   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[5]/div/div/button")).click();
		   context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[3]/button[2]")).click();
		   Thread.sleep(2000);
		   student.enterPassword(string6);
		   student.enterCloud(string7);
		   student.enterParentName(string8);
		   student.selectGender();
		   student.enterAddress1(string9);
		   student.enterParentNum(string10);
		   student.selectCountry();
		   student.selectStates();
		   student.selectDistrict();
		   student.enterPincode(string11);
		  
	}
	@Then("Check the value present in student page or not.")
	public void check_the_value_present_in_student_page_or_not() {
	    context.driver.findElement(By.xpath("//button[@id='pagination-last-page']")).click();
	    String cha = "Students - 003";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
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
	
	@When("Enter the valid crendial like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}.")
	public void enter_the_valid_crendial_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) throws InterruptedException, AWTException {
		image = new BranchFields(context);
		   image.uploadImage();
		   student = new StudentFields(context);
		   student.enterStudentName(string);
		   student.enterStudentID(string2);
		   student.selectCourses();
		   student.academicYear();
		   student.semester();
		   student.sectionName();
		   student.enterAdmissionNo(string3);
		   student.enterEmail(string4);
		   student.enterMobile(string5);
		  // student.enterDOB(string7);
		  context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[5]/div/input")).sendKeys("15/03/2000");
		   student.enterPassword(string6);
		   student.enterCloud(string7);
		   student.enterParentName(string8);
		   student.selectGender();
		   student.enterAddress1(string9);
		   student.enterParentNum(string10);
		   student.selectCountry();
		   student.selectStates();
		   student.selectDistrict();
		   student.enterPincode(string11);
	}
	@Then("Check the values present in student page or not.")
	public void check_the_values_present_in_student_page_or_not() throws Exception {
		 context.driver.findElement(By.xpath("//button[@id='pagination-last-page']")).click();
		    String cha = "Students - 004";
		    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals(cha)) {
	    			throw new Exception("Date Validation Didn't Work");
	    		}
	    		else {
	    			System.out.println("Created Not successfully");
	    			}
	    	}
	}
	
	@When("Clear the ID Values.")
	public void clear_the_id_values() throws InterruptedException {
	    Thread.sleep(2000);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[1]/div/input")).clear();
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[2]/div/input")).clear();
	   // context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[3]/div/input")).clear();
	    
	}
	
	@When("Enter the negative values in email,mobile no,pincode etc..")
	public void enter_the_negative_values_in_email_mobile_no_pincode_etc() throws Exception {
	    throw new Exception("Validation Must in Email,Mobile No,Pincode");
	}
	
	@Given("User search the some word in search box like {string} in student menu.")
	public void user_search_the_some_word_in_search_box_like_in_student_menu(String string) {
	    BranchPage page = new BranchPage(context);
	    page.enterSearch(string);
	}
	@Then("Grab all the text and check all the word this char is present or not in student menu.")
	public void grab_all_the_text_and_check_all_the_word_this_char_is_present_or_not_in_student_menu() throws Exception {
		 String cha = "S";
		    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		System.out.println(text);
	    		if(text.contains(cha)) {
	    			System.out.println("Working Fine");
	    		}
	    		else {
	    			System.out.println("Working not fine");
	    			}
	    	}
		
	}
	
	@Given("User search irrelevant word like {string} in student mmenu.")
	public void user_search_irrelevant_word_like_in_student_mmenu(String string) {
		 BranchPage page = new BranchPage(context);
		    page.enterSearch(string);
	}
	@Then("Error Text is showing or not in student.")
	public void error_text_is_showing_or_not_in_student() throws Exception {
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
	
	@Given("User click the view icon.")
	public void user_click_the_view_icon() {
	   context.driver.findElement(By.xpath("(//div[@id='row-0']//div[@class='flex flex-row items-center gap-4']//*[name()='svg'])[1]")).click();
	}
	@Then("Check all the values present or not.")
	public void check_all_the_values_present_or_not() {
	   System.out.println("All Values are present");
	}
	
	@Given("User click the edit icon in Student page.")
	public void user_click_the_edit_icon_in_student_page() throws InterruptedException {
		//Thread.sleep(2000);
		  //context.driver.findElement(By.xpath("//button[@id='pagination-last-page']")).click();
		 
		 context.driver.findElement(By.xpath("//div[@id='row-0']//a//*[name()='svg']//*[name()='path' and contains(@d,'M402.6 83.')]")).click();
	}
	@When("Edit some values in Student fields.")
	public void edit_some_values_in_student_fields() throws InterruptedException {
	    StudentFields student = new StudentFields(context);
	    Thread.sleep(2000);
	    student.enterStudentName("abc");
	    context.driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	@Then("Check edited data showing or not in Student menu.")
	public void check_edited_data_showing_or_not_in_student_menu() {
		 context.driver.findElement(By.xpath("//button[@id='pagination-last-page']")).click();
		    String cha = "Students - 1abc";
		    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals(cha)) {
	    			System.out.println("Updated Successfully");
	    		}
	    		else {
	    			System.out.println("Updated Not successfully");
	    			}
	    	}
	}

	@Given("User click the delete icon in student")
	public void user_click_the_delete_icon_in_student() {
	   
	}
	@When("User click yes option in student")
	public void user_click_yes_option_in_student() {
	    
	}
	@Then("Check deleted data is showing or not in student menu.")
	public void check_deleted_data_is_showing_or_not_in_student_menu() {
	   System.out.println("Deleted Successfully");
	}

	
}
