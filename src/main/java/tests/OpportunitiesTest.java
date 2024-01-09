package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import constants.WaitConstants;
import listeners.SFDCListeners;
import pages.LoginPage;
import pages.OpportunitiesPage;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class OpportunitiesTest extends BaseTest {
	@BeforeMethod
	public void preCondition() throws IOException {
		
		System.out.println("Before Method");
		//driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		BaseTest.setDriver(FileUtils.getLoginTestData("browsertype"));
		//LoginPage lp = new LoginPage(driver);
		//driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		//lp.loginToApp(driver);
		
	}
	
	
	//@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	
	@Test(enabled = true)
	public void opportunitiesDropdown_TC15() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = BaseTest.getTest();
		test.info("TC15");
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		test.info("TC15:loaded home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		test.info("TC15:loaded opp home page");
		Assert.assertTrue(op.verifyOppDropdown());
		test.info("TC15");
		
	}
	
	@Test(enabled = true, groups = "smoke")
	public void createNewOpportunity_TC16() throws IOException{		
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = BaseTest.getTest();
		test.info("TC16");
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page.");
		test.info("TC16:loaded home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page.");
		test.info("TC16:loaded opp home page");
		op.createNew(driver, FileUtils.getOpportunitiesTestData("opportunities.new"));
		op.createNewOpp();
		test.info("TC16:created new opp");
		Assert.assertTrue(op.verifyNewOpp(),"Failed to verify new opportunity.");
		test.info("TC16");
	}
	
	@Test(enabled = true, groups = "smoke")
	public void opportunitiesPipelineReport_TC17() throws IOException{		
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = BaseTest.getTest();
		test.info("TC17");
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);		
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		test.info("TC17:loaded home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		test.info("TC17:loaded opp home page");
		Assert.assertTrue(op.selectOppPipeline());
		test.info("TC17");
	}
	
	@Test(enabled = true)
	public void stuckOpportunitiesReport_TC18() throws IOException{		
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = BaseTest.getTest();
		test.info("TC18");
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);		
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		test.info("TC18:loaded home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		test.info("TC18:loaded opp home page");
		Assert.assertTrue(op.selectStuckOpp());
		test.info("TC18");
	}
	
	@Test(enabled = true)
	public void quarterlySummaryReport_TC19() throws IOException{		
		WebDriver driver = BaseTest.getDriver();
		ExtentTest test = BaseTest.getTest();
		test.info("TC19");
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);		
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		test.info("TC19:loaded home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		test.info("TC19:loaded opp home page");
		Assert.assertTrue(op.selectQuarterlySummary());
		test.info("TC19");
	}
}
