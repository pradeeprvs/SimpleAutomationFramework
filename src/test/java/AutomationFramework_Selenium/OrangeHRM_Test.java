package AutomationFramework_Selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrangeHRM_Test extends BaseClass{

	@Test
	public void openURL() throws IOException {
		test= extent.createTest("Open URL Test");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		getScreenshot(driver, "openURL");
	}

	@Test
	public void loginTest() throws IOException {
		test= extent.createTest("Login Test");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		getScreenshot(driver, "loginTest");

	}

	@Test
	public void verifyLogo() throws IOException {
		test= extent.createTest("Verify Logo Test");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(driver.findElement(By.xpath(".//div[@id='divLogo']/img")).isDisplayed());
		getScreenshot(driver, "verifyLogo");
	}

	@Test
	public void createNodeTest(  ) throws IOException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		test = extent.createTest("OrangeHRMcreateNodeTest");
		test.createNode("Login with Valid input");
		Assert.assertTrue(true);
		getScreenshot(driver, "createNodeTest1");
		test.createNode("Login with In-valid input");
		getScreenshot(driver, "createNodeTest2");
		Assert.assertTrue(true);
	}
}
