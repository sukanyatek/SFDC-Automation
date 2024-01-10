package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.WaitConstants;
import listeners.SFDCListeners;
import pages.LeadsPage;
import pages.LoginPage;
import utils.FileUtils;

//@Listeners(SFDCListeners.class)
public class LeadsTest extends BaseTest {
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void preCondition(@Optional("chrome") String bname) throws IOException {
		BaseTest.setDriver(bname);
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(enabled = false)
	public void leadsTab_TC20() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load application home page");
		LeadsPage ldp = new LeadsPage(driver);
		Assert.assertTrue(ldp.selectLeadsTab(driver),"Failed to load leads home page.");
	}
	
	
	@Test(enabled = false)
	public void leadsSelectView_TC21() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load application home page");
		LeadsPage ldp = new LeadsPage(driver);
		Assert.assertTrue(ldp.selectLeadsTab(driver),"Failed to load leads home page.");
		Assert.assertTrue(ldp.verifyLeadsDropdown(),"Failed to verify leads dropdown.");
	}
	
	@Test(enabled = true)
	public void leadsDefaultView_TC22() throws IOException{
		WebDriver driver = BaseTest.getDriver();
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load application home page");
		LeadsPage ldp = new LeadsPage(driver);
		Assert.assertTrue(ldp.selectLeadsTab(driver),"Failed to load leads home page.");
		ldp.selectLeadsDropdown(FileUtils.getLeadsTestData("leads.dropdown.todaysleads"));
		lp.logoutOfApp(driver);
		lp.loginToApp(driver);
		Assert.assertTrue(ldp.selectLeadsTab(driver),"Failed to load leads home page.");
		ldp.verifyLeadsDropdownSelected(driver,FileUtils.getLeadsTestData("leads.dropdown.todaysleads"));
	}
	
	
	
}
