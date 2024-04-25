package stepDefinitions;

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
import Modules.ExamFields;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class ExamModule {
	public ExamFields exam;
	public DashboardModule dashboard;
	public BranchPage page;
	public    BranchFields field;
	DriverSet context;
	public ExamModule(DriverSet context) {
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the exam menu.")
	public void once_user_enter_the_homepage_click_the_exam_menu() {
	    dashboard = new DashboardModule(context);
	    dashboard.clickExam();
	    
	}
	@Given("Once user enter the admin page click addExam button.")
	public void once_user_enter_the_admin_page_click_add_exam_button() {
	    page = new BranchPage(context);
	    page.clickAddBranch();
	    
	}
	@When("Enter all credentials in exam module.")
	public void enter_all_credentials_in_exam_module() throws InterruptedException {
	    exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 1");
	    exam.subName();
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[5]/div/div/button")).click();
	    WebElement ele = context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[1]/li[6]"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    //context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[2]/li[1]")).click();
	    Thread.sleep(2000);
	    context.driver.findElement(By.xpath("//button[text()='OK']")).click();
	    Thread.sleep(2000);
	    exam.assignFac();
	    exam.enterTotalMark("10");
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[7]/div/div/button")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[4]/button[2]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button")).click();
	    exam.enterPassMark("5");
	    exam.clickCreateExam();
	    exam.clickCreate();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[2]/input")).sendKeys("Dummy Questions");
	    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[1]/input[2]")).sendKeys("1");
	    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[2]/input")).sendKeys("1");
	    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[3]/div/input")).clear();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[3]/div/input")).sendKeys("10");
	    WebElement ele2 = context.driver.findElement(By.xpath("//button[text()='Submit']"));
	    context.driver.executeScript("arguments[0].click()", ele2);
	    Thread.sleep(2000);
//	     field = new BranchFields(context);
//	    field.clickSubmit();
	    
	    
	    

	    
	}
	@Then("Exam has been created or not.")
	public void exam_has_been_created_or_not() {
		 List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals("Dummy Subject")) {
	    			System.out.println("Its Matches");
	    		}
	    		else {
	    			System.out.println("This is not matches");
	    			}
	    	}
	}
	
	@When("Click the submit button in exam page.")
	public void click_the_submit_button_in_exam_page() {
		field = new BranchFields(context);
	    field.clickSubmit();
	}
	@Then("Check how it behave in exam page.")
	public void check_how_it_behave_in_exam_page() {
		String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/exam/add%20exam";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@When("Click the submit and add button in exam page.")
	public void click_the_submit_and_add_button_in_exam_page() {
		field = new BranchFields(context);
	    field.clickSubmitAndAdd();
	}
	@Then("Check how it behave in exam page whether it shows error message or not.")
	public void check_how_it_behave_in_exam_page_whether_it_shows_error_message_or_not() {
		WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Exam ID is already exist']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "Enter the credentials";
		Assert.assertEquals(errorMessage, errorMessage1);
	}
	@When("Enter all credentials in exam module and select link type.")
	public void enter_all_credentials_in_exam_module_and_select_link_type() throws InterruptedException {
		exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 2");
	    exam.subName();
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[5]/div/div/button")).click();
	    WebElement ele = context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[1]/li[6]"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    //context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[2]/li[1]")).click();
	    Thread.sleep(2000);
	    context.driver.findElement(By.xpath("//button[text()='OK']")).click();
	    Thread.sleep(2000);
	    exam.assignFac();
	    exam.enterTotalMark("10");
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[7]/div/div/button")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[4]/button[2]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button")).click();
	    exam.enterPassMark("5");
	    exam.clickExamLink("https://college.abhisvr360.in.net/homepage/exam/add%20exam");
	    field = new BranchFields(context);
	    field.clickSubmit();
	}
	@Then("Check Exam has been created or not.")
	public void check_exam_has_been_created_or_not() {
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals("Dummy Subject")) {
    			System.out.println("Its Matches");
    		}
    		else {
    			System.out.println("This is not matches");
    			}
    	}
	}
	@When("Enter all credentials in exam module and select file upload.")
	public void enter_all_credentials_in_exam_module_and_select_file_upload() throws Exception {
		exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 3");
	    exam.subName();
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[5]/div/div/button")).click();
	    WebElement ele = context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[1]/li[6]"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    //context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[2]/li[1]")).click();
	    Thread.sleep(2000);
	    context.driver.findElement(By.xpath("//button[text()='OK']")).click();
	    Thread.sleep(2000);
	    exam.assignFac();
	    exam.enterTotalMark("10");
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[7]/div/div/button")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[4]/button[2]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button")).click();
	    exam.enterPassMark("5");
	    exam.clickFile();
	    field = new BranchFields(context);
	    field.clickSubmit();
	}
	
	@When("Enter all credentials in exam modules")
	public void enter_all_credentials_in_exam_modules() throws InterruptedException {
		exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 4");
	    exam.subName();
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[5]/div/div/button")).click();
	    WebElement ele = context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[1]/li[6]"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    //context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[2]/li[1]")).click();
	    Thread.sleep(2000);
	    context.driver.findElement(By.xpath("//button[text()='OK']")).click();
	    Thread.sleep(2000);
	    exam.assignFac();
	    exam.enterTotalMark("10");
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[7]/div/div/button")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[4]/button[2]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button")).click();
	    exam.enterPassMark("5");
	}
	@Then("Throw Errors.")
	public void throw_errors() throws Exception {
	    throw new Exception("Existing Time and date doesn't want to shows");
	}
	@When("Enter all credentials in exam modules except exam type")
	public void enter_all_credentials_in_exam_modules_except_exam_type() throws InterruptedException {
		exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 5");
	    exam.subName();
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[5]/div/div/button")).click();
	    WebElement ele = context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[1]/li[6]"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    //context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/ul[2]/li[1]")).click();
	    Thread.sleep(2000);
	    context.driver.findElement(By.xpath("//button[text()='OK']")).click();
	    Thread.sleep(2000);
	    exam.assignFac();
	    exam.enterTotalMark("10");
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[7]/div/div/button")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[4]/button[2]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/button")).click();
	    exam.enterPassMark("5");
	    field = new BranchFields(context);
	    field.clickSubmitAndAdd();
	}
	@Then("Click submit and add icon and check how it behave.")
	public void click_submit_and_add_icon_and_check_how_it_behave() throws Exception {
	    throw new Exception("Submit and add button didn't work properly");
	}
	// Exam ID is already exist
	@Then("Error Message showing or not in exam page.")
	public void error_message_showing_or_not_in_exam_page() {
		 WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Exam ID is already exist']"));
			
			WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(findElement1));
			String errorMessage = findElement1.getText();
			String errorMessage1 = "Exam ID is already exist";
			Assert.assertEquals(errorMessage, errorMessage1);
	}
	@When("Enter the mandatory fields in exam module.")
	public void enter_the_mandatory_fields_in_exam_module() throws InterruptedException {
		exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 6");
	    exam.subName();
	    exam.assignFac();
	    exam.enterTotalMark("10");
	    exam.enterPassMark("5");
	    field = new BranchFields(context);
	    field.clickSubmit();
	}
	@Then("Check its created or not in exam page.")
	public void check_its_created_or_not_in_exam_page() throws Exception {
	    throw new Exception("Without date how can we schedule the exam?");
	}
	
	// Pass Marks should be less than or equal to Total Marks.
	@When("Enter the validation and in total mark entered {string} and pass mark is {string}.")
	public void enter_the_validation_and_in_total_mark_entered_and_pass_mark_is(String string, String string2) {
		exam = new ExamFields(context);
	    exam.clickCourse();
	    exam.acaYear();
	    exam.semester();
	    exam.secName();
	    exam.enterExamName("Dummy Exam");
	    exam.enterExamID("Exam - 7");
	    exam.subName();
	    exam.assignFac();
	    exam.enterTotalMark(string);
	    exam.enterPassMark(string2);
	    field = new BranchFields(context);
	    field.clickSubmit();
	}
	@Then("Check the error message shows or not related to mark.")
	public void check_the_error_message_shows_or_not_related_to_mark() {
		WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Pass Marks should be less than or equal to Total Marks.']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "Pass Marks should be less than or equal to Total Marks.";
		Assert.assertEquals(errorMessage, errorMessage1);
	}
	@Then("Check the error message shows or not related to mark in exam module.")
	public void check_the_error_message_shows_or_not_related_to_mark_in_exam_module() throws Exception {
	    throw new Exception("Dont allow negative values in mark fiels");
	   
	}
	@When("Enter the values and enter irrelevant answer in answer field")
	public void enter_the_values_and_enter_irrelevant_answer_in_answer_field() throws InterruptedException {
		 exam = new ExamFields(context);
		    exam.clickCourse();
		    exam.acaYear();
		    exam.semester();
		    exam.secName();
		    exam.enterExamName("Dummy Exam");
		    exam.enterExamID("Exam - 1");
		    exam.subName();
     	    exam.assignFac();
		    exam.enterTotalMark("10");
		    exam.enterPassMark("5");
		    exam.clickCreateExam();
		    exam.clickCreate();
		    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[2]/input")).sendKeys("Dummy Questions");
		    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[1]/input[2]")).sendKeys("1");
		    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[2]/input")).sendKeys("saafsa");
		    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[3]/div/input")).clear();
		    context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div[3]/div[3]/div/input")).sendKeys("10");
		    WebElement ele2 = context.driver.findElement(By.xpath("//button[text()='Submit']"));
		    context.driver.executeScript("arguments[0].click()", ele2);
	}
	@When("If its allow its bug.")
	public void if_its_allow_its_bug() throws Exception {
	    throw new Exception("Enter irrelevant answer how it provide marks");
	}
	
	@Given("User search the some word in search box like {string} in exam menu.")
	public void user_search_the_some_word_in_search_box_like_in_exam_menu(String string) {
		 BranchPage page = new BranchPage(context);
		page.enterSearch(string);
	}
	@Then("Grab all the text and check all the word this char is present or not in exam menu.")
	public void grab_all_the_text_and_check_all_the_word_this_char_is_present_or_not_in_exam_menu() throws Exception {
		String cha = "um";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.contains(cha)) {
    			System.out.println("It contains um char");
    		}
    		else {
    			throw new Exception("CharContainsNotPresent");

    		}
    	}
	}
	@Given("Search some word like {string} in exam.")
	public void search_some_word_like_in_exam(String string) {
		 BranchPage page = new BranchPage(context);
		 page.enterSearch(string);
	}
	@When("Error message need to shows in exam.")
	public void error_message_need_to_shows_in_exam() throws Exception {
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
	
	@Given("Click the delete icon in exam")
	public void click_the_delete_icon_in_exam() {
	    context.driver.findElement(By.xpath("//div[@id='row-0']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]")).click();
	}
	@Then("Click the  Yes option in exam")
	public void click_the_yes_option_in_exam() {
		  context.driver.findElement(By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']")).click();
	   // Exam deleted successfully
	   WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Exam deleted successfully']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "Exam deleted successfully";
		Assert.assertEquals(errorMessage, errorMessage1);
	}
	
}
