package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class CourseFields {
	
	DriverSet context;
	public CourseFields(DriverSet context) {
		this.context = context;
	}
	
	By courseName = By.xpath("//input[@name='courseName']");
	By courseID = By.xpath("//input[@name='courseId']");
	By courseDuration = By.xpath("//input[@name='courseDuration']");
	By courseCode = By.xpath("//input[@name='courseCode']");
	By courseKeyword =  By.xpath("//input[@id='course-keywords']");
	By courseDes = By.xpath("//textarea[@name='courseDescription']");
	
	public void enterCourseName(String name) {
		context.driver.findElement(courseName).sendKeys(name);
	}
	public void enterCourseID(String name) {
		context.driver.findElement(courseID).sendKeys(name);
	}
	public void enterCourseDur(String name) {
		context.driver.findElement(courseDuration).sendKeys(name);
	}
	public void enterCourseCode(String name) {
		context.driver.findElement(courseCode).sendKeys(name);
	}
	public void enterCourseKey(String name) {
		context.driver.findElement(courseKeyword).sendKeys(name);
	}
	public void enterCourseDes(String name) {
		context.driver.findElement(courseDes).sendKeys(name);
	}

}
