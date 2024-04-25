package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Modules.HomePage;
import Modules.ProfileEdit;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class HomePageDefinitions {
	public String formattedText;
	public String text;
	public HomePage homePage;
	public ProfileEdit profile;
	public String text1;
	public String text3;
	
	
	String text2 = "Profile updated successfully";
	
	DriverSet context;
	public HomePageDefinitions(DriverSet context) {
		this.context = context;
	}
	
	
	@Given("Once user enter the homepage.")
	public void once_user_enter_the_homepage() {
		LocalDate date = LocalDate.now();
		Month month = date.getMonth();
		System.out.println(month);
		int year = date.getYear();
		System.out.println(year);
		
		String dsf = month + "," + " " + year;
		System.out.println(dsf);
		
		String te = dsf;
	    formattedText = te.substring(0, 1).toUpperCase() + te.substring(1).toLowerCase();
		System.out.println(formattedText);
	}

	@When("Check the year,date,month shows correcly or not.")
	public void check_the_year_date_month_shows_correcly_or_not() {
	    text = context.driver.findElement(By.xpath("//h1[normalize-space()='April, 2024']")).getText();
		System.out.println(text);
	}

	@Then("Verify it shows correct month and year by using our local month and year.")
	public void verify_it_shows_correct_month_and_year_by_using_our_local_month_and_year() {
		if(text.equals(formattedText)) {
			System.out.println("Month and Year shows correct");
		}
		else {
			System.out.println("Month and Year shows wrong");

		}
	}

	@Given("Once user enter the homepage and click the edit icon.")
	public void once_user_enter_the_homepage_and_click_the_edit_icon() {
	    homePage = new HomePage(context);
	    homePage.clickProfileEdit();
	}

	@When("Firstly clear the existing data and add new value.")
	public void firstly_clear_the_existing_data_and_add_new_value() throws InterruptedException {
	   profile = new ProfileEdit(context);
	   Thread.sleep(2000);
	   context.driver.findElement(By.xpath("//input[@name='first_name']")).clear();
	   profile.enterName("VEC - 1");
	   
	}

	@Then("Click Submit icon first then click Close icon.")
	public void click_submit_icon_first_then_click_close_icon() {
	    profile.clickUpdate();
	    WebElement findElement = context.driver.findElement(By.xpath("//div[text()='Profile updated successfully']"));
		
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(findElement));
		text1 = findElement.getText();
		System.out.println(text1);
		
		Assert.assertEquals(text1, text2);
		profile.clickClose();
	}

	@And("Check the values has been changed in homepage.")
	public void check_the_values_has_been_changed_in_homepage() throws InterruptedException {
	   context.driver.navigate().refresh();
	   Thread.sleep(2000);
	   String helloText = context.driver.findElement(By.xpath("(//h1[normalize-space()='Hello VEC - 1'])[1]")).getText();
	   String textShows = "Hello VEC - 1";
	   assertEquals(helloText, textShows);
	}

	@When("User can able to edit the  password and email fields")
	public void user_can_able_to_edit_the_password_and_email_fields() {
	    boolean enabled = context.driver.findElement(By.xpath("//input[@name='password']")).isEnabled();
	    boolean enabled2 = context.driver.findElement(By.xpath("//input[@name='emailId']")).isEnabled();
	    Assert.assertEquals(enabled, false);
	    Assert.assertEquals(enabled2, false);
	    
	}

	@Then("Click Submit icon  then click Close icon.")
	public void click_submit_icon_then_click_close_icon() {
	    profile.clickUpdate();
	    profile.clickClose();
	}

	@When("User enter the negative value in mobile number field like {string}")
	public void user_enter_the_negative_value_in_mobile_number_field_like(String mobile) throws InterruptedException {
		ProfileEdit edit1 = new ProfileEdit(context);
		Thread.sleep(2000);
		context.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div/form/div[2]/div[3]/div[2]/div[2]/input")).clear();
		edit1.enterMobile("-54657");
		
	}

	@Then("Click Submit icon  if its allow there is a bug.")
	public void click_submit_icon_if_its_allow_there_is_a_bug() {
		ProfileEdit edit1 = new ProfileEdit(context);
		edit1.clickUpdate();
	    WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Profile updated successfully']"));
		// //div[text()='please upload your Branch logo']
		WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(findElement1));
		text = findElement1.getText();
		System.out.println(text);
		String text4 = "Invalid Mobile Number";
		Assert.assertEquals(text, text4);
		edit1.clickClose();
	}

	@When("User clear the editable data")
	public void user_clear_the_editable_data() {
	   context.driver.findElement(By.xpath("//input[@name='first_name']")).clear();
	   context.driver.findElement(By.xpath("//input[@name='mobileNumber']")).clear();
	   context.driver.findElement(By.xpath("//input[@name='addressLine']")).clear();
	}

	@Then("Click the submit icon and check check how it behave")
	public void click_the_submit_icon_and_check_check_how_it_behave() {
		
		ProfileEdit edit2 = new ProfileEdit(context);
		edit2.clickUpdate();
	 
	   
	}
	
	@Given("Click the profile icon.")
	public void click_the_profile_icon() {
	   context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/img")).click();
	   
	}
	@Then("Check all values showing or not in profile view.")
	public void check_all_values_showing_or_not_in_profile_view() throws Exception {
	    throw new Exception("All VAlues didn't shows");
	}

}
