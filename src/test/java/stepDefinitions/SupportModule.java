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
import Modules.SupportFields;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class SupportModule {
	public DashboardModule dashboard;
	public  BranchPage page;
	public  SupportFields support;
	public BranchFields submit;
	DriverSet context;
	public SupportModule(DriverSet context) {
		this.context = context;
	}
	@Given("Once user enter the homepage click the support menu.")
	public void once_user_enter_the_homepage_click_the_support_menu() {
	     dashboard = new DashboardModule(context);
	     dashboard.clickSupport();
	}
	@Given("Once user enter the admin page click addSupport button.")
	public void once_user_enter_the_admin_page_click_add_support_button() {
	     page = new BranchPage(context);
	     page.clickAddBranch();
	}
	@When("Enter the  all credials in support.")
	public void enter_the_all_credials_in_support() throws Exception {
	    support = new SupportFields(context);
	    support.enterEmail("abc@gmail.com");
	    support.enterPOC("gds");
	    support.enterMobileNO("721325465");
	    support.clickGeneral();
	    support.lowPriority();
	    support.enterSubject("bhnk");
	    support.enterDes("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	    support.uploadDOC();
	    submit = new BranchFields(context);
	    submit.clickSubmit();
	    Thread.sleep(2000);
	}
	@Then("Check the data has been present or not in support page.")
	public void check_the_data_has_been_present_or_not_in_support_page() {
		 List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-3-undefined']/div"));
		    for(int i = 0; i<ele.size();i++) {
	    		String text = ele.get(i).getText();
	    		if(text.equals("bhnk")) {
	    			System.out.println("It Matches");
	    		}
	    		else {
	    			System.out.println("This is not matches");
	    			}
	    	}
	}
	
	@When("Click the submit button in support page.")
	public void click_the_submit_button_in_support_page() {
		submit = new BranchFields(context);
	    submit.clickSubmit();
	}
	@Then("Check how it behave in support page.")
	public void check_how_it_behave_in_support_page() {
		 String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/support%20list/add%20support";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	@When("Click the submit and add button in support page.")
	public void click_the_submit_and_add_button_in_support_page() {
		submit = new BranchFields(context);
	    submit.clickSubmitAndAdd();
	}
	@Then("Check how it behave in support page whether it shows error message or not.")
	public void check_how_it_behave_in_support_page_whether_it_shows_error_message_or_not() {
		WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='please upload the student data']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		String errorMessage = findElement1.getText();
		String errorMessage1 = "Enter the credentials";
		Assert.assertEquals(errorMessage, errorMessage1);
	}
	
	@When("Enter the mandatatory fields only.")
	public void enter_the_mandatatory_fields_only() throws Exception {
		support = new SupportFields(context);
	    support.enterEmail("abc1@gmail.com");
	    support.enterPOC("gds1");
	    support.enterMobileNO("7213254651");
	    support.clickGeneral();
	    support.lowPriority();
	    support.uploadDOC();
	    submit = new BranchFields(context);
	    submit.clickSubmit();
	}
	@Then("Check how its behave in support page.")
	public void check_how_its_behave_in_support_page() throws Exception {
	   throw new Exception("Error message didn't throw in support page");
	}
	@When("Enter the credentials and try to upload more mb data.")
	public void enter_the_credentials_and_try_to_upload_more_mb_data() throws Exception {
		support = new SupportFields(context);
	    support.enterEmail("abc2@gmail.com");
	    support.enterPOC("gds2");
	    support.enterMobileNO("721325465");
	    support.clickGeneral();
	    support.lowPriority();
	    support.enterSubject("bhnk2");
	    support.enterDes("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
	    support.uploadVideos();
	    submit = new BranchFields(context);
	    submit.clickSubmit();
	    Thread.sleep(2000);
	}
	@Then("Check whether the videos has been upload oe not.")
	public void check_whether_the_videos_has_been_upload_oe_not() throws Exception {
	    throw new Exception("Set limit video mb");
	}
	@Given("Search some word like {string} in support.")
	public void search_some_word_like_in_support(String string) {
		BranchPage page = new BranchPage(context);
		page.enterSearch(string);
	}
	@When("Check All words contains V char in support.")
	public void check_all_words_contains_v_char_in_support() throws Exception {
	    throw new Exception("Searcch Box didn't Work");
	}
	
}
