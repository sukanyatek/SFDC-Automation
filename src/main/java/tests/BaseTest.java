package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class has the common methods called from various test classes.
 */
public class BaseTest {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static WebDriver driver;
	static Logger logger = LogManager.getLogger();
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<ExtentTest>();
	
	public static void setDriver(String browserName) {
		WebDriver driver = BaseTest.configureBrowserType(browserName);
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	public static ExtentTest getTest() {
		return threadLocalTest.get();
	}
	
	@AfterMethod
	public static void removeDriver() {
		BaseTest.getDriver().close();
		threadLocalDriver.remove();
		threadLocalTest.remove();
	}
	
	
	
	@BeforeSuite
	public void configuration() {
		extent = new ExtentReports();
		logger.info("BaseTest:Report Configuration started.");
		ExtentSparkReporter report = new ExtentSparkReporter(FileConstants.REPORTS_FOLDER_FILEPATH);
		extent.attachReporter(report);
		logger.info("BaseTest:configuration(): Report Configuration completed.");
	}
	
	@AfterSuite
	public void completion() {
		extent.flush();
		logger.info("BaseTest:completion(): After Suite completed.");
	}
	
	/**This method configures and returns browser object
	 * @param browserName eg: chrome, safari etc
	 * @return Webdriver object
	 */
	public static WebDriver configureBrowserType(String browserName) {
		
		String browser = browserName.toLowerCase();
		
		WebDriver driver;
		
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			logger.info("BaseTest:configureBrowserType:Chrome browser is configured");
			break;
		case "safari":
			driver = new SafariDriver();
			logger.info("BaseTest:configureBrowserType:Safari browser is configured");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			logger.info("BaseTest:configureBrowserType:Firefox browser is configured");
			break;
		case "edge":
			driver = new EdgeDriver();
			logger.info("BaseTest:configureBrowserType:Chrome browser is configured");
		default:
			driver = null;
			logger.error("BaseTest:configureBrowserType:Invalid browser");
			break;	
		}
		return driver;
	}
}
