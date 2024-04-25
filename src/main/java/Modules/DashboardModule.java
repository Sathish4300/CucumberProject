package Modules;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class DashboardModule {
	
	DriverSet context;
	public DashboardModule(DriverSet context) {
		this.context = context;
	}
	
	By home = By.xpath("//h1[text()='Home']");
	By branch = By.xpath("//h1[text()='Branches']");
	By faculty = By.xpath("//h1[text()='Faculty']");
	By subjects = By.xpath("//h1[text()='Subjects']");
	By academicYear = By.xpath("//h1[text()='Academic Year']");
	By course = By.xpath("//h1[text()='Courses']");
	By section = By.xpath("//h1[text()='Sections']");
	By student = By.xpath("//h1[text()='Students ']");
	By exam = By.xpath("//h1[text()='Exams ']");
	By result = By.xpath("//h1[text()='Results']");
	By chat = By.xpath("//h1[text()='Chat']");
	By meet = By.xpath("//h1[text()='LMS Meet']");
	By attendance = By.xpath("//h1[text()='Attendance']");
	By announcement = By.xpath("//h1[text()='Announcements']");
	By admin = By.xpath("//h1[text()='Admin']");
	By support = By.xpath("//h1[text()='Support']");
	By vr = By.xpath("//h1[text()='Virtual Reality']");
	
	
	public void clickHome() {
		context.driver.findElement(home).click();
	}
	
	public void clickBranch() {
		context.driver.findElement(branch).click();
	}
	
	public void clickFaculty() {
		context.driver.findElement(faculty).click();
	}

	public void clickSubject() {
		context.driver.findElement(subjects).click();
	}
	
	public void clickAcademicYear() {
		context.driver.findElement(academicYear).click();
	}
	
	public void clickCourse() {
		context.driver.findElement(course).click();
	}
	
	public void clickSection() {
		context.driver.findElement(section).click();
	}
	
	public void clickStudent() {
		context.driver.findElement(student).click();
	}
	
	public void clickExam() {
		context.driver.findElement(exam).click();
	}
	
	public void clickResult() {
		context.driver.findElement(result).click();
	}
	
	public void clickChat() {
		context.driver.findElement(chat).click();
	}
	
	public void clickMeet() {
		context.driver.findElement(meet).click();
	}
	
	public void clickAttendance() {
		context.driver.findElement(attendance).click();
	}
	
	public void clickAnnouncement() {
		context.driver.findElement(announcement).click();
	}
	
	public void clickAdmin() {
		context.driver.findElement(admin).click();
	}
	
	public void clickSupport() {
		context.driver.findElement(support).click();
	}
	
	public void clickVR() {
		context.driver.findElement(vr).click();
	}
}
