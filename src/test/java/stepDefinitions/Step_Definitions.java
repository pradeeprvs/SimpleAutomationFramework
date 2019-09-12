package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.BaseClass;

public class Step_Definitions extends BaseClass {

	@Given("browser opened with open URL")
	public void browser_opened_with_open_URL() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   driver=initialise_WebDriver();
	   driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("user sees login page enter {string} and {string}")
	public void user_sees_login_page_enter_and(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		highLightElement(driver,driver.findElement(By.id("txtUsername")));
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		highLightElement(driver,driver.findElement(By.id("txtPassword")));
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		highLightElement(driver,driver.findElement(By.id("btnLogin")));
		driver.findElement(By.id("btnLogin")).click();
		getScreenshot(driver, "loginTest");
	}

	@Then("redirect to homepage and")
	public void redirect_to_homepage_and() {
	    // Write code here that turns the phrase above into concrete actions
//		Assert.assertTrue(driver.findElement(By.xpath(".//div[@id='divLogo']/img")).isDisplayed());
		getScreenshot(driver, "verifyLogo");  
	}
	
	@Then("close browser")
	public void close_browser(){
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}
}
