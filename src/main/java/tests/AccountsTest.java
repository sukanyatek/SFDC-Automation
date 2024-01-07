package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.classfile.Method;

import constants.WaitConstants;
import listeners.SFDCListeners;
import pages.AccountsPage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;

@Listeners(SFDCListeners.class)
public class AccountsTest extends BaseTest {
	
	private WebDriver driver; 
	@BeforeMethod
	public void preCondition() throws IOException {
		logger.info("AccountsTest:preCondition():Beginning");
		//driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		BaseTest.setDriver(FileUtils.getLoginTestData("browsertype"));
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		logger.info("AccountsTest:preCondition():Ending");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test(enabled = false)
	public void createNewAccount_TC10() throws IOException{
		LoginPage lp = new LoginPage(driver);
		AccountsPage ap = new AccountsPage(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		Assert.assertTrue(ap.verifyAccountsPage(driver, FileUtils.getAccountsTestData("accounts.page.title")),"Failed to load accounts page");
		ap.createNew(driver,FileUtils.getAccountsTestData("accounts.new"));
		ap.createNewAccount(driver, FileUtils.getAccountsTestData("account.name"),
				FileUtils.getAccountsTestData("account.type"), FileUtils.getAccountsTestData("customer.priority"));
		Assert.assertTrue(ap.verifyNewAccount(FileUtils.getAccountsTestData("account.name"),
				FileUtils.getAccountsTestData("account.type"), FileUtils.getAccountsTestData("customer.priority")),"Failed to verify new account details");
		
	}

	@Test(enabled = false)
	public void createNewView_TC11() throws IOException{
		LoginPage lp = new LoginPage(driver);
		AccountsPage ap = new AccountsPage(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		Assert.assertTrue(ap.verifyAccountsPage(driver, FileUtils.getAccountsTestData("accounts.page.title")),"Failed to load accounts page.");
		Assert.assertTrue(ap.createNewViewAndVerify(driver, FileUtils.getAccountsTestData("view.name"),
				FileUtils.getAccountsTestData("view.uniquename")),"Failed to verify new view.");
	}
	
	@Test(enabled = false)
	public void editView_TC12() throws IOException{
		LoginPage lp = new LoginPage(driver);
		AccountsPage ap = new AccountsPage(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		//test.info("Home page loaded");
		Assert.assertTrue(ap.verifyAccountsPage(driver, FileUtils.getAccountsTestData("accounts.page.title")),"Failed to load accounts page.");
		//test.info("Accounts page loaded");
		Assert.assertTrue(ap.selectEditViewAndVerify(driver, FileUtils.getAccountsTestData("view.name"),
				FileUtils.getAccountsTestData("accounts.editview.page.title")));
		//test.info("Edit View Page");
		Assert.assertTrue(ap.editViewAndVerify(FileUtils.getAccountsTestData("view.name"), 
											   FileUtils.getAccountsTestData("view.newname"), 
											   FileUtils.getAccountsTestData("view.filter1.field"), 
											   FileUtils.getAccountsTestData("view.filter1.operator"), 
											   FileUtils.getAccountsTestData("view.filter1.value"), 
											   FileUtils.getAccountsTestData("view.display.field")));
	}
	
	@Test(enabled = false)
	//public void mergeAccounts_TC13(Method name) throws IOException{ //-->Method name not working
	public void mergeAccounts_TC13() throws IOException{
		logger.info("AccountsTest:mergeAccounts_TC13:");
		//test = extent.createTest("mergeAccounts_TC13"); -->this is moved to SFDC Listeners
		//test = extent.createTest(name.getName()); -->getname not working
		LoginPage lp = new LoginPage(driver);
		AccountsPage ap = new AccountsPage(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		test.info("Home page loaded");
		Assert.assertTrue(ap.verifyAccountsPage(driver, FileUtils.getAccountsTestData("accounts.page.title")),"Failed to load accounts page.");
		test.info("Accounts page loaded");
		Assert.assertTrue(ap.verifyAccountsSelectedToMerge(driver,
				FileUtils.getAccountsTestData("merge.accounts.page.title"),
				FileUtils.getAccountsTestData("merge.accounts.searchkey")));
		Assert.assertTrue(ap.verifyMergeAccounts(driver));
		//test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));-->this is moved to SFDC Listeners
		//test.pass("PASSED:mergeAccounts_TC13");-->this is moved to SFDC Listeners
	}
	
	@Test(enabled = true)
	public void createAccountReport_TC14() throws IOException, InterruptedException{
		logger.info("AccountsTest:createAccountReport_TC14:");
		LoginPage lp = new LoginPage(driver);
		AccountsPage ap = new AccountsPage(driver);
		Assert.assertTrue(lp.verifyHomePage(),"Failed to load home page");
		test.info("Home page loaded");
		Assert.assertTrue(ap.verifyAccountsPage(driver, FileUtils.getAccountsTestData("accounts.page.title")),"Failed to load accounts page.");
		test.info("Accounts page loaded");
		Assert.assertTrue(ap.createAccountReport(driver, FileUtils.getAccountsTestData("unsaved.report.page.title")));
		test.info("Accounts report page loaded");
		ap.selectReportOptions(driver);
		Assert.assertTrue(ap.saveReport(driver, FileUtils.getAccountsTestData("report.name"), FileUtils.getAccountsTestData("report.unique.name")));
	}
}
	
