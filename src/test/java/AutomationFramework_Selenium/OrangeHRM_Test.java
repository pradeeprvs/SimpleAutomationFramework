package AutomationFramework_Selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrangeHRM_Test extends BaseClass{

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
}
