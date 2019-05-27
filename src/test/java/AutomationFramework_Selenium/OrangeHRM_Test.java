package AutomationFramework_Selenium;

import java.io.IOException;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrangeHRM_Test extends BaseClass{

//	@BeforeMethod
//	public void invoke_WebDriver() throws IOException {
//		driver=initialise_WebDriver();
//	}
//	
//	@BeforeTest
//	public void CreateReport() throws UnknownHostException {
//		createReport();
//	}

	@Test
	public void openURL() {
		test= extent.createTest("Open URL Test");
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

//	@Test
//	public void loginTest() {
//		test= extent.createTest("Login Test");
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		//login
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
//	}
//	
//	@Test
//	public void verifyLogo() {
//		test= extent.createTest("Verify Logo Test");
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		Assert.assertTrue(driver.findElement(By.xpath(".//div[@id='divLogo']/img")).isDisplayed());
//	}
//	
//	@Test
//	public void createNodeTest(  ) {
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		test = extent.createTest("OrangeHRMcreateNodeTest");
//		test.createNode("Login with Valid input");
//		Assert.assertTrue(true);
//
//		test.createNode("Login with In-valid input");
//		Assert.assertTrue(true);
//	}

	
//	@AfterTest
//	public void endReports() {
//		endReport();
//	}
//
//	@AfterMethod
//	public void tearDown_TestObjects(ITestResult result) throws IOException {
//		tearDown(result);
//	}
}
