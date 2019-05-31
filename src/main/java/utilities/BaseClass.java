package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

	protected WebDriver driver;
	Properties prop =new Properties();
	public ExtentHtmlReporter htmlReporter; //responsible for the configuration of look and feel of the extent reports
	public ExtentReports extent; //Responsible for adding System related information
	public ExtentTest test; //Responsible for logging and adding screenshots to the reports
	String dateName = new SimpleDateFormat(" yyyy_MM_dd_hh_mm_ss").format(new Date());//Just to add time to the filenames to make them dynamic

	@BeforeTest()
	public void createReport() throws UnknownHostException {
		//htmlReporter =new ExtentHtmlReporter("test-output/extentReports/my-report "+ dateName +".html");//use this when you want save your reports for the tracking purposes
		htmlReporter =new ExtentHtmlReporter("test-output/extentReports/my-report.html"); //you need to specify the path where you wanted to store your reports, whenever you the new report coming will override this report
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("My Extent Reports");
		htmlReporter.config().setReportName("Functional Testing Reports");

		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);

		//Passing General/System related information
		InetAddress addr = InetAddress.getLocalHost();//this is to get the system related information using java methods
		extent.setSystemInfo("HostName", addr.getHostName());
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("IP", addr.getHostAddress());
		System.out.println("I am from Create Report");
	}
	
	@BeforeMethod
	public WebDriver initialise_WebDriver() throws IOException {
		FileInputStream fis= new FileInputStream("src\\main\\java\\resources\\config.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");//This is needed to run headless browser tests
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			this.driver=new ChromeDriver(options);
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			//firefox implementation code must be here
		}
		return driver;
	}
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		System.out.println("I am from TearDown");
		if(result.getStatus()==ITestResult.SUCCESS) { //when test case got passed, we are logging this into report
						String screenshotPath = getScreenshot(driver, result.getName());
						   test.addScreenCaptureFromPath(screenshotPath); //adding screenshot
			test.log(Status.PASS,result.getName() + " test case is passed");
		}

		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			String screenshotPath = getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		driver.quit();
	}

	public String getScreenshot(WebDriver driver, String Screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir")+"\\eclipse-workspace\\jenkins\\workspace\\SimpleFramework\\Screenshots" + Screenshotname + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Copied at : "+destination);
			e.printStackTrace();
		}
		return destination;

	}
}
