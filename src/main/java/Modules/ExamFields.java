package Modules;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import webdriver.DriverSet;

public class ExamFields {
	
	DriverSet context;
	public ExamFields(DriverSet context) {
		this.context = context;
	}
	
	public void clickCourse() {
		context.driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[1]/div/div")).click();
		context.driver.findElement(By.xpath("//li[@data-value='Dummy Course']")).click();
	}
	public void acaYear() {
		context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[2]/div/div")).click();
		context.driver.findElement(By.xpath("//li[@data-value='2024-03-2028-03']")).click();
	}
	
	public void semester() {
		context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[2]/div/div")).click();
		context.driver.findElement(By.xpath("//li[@data-value='semester 2']")).click();
	}
	
	public void secName() {
		context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[3]/div/div")).click();
		context.driver.findElement(By.xpath("//li[@data-value='EEE Class 1']")).click();
	}
	
	public void subName() {
		context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[4]/div/div")).click();
		context.driver.findElement(By.xpath("//li[text()='Dummy Subject']")).click();
	}
	
	public void assignFac() {
		context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/form/div/div[1]/div[1]/div[6]/div/div")).click();
		context.driver.findElement(By.xpath("//li[@data-value='Faculty 10']")).click();
	}
	
	public void enterExamName(String name) {
		context.driver.findElement(By.xpath("//input[@name='examName']")).sendKeys(name);
	}
	public void enterExamID(String name) {
		context.driver.findElement(By.xpath("//input[@name='examId']")).sendKeys(name);
	}
	public void enterTotalMark(String name) {
		context.driver.findElement(By.xpath("//input[@name='totalMarks']")).sendKeys(name);
	}
	public void enterPassMark(String name) {
		context.driver.findElement(By.xpath("//input[@name='passMarks']")).sendKeys(name);
	}
	
	public void clickExamLink(String name) {
		context.driver.findElement(By.xpath("(//input[@name='createExamOption'])[2]")).click();
		context.driver.findElement(By.xpath("//input[@name='examLink']")).sendKeys(name);
	}
	
	public void clickFile() throws Exception {
		context.driver.findElement(By.xpath("(//input[@name='createExamOption'])[3]")).click();
		context.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[2]/div/form/div/div[2]/label")).click();
		Thread.sleep(3000);
		String file1 = "C:\\Users\\dinesh\\Downloads\\profileimage.jpeg";
		StringSelection selection1 = new StringSelection(file1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void clickCreateExam() {
		context.driver.findElement(By.xpath("(//input[@name='createExamOption'])[1]")).click();
	}
	
	public void clickCreate() {
		context.driver.findElement(By.xpath("//button[text()='Create']")).click();
	}
}
