package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.WaitConstants;
import pages.LeadsPage;
import pages.LoginPage;
import utils.FileUtils;

public class LeadsTest extends BaseTest {
	private WebDriver driver; 
	
	@BeforeMethod
	public void preCondition() throws IOException {
		
		driver = BaseTest.configureBrowserType(FileUtils.getLoginTestData("browsertype"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(enabled = true)
	public void leadsTab_TC20() throws IOException{
		LeadsPage lp = new LeadsPage(driver);
		Assert.assertTrue(lp.selectLeadsTab(driver),"Failed to load leads home page.");
	}
	
	
	@Test(enabled = true)
	public void leadsSelectView_TC21() throws IOException{
		LeadsPage lp = new LeadsPage(driver);
		Assert.assertTrue(lp.selectLeadsTab(driver),"Failed to load leads home page.");
		Assert.assertTrue(lp.verifyLeadsDropdown(),"Failed to verify leads dropdown.");
	}
}
