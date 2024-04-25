package stepDefinitions;

import java.awt.AWTException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Modules.BranchFields;
import Modules.BranchPage;
import Modules.DashboardModule;
import Modules.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class BranchModule {
	public HomePage homePage;
	public DashboardModule dashboard;
	public  BranchPage branchPage;
	public     BranchFields branchValue;
	public  String lastElementText;
	DriverSet context;
	public BranchModule(DriverSet context) {
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the branch menu.")
	public void once_user_enter_the_homepage_click_the_branch_menu() {
	    homePage = new HomePage(context);
	    dashboard = new DashboardModule(context);
	    dashboard.clickBranch();
	   
	}
	@Given("Click the add branch icon.")
	public void click_the_add_branch_icon() {
	    branchPage = new BranchPage(context);
	    branchPage.clickAddBranch();
	    
	}
	@When("Enter the all credentials like {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void enter_the_all_credentials_like(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) throws InterruptedException, AWTException {
	   branchValue = new BranchFields(context);
	   branchValue.uploadImage();
	   branchValue.enterBranchName(string);
	   branchValue.enterBranchID(string2);
	   branchValue.selectBranch();
	   branchValue.enterEmail(string3);
	   branchValue.enterLandlineNum(string4);
	   branchValue.enterMobileNum(string5);
	   branchValue.enterPassword(string6);
	  // branchValue.enterPassword(string7);
	   branchValue.enterContact(string7);
	   branchValue.enterAddress(string8);
	   branchValue.enterAddress2(string9);
	   branchValue.enterArea(string10);
	   branchValue.selectCountry();
	   branchValue.selectSate();
	   branchValue.selectDistricts();
	   branchValue.enterPincode(string11);
	   branchValue.enterCloudSpace(string12);
	   
	    
	}
	@Then("User click the Submit button.")
	public void user_click_the_submit_button() {
		BranchFields branch = new BranchFields(context);
		branch.clickSubmit();
	   
	}
	@And("Check the count of the faculty.")
	public void check_the_count_of_the_faculty() throws InterruptedException {
		String text = context.driver.findElement(By.xpath("//span[@class='sc-bYUneI sc-kMbQoj efFWSV jeKBgP']")).getText();
    	System.out.println(text);
    	String input = text;
    	int lastNumber = Integer.parseInt(input.split(" ")[2]); 
    	System.out.println(lastNumber);
    	String string = Integer.toString(lastNumber);
    	dashboard.clickHome();
    	Thread.sleep(2000);
    	String text2 = context.driver.findElement(By.xpath("(//span[@class='text-3xl'])[3]")).getText();
    	System.out.println(text2);
    	Assert.assertEquals(string, text2);
    
	}
	@Then("Error Message showing or not.")
	public void error_message_showing_or_not() {
		    WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Email ID is already exist']"));
			
			WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(findElement1));
			String errorMessage = findElement1.getText();
			String errorMessage1 = "Email ID is already exist";
			Assert.assertEquals(errorMessage, errorMessage1);
	}
	
	@Then("Check the created date and time.")
	public void check_the_created_date_and_time() {
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-7-undefined']/div"));

    	int lastIndex = ele.size() - 1; // Get the last index of the array

    	if (lastIndex >= 0) { // Check if the array is not empty
    	    WebElement lastElement = ele.get(lastIndex);
    	    lastElementText = lastElement.getText();
    	    System.out.println(lastElementText);
    	}
    	
    	LocalDate currentdate = LocalDate.now();
   	 DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String fd = date.format(currentdate);
        System.out.println(fd);
        
        
        Assert.assertEquals(lastElementText, fd);
 
	}
	
	@When("Without enter anything click submit button")
	public void without_enter_anything_click_submit_button() {
	    BranchFields branch = new BranchFields(context);
	    branch.clickSubmit();
	}
	@Then("Check the url how its behave")
	public void check_the_url_how_its_behave() {
	   String currentUrl = context.driver.getCurrentUrl();
	   
	   String actualUrl = "https://college.abhisvr360.in.net/homepage/branch/add%20branch";
	   
	   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@When("Enter the all credentials like {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter_the_all_credentials_like1(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) throws InterruptedException, AWTException {
		 branchValue = new BranchFields(context);
		   branchValue.uploadImage();
		   branchValue.enterBranchName(string);
		   branchValue.enterBranchID(string2);
		   branchValue.selectBranch();
		   branchValue.enterEmail(string3);
		   branchValue.enterLandlineNum(string4);
		   branchValue.enterMobileNum(string5);
		   branchValue.enterPassword(string6);
		  // branchValue.enterPassword(string7);
		   branchValue.enterContact(string7);
		   branchValue.enterAddress(string8);
		   branchValue.enterAddress2(string9);
		   branchValue.enterArea(string10);
		   branchValue.selectCountry();
		   branchValue.selectSate();
		   branchValue.selectDistricts();
		   branchValue.enterPincode(string11);
		   branchValue.enterCloudSpace(string12);
	}
	@And("click submit and add icon")
	public void click_submit_and_add_icon() {
	   branchValue.clickSubmit();
	}
//	@And("User click the Submit button.")
//	public void user_click_the_submit_button1() {
//	   branchValue.clickSubmit();
//	   
//	}
	
	@Then("Check the count.")
	public void check_the_count() {
		String text = context.driver.findElement(By.xpath("//span[@class='sc-bYUneI sc-kMbQoj efFWSV jeKBgP']")).getText();
    	System.out.println(text);
    	String input = text;
    	int lastNumber = Integer.parseInt(input.split(" ")[2]); 
    	System.out.println(lastNumber);
    	String string = Integer.toString(lastNumber);
    	dashboard.clickHome();
    	String text2 = context.driver.findElement(By.xpath("(//span[@class='text-3xl'])[3]")).getText();
    	System.out.println(text2);
    	Assert.assertEquals(string, text2);
	}
	
	@And("It need to show error message.")
	public void it_need_to_show_error_message() throws Exception {
		String currentUrl = context.driver.getCurrentUrl();
		System.out.println(currentUrl);
		   
		String actualUrl = "https://college.abhisvr360.in.net/homepage/branch/add%20branch";
		   
		if(currentUrl.equals(actualUrl)) {
			throw new Exception("BugException");
		}
	}
	
	@Given("Search some word like {string}.")
	public void search_some_word_like(String string) {
	    BranchPage page = new BranchPage(context);
		page.enterSearch(string);
	}
	@When("Check All words contains V char.")
	public void check_all_words_contains_v_char() throws Exception {
		String cha = "v";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.contains(cha)) {
    			System.out.println("It contains V char");
    		}
    		else {
    			throw new Exception("CharContainsNotPresent");

    		}
    	}
	}
	
	@When("Error message need to shows.")
	public void error_message_need_to_shows() throws Exception {
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
