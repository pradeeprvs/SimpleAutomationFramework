package AutomationFramework_Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

class OrangeHRM_Test extends BaseClass{
	
	@Test
	public void openRun() throws Exception {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_R);
	}

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
		highLightElement(driver,driver.findElement(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		highLightElement(driver,driver.findElement(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		highLightElement(driver,driver.findElement(By.id("btnLogin")));
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
	public void createNodeTest() throws IOException {
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
