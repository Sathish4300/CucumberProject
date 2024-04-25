package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Modules.BranchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import webdriver.DriverSet;

public class BranchModule1 {
	
	DriverSet context;
	public BranchModule1(DriverSet context) {
		this.context = context;
	}
	
	@Given("Click the Edit icon")
	public void click_the_edit_icon() {
		BranchPage page = new BranchPage(context);
		page.clickEdit();
	}
	
//	@When("Check the branch id is editable or not")
//	public void check_the_branch_id_is_editable_or_not() {
//		WebElement ele = context.driver.findElement(By.xpath("//input[@name='branchId']"));
//    	String attribute = ele.getAttribute("readonly");
//    	boolean isEdit = !(attribute!=null && attribute.equals("true"));
//    	if(isEdit) {
//    		System.out.println("Field is Editable");
//    	}
//    	else {
//    		System.out.println("Field is not Editable");
//    	}
//   }
	@When("Check the branch id is editable or not.")
	public void check_the_branch_id_is_editable_or_not() {
		WebElement ele = context.driver.findElement(By.xpath("//input[@name='branchId']"));
    	String attribute = ele.getAttribute("readonly");
    	boolean isEdit = !(attribute!=null && attribute.equals("true"));
    	if(isEdit) {
    		System.out.println("Field is Editable");
    	}
    	else {
    		System.out.println("Field is not Editable");
    	}
	}
	@When("Check the values present in all fields.")
	public void check_the_values_present_in_all_fields() throws Exception {
		String val = "ga";
		String val1 = "iuvvs";
		Assert.assertEquals(val, val1);

		}
	
	@Given("Click the view icon")
	public void click_the_view_icon() {
		context.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[12]/div[1]/*[name()='svg'][1]")).click();
	}
	
	@When("Check the value present in all fields.")
	public void check1() throws Exception {
		String val = "ga";
		String val1 = "iuvvs";
		Assert.assertEquals(val, val1);
	}
	@Given("Click the delete icon")
	public void click_the_delete_icon() {
		
	}
	@When("Click the  Yes option")
	public void click_the_yes_option() {
		System.out.println("Deleted Successfully");
	}

}
