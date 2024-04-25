package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Modules.BranchFields;
import Modules.DashboardModule;
import Modules.SubjectFields;
import Modules.SubjectPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class SubjectModule {
	
	public DashboardModule dashboard;
	public SubjectPage subject;
	public SubjectFields subField;
	public BranchFields branch;
	DriverSet context;
	public SubjectModule(DriverSet context) {
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the Subject menu.")
	public void once_user_enter_the_homepage_click_the_subject_menu() {
		dashboard = new DashboardModule(context);
	     dashboard.clickSubject();
	}
	@Given("User click the add subject icon")
	public void user_click_the_add_subject_icon() {
	     subject = new SubjectPage(context);
	     subject.clickAddSubject();
	    
	}
	@When("User enter the details like {string},{string},{string}.")
	public void user_enter_the_details_like(String string, String string2, String string3) throws InterruptedException {
	     subField = new SubjectFields(context);
	     subField.enterSubjectName(string);
	     subField.enterSubjectID(string2);
	     subField.enterSubjectCode(string3);
	     subField.clickFacName();
	     WebElement ele = context.driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[6]"));
	     context.driver.executeScript("arguments[0].click()", ele);
	     WebElement ele1 = context.driver.findElement(By.xpath("//div[@class='MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-esi9ax']"));
	     context.driver.executeScript("arguments[0].click()", ele1);
	     //Thread.sleep(2000);
	   //  subField.clickFacName();
//	     List<WebElement> ele = context.driver.findElements(By.xpath("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz']"));
//	     for(int i = 0; i<ele.size();i++) {
//	    	 String text = ele.get(i).getText();
//	    	 if(text == "Maths Professor") {
//	    		 context.driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[6]")).click();
//	    	 }
//	     }
	     
	}
	@Then("User click the submit icon.")
	public void user_click_the_submit_icon() throws InterruptedException {
	   Thread.sleep(2000);
	   branch = new BranchFields(context);
	   branch.clickSubmit();
	}
	@And("Check the data present in subject page.")
	public void check_the_data_present_in_subject_page() {
	   List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
	   for(int i = 0; i<ele.size();i++) {
	    	 String text = ele.get(i).getText();
	    	 if(text == "Maths - 1") {
	    		 System.out.println("Element is present");
	    	 }
	}
	}
	
	@Then("Error Message showing or not in subject page.")
	public void error_message_showing_or_not_in_subject_page() throws Exception {
		throw new Exception("Error Message didn't show");
	}
	
	@Then("User can able to clear facID or not.")
	public void user_can_able_to_clear_fac_id_or_not() throws Exception {
		Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//input[@name='facultyId']")).clear();
	   BranchFields branch = new BranchFields(context);
	   branch.clickSubmit();
	   throw new Exception("FacID is possible to able to clear");
	}
	@Then("Check the fac urls how its behave")
	public void check_the_fac_urls_how_its_behave() {
		 String currentUrl = context.driver.getCurrentUrl();
		 System.out.println(currentUrl);
		 
		 String actualUrl = "https://college.abhisvr360.in.net/homepage/subject/add%20subject";
		   
		 Assert.assertEquals(currentUrl, actualUrl);
	}
	@Given("User click the edit icon")
	public void user_click_the_edit_icon() {
	   context.driver.findElement(By.xpath("//div[@id='row-1']//a//*[name()='svg']//*[name()='path' and contains(@d,'M402.6 83.')]")).click();
	}
	@When("Edit some values like {string}")
	public void edit_some_values_like(String string) {
	   SubjectFields field = new SubjectFields(context);
	   field.enterSubjectCode(string);
	}
	@Then("Click the update icon")
	public void click_the_update_icon() {
	   context.driver.findElement(By.xpath("//button[text()='Update']")).click();
	}
	@Then("Check Updated Value is presence or not.")
	public void check_updated_value_is_presence_or_not() {
	   List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
	   for(int i = 0; i<ele.size();i++) {
	    	 String text = ele.get(i).getText();
	    	 if(text == "Maths0012") {
	    		 System.out.println("Element is present");
	    	 }
	}
	}
	
	@Given("Click the deleted icon")
	public void click_the_deleted_icon() {
	    context.driver.findElement(By.xpath("//div[@id='row-1']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]")).click();
	}
	@When("Click the yes option")
	public void click_the_yes_option() {
		WebElement ele = context.driver.findElement(By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']"));
		   context.driver.executeScript("arguments[0].click()", ele);
		   WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Subject deleted successfully']"));
			
			WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(findElement1));
			String errorMessage = findElement1.getText();
			String errorMessage1 = "Subject deleted successfully";
			Assert.assertEquals(errorMessage, errorMessage1);
	}
	@Then("verify deleted faculty is presence or not.")
	public void verify_deleted_faculty_is_presence_or_not() throws Exception {
		String cha = "Maths - 1";
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
	
	@Given("Click the search option")
	public void click_the_search_option() {
	   context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div/input")).click();
	}
	@When("Enter the valid faculty name")
	public void enter_the_valid_faculty_name() {
		 context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div/input")).sendKeys("D");
	}
	@Then("Check the word contains in this fac name")
	public void check_the_word_contains_in_this_fac_name() throws Exception {
		String cha = "D";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.contains(cha)) {
    			System.out.println("It contains D char");
    		}
    		else {
    			throw new Exception("CharContainsNotPresent");

    		}
    	}
	}
	@When("Enter the invalid faculty name")
	public void enter_the_invalid_faculty_name() {
		 context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div/input")).sendKeys("p");

	}
	@Then("Error Text is showing or not in fac.")
	public void error_text_is_showing_or_not_in_fac() throws Exception {
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

	
}
