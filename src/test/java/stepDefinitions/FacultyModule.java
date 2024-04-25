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
import Modules.DashboardModule;
import Modules.FacultyFields;
import Modules.FacultyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class FacultyModule {
	
	
	DriverSet context;
	public DashboardModule dashBoard;
	public FacultyPage faculty;
	public FacultyFields facField;
	public String dateText;
	
	public FacultyModule(DriverSet context) {
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the faculty menu.")
	public void once_user_enter_the_homepage_click_the_faculty_menu() {
	     dashBoard = new DashboardModule(context);
	     dashBoard.clickFaculty();
	    
	}
	@Given("Click the add faculty icon.")
	public void click_the_add_faculty_icon() {
	     faculty = new FacultyPage(context);
	     faculty.clickAddFaculty();
	    
	}
	@When("Enter the all credentials like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void enter_the_all_credentials_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14) throws InterruptedException, AWTException {
		// branchField.uploadImage();
		BranchFields branch = new BranchFields(context);
	    branch.uploadImage();
	    facField = new FacultyFields(context);
		facField.enterFacultyName(string);
		facField.enterFacultyID(string2);
		facField.enterEmployeeCode(string3);
		facField.enterQualification(string4);
		facField.selectGender();
		facField.enterEmail(string5);
		facField.enterPassword(string6);
		facField.enterMobile(string7);
		facField.enterDOB(string8);
		facField.enterDOJ(string9);
		facField.enterBlood(string10);
		facField.enterAddress(string11);
		facField.enterArea(string12);
		facField.selectCountry();
		facField.selectState();
		facField.selectDistrict();
		facField.enterPincode(string13);
		facField.enterDes(string14);
	}
	@And("Check the count of the faculty in homepage.")
	public void check_the_count_of_the_faculty_in_homepage() throws InterruptedException {
		String text = context.driver.findElement(By.xpath("//span[@class='sc-bYUneI sc-kMbQoj efFWSV jeKBgP']")).getText();
    	System.out.println(text);
    	String input = text;
    	int lastNumber = Integer.parseInt(input.split(" ")[2]); 
    	System.out.println(lastNumber);
    	String string = Integer.toString(lastNumber);
    	dashBoard.clickHome();
    	Thread.sleep(2000);
    	String text2 = context.driver.findElement(By.xpath("(//span[@class='text-3xl'])[1]")).getText();
    	System.out.println(text2);
    	Assert.assertEquals(string, text2);
	}
	
	@When("Without enter anything click the submit button")
	public void without_enter_anything_click_the_submit_button() {
		BranchFields branch = new BranchFields(context);
	    branch.clickSubmit();
	}
	@Then("Check the urls how its behave")
	public void check_the_urls_how_its_behave() {
		 String currentUrl = context.driver.getCurrentUrl();
		 System.out.println(currentUrl);
		 
		 String actualUrl = "https://college.abhisvr360.in.net/homepage/faculty/add%20faculty";
		   
		 Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@Given("Grab the text  in faculty page")
	public void grab_the_text_in_faculty_page() {
	  dateText = context.driver.findElement(By.xpath("(//div[@id='cell-6-undefined'])[1]")).getText();
	}
	@When("Without enter date fields and enter the remaining field like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void without_enter_date_fields_and_enter_the_remaining_field_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) throws InterruptedException, AWTException {
		BranchFields branch = new BranchFields(context);
	    branch.uploadImage();
	    facField = new FacultyFields(context);
		facField.enterFacultyName(string);
		facField.enterFacultyID(string2);
		facField.enterEmployeeCode(string3);
		facField.enterQualification(string4);
		facField.selectGender();
		facField.enterEmail(string5);
		facField.enterPassword(string6);
		facField.enterMobile(string7);
		facField.enterBlood(string8);
		facField.enterAddress(string9);
		facField.enterArea(string10);
		facField.selectCountry();
		facField.selectState();
		facField.selectDistrict();
		facField.enterPincode(string11);
		facField.enterDes(string12);
	}
	@Then("Check how it behaves.")
	public void check_how_it_behaves() throws Exception {
	   String dateText2 = context.driver.findElement(By.xpath("(//div[@id='cell-6-undefined'])[7]")).getText();
	   if(dateText.equals(dateText2)) {
		   throw new Exception("DateMandatoryFieldDidn'tWork");
	   }
	}
	

	@When("User Select the upcoming date in DOB Fields and enter the remaining details like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}.")
	public void user_select_the_upcoming_date_in_dob_fields_and_enter_the_remaining_details_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) throws InterruptedException, AWTException {
		BranchFields branch = new BranchFields(context);
	    branch.uploadImage();
	    facField = new FacultyFields(context);
		facField.enterFacultyName(string);
		facField.enterFacultyID(string2);
		facField.enterEmployeeCode(string3);
		facField.enterQualification(string4);
		facField.selectGender();
		facField.enterEmail(string5);
		facField.enterPassword(string6);
		facField.enterMobile(string7);
		context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[2]/div[5]/div/div/button")).click();
		context.driver.findElement(By.xpath("//button[text()='10']")).click();
		facField.enterBlood(string8);
		facField.enterAddress(string9);
		facField.enterArea(string10);
		facField.selectCountry();
		facField.selectState();
		facField.selectDistrict();
		facField.enterPincode(string11);
		facField.enterDes(string12);
	}
	@And("Check the condition is True or False.")
	public void check_the_condition_is_true_or_false() throws Exception {
		   String dateText2 = context.driver.findElement(By.xpath("(//div[@id='cell-6-undefined'])[8]")).getText();
		   System.out.println(dateText2);
		   throw new Exception("DateValidationMustInDOB");
	}
	@Then("It need to shows error message.")
	public void it_need_to_shows_error_message() throws Exception {
		String currentUrl = context.driver.getCurrentUrl();
		System.out.println(currentUrl);
		   
		String actualUrl = "https://college.abhisvr360.in.net/homepage/faculty/add%20faculty";
		   
		if(currentUrl.equals(actualUrl)) {
			throw new Exception("BugException");
		}
	}
	
	@Given("User search the some word in search box like {string}.")
	public void user_search_the_some_word_in_search_box_like(String string) {
	    FacultyPage facPage = new FacultyPage(context);
	    facPage.searchFaculty(string);
	}
	@Then("Grab all the text and check all the word this char is present or not.")
	public void grab_all_the_text_and_check_all_the_word_this_char_is_present_or_not() throws Exception {
		String cha = "a";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.contains(cha)) {
    			System.out.println("It contains A char");
    		}
    		else {
    			throw new Exception("CharContainsNotPresent");

    		}
    	}
	}
	
	@Given("User search irrelevant word like {string}.")
	public void user_search_irrelevant_word_like(String string) {
		 FacultyPage facPage = new FacultyPage(context);
		 facPage.searchFaculty(string);
	}
	@Then("Error Text is showing or not.")
	public void error_text_is_showing_or_not() throws Exception {
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
	@Given("Click the Edit icon.")
	public void click_the_edit_icon() {
	    context.driver.findElement(By.xpath("//div[@id='row-6']//a//*[name()='svg']")).click();
	}
	@When("Edit the name like {string}.")
	public void edit_the_name_like(String string) throws InterruptedException {
	   FacultyFields faccField = new FacultyFields(context);
	   Thread.sleep(2000);
	  // context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div[2]/div[1]/div[1]/div[1]/div/input")).clear();
	   faccField.enterFacultyName(string);
	}
	@Then("User click the Update button.")
	public void user_click_the_update_button() {
	    context.driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	@Then("Check values has been changed or not.")
	public void check_values_has_been_changed_or_not() {
		String cha = "robert23";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals(cha)) {
    			System.out.println("It Matches");
    		}
    		else {
    			System.out.println("This is not matches");
    			}
    	}
	}
	// (//div[@id='row-5']//div[@class='flex flex-row items-center gap-4']//*[name()='svg'])[3]
	
	@Given("Click the Delete icon")
	public void click_the_delete_icon() {
	   context.driver.findElement(By.xpath("(//div[@id='row-6']//div[@class='flex flex-row items-center gap-4']//*[name()='svg'])[3]")).click();
	}
	@When("User click the yes option")
	public void user_click_the_yes_option() {
	   WebElement ele = context.driver.findElement(By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']"));
	   context.driver.executeScript("arguments[0].click()", ele);
	   WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Faculty deleted successfully']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "Faculty deleted successfully";
		Assert.assertEquals(errorMessage, errorMessage1);
	}
	@Then("Check the deleted faculty is present or not.")
	public void check_the_deleted_faculty_is_present_or_not() throws Exception {
		String cha = "robert23";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals(cha)) {
    			throw new Exception("Deleted Not Successfuly");
    		}
    		else {
    			System.out.println("Working Fine");
    			}
    	}
	}
}
