package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Modules.AcademicPage;
import Modules.BranchPage;
import Modules.DashboardModule;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class SectionModule {
	public DashboardModule dashboard;
	public  BranchPage branch;
	public AcademicPage acaPage;

	DriverSet context;
	public SectionModule(DriverSet context) {
		this.context = context;
	}
	
	@Given("Once user enter the homepage click the Section menu.")
	public void once_user_enter_the_homepage_click_the_section_menu() {
	    dashboard = new DashboardModule(context);
	    dashboard.clickSection();
	}
	
	@Given("User click the addSrction icon.")
	public void user_click_the_add_srction_icon() {
	    branch = new BranchPage(context);
	    branch.clickAddBranch();
	}
	@When("Without enter any data in section page.")
	public void without_enter_any_data_in_section_page() {
	   
	}
	@Then("Check how it behaves in section menu.")
	public void check_how_it_behaves_in_section_menu() {
		String currentUrl = context.driver.getCurrentUrl();
		   
		   String actualUrl = "https://college.abhisvr360.in.net/homepage/section/add%20section";
		   
		   Assert.assertEquals(currentUrl, actualUrl);
	}
	
	@When("Enter the valid crendials like {string},{string}")
	public void enter_the_valid_crendials_like(String string, String string2) throws InterruptedException {
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[1]/div/div")).click();
	    WebElement ele = context.driver.findElement(By.xpath("//li[@data-value='Dummy Course']"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[2]/div/div")).click();
	    WebElement ele1 = context.driver.findElement(By.xpath("//li[@data-value='2024-03-2028-03']"));
	    context.driver.executeScript("arguments[0].click()", ele1);
        context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[2]/div/div")).click();
	    WebElement ele2 = context.driver.findElement(By.xpath("//li[@data-value='semester 5']"));
	    context.driver.executeScript("arguments[0].click()", ele2);
	    context.driver.findElement(By.xpath("//input[@name='sectionName']")).sendKeys(string);
	    context.driver.findElement(By.xpath("//input[@name='sectionId']")).sendKeys(string2);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[4]/div/div")).click();
	    WebElement ele3 = context.driver.findElement(By.xpath("//li[@data-value='Faculty 277']"));
	    context.driver.executeScript("arguments[0].click()", ele3);

	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[2]/div/div/div/div")).click();
	    context.driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
	    Thread.sleep(2000);
	}
	@Then("Check the data present in section menu or not.")
	public void check_the_data_present_in_section_menu_or_not() {
		String cha = "Dummy Class";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals(cha)) {
    			System.out.println("WorkingFine");
    		}
	}
	    
}
	@When("Enter the valid crendials like {string},{string} and dont select one mandatory fields.")
	 public void enter_the_valid_crendials_like_and_dont_select_one_mandatory_fields(String string, String string2) throws InterruptedException {
		context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[1]/div/div")).click();
	    WebElement ele = context.driver.findElement(By.xpath("//li[@data-value='Dummy Course']"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[2]/div/div")).click();
	    WebElement ele1 = context.driver.findElement(By.xpath("//li[@data-value='2024-03-2028-03']"));
	    context.driver.executeScript("arguments[0].click()", ele1);
        
	    context.driver.findElement(By.xpath("//input[@name='sectionName']")).sendKeys(string);
	    context.driver.findElement(By.xpath("//input[@name='sectionId']")).sendKeys(string2);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[4]/div/div")).click();
	    WebElement ele3 = context.driver.findElement(By.xpath("//li[@data-value='Faculty 277']"));
	    context.driver.executeScript("arguments[0].click()", ele3);

	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[2]/div/div/div/div")).click();
	    context.driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
	    Thread.sleep(2000);
	    }
	
	// Section ID is already exist
	
	@Then("Error Message showing or not in section menu.")
	public void error_message_showing_or_not_in_section_menu() {
		 WebElement findElement1 = context.driver.findElement(By.xpath("//div[text()='Section ID is already exist']"));
			
			WebDriverWait wait = new WebDriverWait(context.driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(findElement1));
			String errorMessage = findElement1.getText();
			String errorMessage1 = "Section ID is already exist";
			Assert.assertEquals(errorMessage, errorMessage1);
	}
	
	@When("Clear the ID data in section menu.")
	public void clear_the_id_data_in_section_menu() {
		 //context.driver.findElement(By.xpath("//input[@name='courseId']")).clear();
		 context.driver.findElement(By.xpath("//input[@name='sectionId']")).clear();
		 context.driver.findElement(By.xpath("//input[@name='mentorFacultyId']")).clear();

	}
	@Then("Check it allow or not in section menu.")
	public void check_it_allow_or_not_in_section_menu() throws Exception {
		throw new Exception("User can able to clear ID data in Section");
	}
	
	@When("Enter the  crendials like {string},{string}")
	public void enter_the_crendials_like(String string, String string2) throws InterruptedException {
		context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[1]/div/div")).click();
	    WebElement ele = context.driver.findElement(By.xpath("//li[@data-value='Dummy Course']"));
	    context.driver.executeScript("arguments[0].click()", ele);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[2]/div/div")).click();
	    WebElement ele1 = context.driver.findElement(By.xpath("//li[@data-value='2024-03-2028-03']"));
	    context.driver.executeScript("arguments[0].click()", ele1);
        context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[2]/div/div")).click();
	    WebElement ele2 = context.driver.findElement(By.xpath("//li[@data-value='semester 5']"));
	    context.driver.executeScript("arguments[0].click()", ele2);
	    context.driver.findElement(By.xpath("//input[@name='sectionName']")).sendKeys(string);
	    context.driver.findElement(By.xpath("//input[@name='sectionId']")).sendKeys(string2);
	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[4]/div/div")).click();
	    WebElement ele3 = context.driver.findElement(By.xpath("//li[@data-value='Faculty 277']"));
	    context.driver.executeScript("arguments[0].click()", ele3);

	    context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[2]/div/div/div/div")).click();
	    context.driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    context.driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
	    Thread.sleep(2000);
	}
	@Then("Check the if the data is present throw bugs.")
	public void check_the_if_the_data_is_present_throw_bugs() throws Exception {
		String cha = "-20";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-5-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals(cha)) {
    			throw new Exception("Negative Values allow in section ID fields");
    		}
	}
	}
	
	@Given("User search the some word in search box like {string} in section menu.")
	public void user_search_the_some_word_in_search_box_like_in_section_menu(String string) {
		acaPage = new AcademicPage(context);
	     acaPage.enterSearch(string);
	}
	@Then("Grab all the text and check all the word this char is present or not in section menu.")
	public void grab_all_the_text_and_check_all_the_word_this_char_is_present_or_not_in_section_menu() {
		String cha = "a";
		List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
    	for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.contains(cha)) {
    			System.out.println("It Contains A word");
    		}
    		else {
    			// throw new Exception("Not Matching");
    			System.out.println("Not Matching");

    		}
    	}
	}
	@Given("User search irrelevant word like {string} in section mmenu.")
	public void user_search_irrelevant_word_like_in_section_mmenu(String string) {
		acaPage = new AcademicPage(context);
	     acaPage.enterSearch(string);
	}
	@Then("Error Text is showing or not in section.")
	public void error_text_is_showing_or_not_in_section() throws Exception {
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
	@Given("User click the edit icon in Section page.")
	public void user_click_the_edit_icon_in_section_page() {
	    context.driver.findElement(By.xpath("//div[@id='row-1']//a//*[name()='svg']//*[name()='path' and contains(@d,'M402.6 83.')]")).click();
	}
	@When("Check all values showing or not in section.")
	public void check_all_values_showing_or_not_in_section() {
	   System.out.println("All values showing");
	}
	
	@When("Edit some values in section fields.")
	public void edit_some_values_in_section_fields() {
	    context.driver.findElement(By.xpath("//input[@name='sectionName']")).sendKeys("10");
	    context.driver.findElement(By.xpath("//button[text()='Update']")).click();

	}
	@Then("Check edited data showing or not in section menu.")
	public void check_edited_data_showing_or_not_in_section_menu() {
		String cha = "Dummy Class10";
	    List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
	    for(int i = 0; i<ele.size();i++) {
    		String text = ele.get(i).getText();
    		if(text.equals(cha)) {
    			System.out.println("WorkingFine");
    		}
	}
	}
	 @Given("User click the delete icon in section")
	    public void user_click_the_delete_icon_in_section() {
	        context.driver.findElement(By.xpath("//div[@id='row-1']//div[@class='flex flex-row items-center gap-4']//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]")).click();
	    }
	    @When("User click yes option in section")
	    public void user_click_yes_option_in_section() {
	 	   context.driver.findElement(By.xpath("//button[@class='ant-btn css-dkbvqv ant-btn-default ant-btn-dangerous']")).click();

	    }
	    @Then("Check deleted data is showing or not in section menu.")
	    public void check_deleted_data_is_showing_or_not_in_section_menu() throws Exception {
	    	String cha = "Dummy Class10";
			List<WebElement> ele = context.driver.findElements(By.xpath("//div[@id='cell-4-undefined']/div"));
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

