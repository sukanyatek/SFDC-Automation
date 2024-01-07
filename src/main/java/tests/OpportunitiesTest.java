package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		Assert.assertTrue(op.verifyOppDropdown());
		System.out.println("TC15");
		
	}
	
	@Test(enabled = true, groups = "smoke")
	public void createNewOpportunity_TC16() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page.");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page.");
		op.createNew(driver, FileUtils.getOpportunitiesTestData("opportunities.new"));
		op.createNewOpp();
		Assert.assertTrue(op.verifyNewOpp(),"Failed to verify new opportunity.");
		System.out.println("TC16");
	}
	
	@Test(enabled = true, groups = "smoke")
	public void opportunitiesPipelineReport_TC17() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);		
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		Assert.assertTrue(op.selectOppPipeline());
		System.out.println("TC17");
	}
	
	@Test(enabled = true)
	public void stuckOpportunitiesReport_TC18() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);		
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		Assert.assertTrue(op.selectStuckOpp());
		System.out.println("TC18");
	}
	
	@Test(enabled = true)
	public void quarterlySummaryReport_TC19() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		OpportunitiesPage op = new OpportunitiesPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);		
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		Assert.assertTrue(op.selectOpportunitiesTab(driver),"Failed to load opportunites home page");
		Assert.assertTrue(op.selectQuarterlySummary());
		System.out.println("TC19");
	}
}
