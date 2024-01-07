package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import constants.WaitConstants;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;

public class LoginTest extends BaseTest {
	
	private WebDriver driver;
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test (enabled = true) 
	public void loginError_TC01() throws IOException{
		
		driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.launchApp(driver);
		Assert.assertEquals(lp.getPageTitle(driver),FileUtils.getLoginTestData("loginpage.title"));
		lp.enterUsername(FileUtils.getLoginTestData("prod.username"));
		Assert.assertEquals(lp.verifyUsername(),FileUtils.getLoginTestData("prod.username")); //***This gettext of username not fetching the username //fail
		lp.clearPassword();
		Assert.assertEquals(lp.verifyPassword(),"");
		lp.clickLogin(driver);
		Assert.assertEquals(lp.verifyErrorMessage(), FileUtils.getLoginTestData("error.message.invalidpassword"));
		
	}
	
	@Test (enabled = true) 
	public void loginToSFDC_TC02() throws IOException {
		driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.launchApp(driver);
		Assert.assertEquals(lp.getPageTitle(driver),FileUtils.getLoginTestData("loginpage.title"));	
		lp.enterUsername(FileUtils.getLoginTestData("prod.username"));
		lp.enterPassword(FileUtils.getLoginTestData("prod.password"));
		lp.clickLogin(driver);
		Assert.assertTrue(lp.verifyHomePage());
	}
	
	@Test (enabled = true) //fail
	//reloading of login page - not waiting even with implicit wait. worked with sleep.
	public void checkRememberMe_TC03() throws IOException, InterruptedException {
		driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		lp.launchApp(driver);
		Assert.assertEquals(lp.getPageTitle(driver),FileUtils.getLoginTestData("loginpage.title"));	
		lp.enterUsername(FileUtils.getLoginTestData("prod.username"));
		lp.enterPassword(FileUtils.getLoginTestData("prod.password"));
		lp.selectRememberMe();
		lp.clickLogin(driver);
		Assert.assertTrue(lp.verifyHomePage());
		ump.selectUserMenu();
		ump.selectUserMenuOption(driver, FileUtils.getUserMenuTestData("usermenu.logout"));
		Thread.sleep(5000);
		Assert.assertEquals(lp.getPageTitle(driver),FileUtils.getLoginTestData("loginpage.title"));	// this worked only after sleep. why wait not working??
		Assert.assertEquals(lp.verifyInputUsername(),FileUtils.getLoginTestData("prod.username")); 
		Assert.assertTrue(lp.checkRememberMe());
	}
	
	
	@Test (enabled = true)  
	public void forgotPassword_TC04A() throws IOException, InterruptedException {
			
		driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.launchApp(driver);
		lp.selectForgotPassword(driver);
		Assert.assertEquals(lp.getPageTitle(driver), FileUtils.getLoginTestData("forgotpassword.title"));
		lp.enterForgotPwdUsername(FileUtils.getLoginTestData("prod.username"));
		lp.selectForgotPwdContinueButton();
		Assert.assertEquals(lp.getPageTitle(driver), FileUtils.getLoginTestData("checkemail.title"));
		Assert.assertTrue(lp.checkEmailMessage());	
	}
		
	
	@Test (enabled = true)
	public void validateLoginErrorMessage_TC04B() throws IOException, InterruptedException {
			
		driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		LoginPage lp = new LoginPage(driver);
		lp.launchApp(driver);
		Assert.assertEquals(lp.getPageTitle(driver),FileUtils.getLoginTestData("loginpage.title"));	
		lp.enterUsername(FileUtils.getLoginTestData("invalid.username"));
		Assert.assertEquals(lp.verifyUsername(), FileUtils.getLoginTestData("invalid.username")); 
		lp.enterPassword(FileUtils.getLoginTestData("invalid.password"));
		Assert.assertNotNull(lp.verifyPassword());
		lp.clickLogin(driver);
		Assert.assertEquals(lp.verifyErrorMessage(),FileUtils.getLoginTestData("error.message.invalid.userpwd")); 
		
	}
		
}
