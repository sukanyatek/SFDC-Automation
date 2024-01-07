package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.FileConstants;
import constants.WaitConstants;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.FileUtils;

public class UserMenuTest extends BaseTest {
	
	private WebDriver driver;
	@BeforeMethod
	public void preCondition() throws IOException {
		
		driver = BaseTest.configuretBrowserType(FileUtils.getLoginTestData("browsertype"));
		LoginPage lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(WaitConstants.IMPLICIT_WAIT_TIME);
		lp.loginToApp(driver);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (enabled = false)	
	public void selectUserMenu_TC05() throws IOException{
		UserMenuPage ump = new UserMenuPage(driver);
		Assert.assertTrue(ump.verifyHomepageUsername(FileUtils.getUserMenuTestData("user.fullname")));
		ump.selectUserMenu(); 
		Assert.assertTrue(ump.verifyUserMenuOptions(), "Failed to verify Usermenu Options");	
	}
	
	@Test (enabled = false)
	public void selectMyProfile_TC06() throws IOException {
		UserMenuPage ump = new UserMenuPage(driver);
		ump.selectUserMenu(); 
		Assert.assertTrue(ump.verifyUserMenuOptions(), "Failed to verify Usermenu Options");
		ump.selectUserMenuOption(driver, FileUtils.getUserMenuTestData("usermenu.myprofile"));
		Assert.assertTrue(ump.verifyProfilePageDispalyed(), "Failed to load user profile page");
		ump.selectEditContact(driver);
	    Assert.assertTrue(ump.verifyEditContactIframe(driver), "Failed to verify edit contact");
		Assert.assertTrue(ump.verifyLastnameChangeInAboutTab(driver,FileUtils.getUserMenuTestData("user.newlastname")),"Failed to verify lastname change");
		Assert.assertTrue(ump.verifyNewPost(driver,FileUtils.getUserMenuTestData("posttext")),"Failed to create new post");
		Assert.assertTrue(ump.verifyFileUpload(driver,FileConstants.FILE_UPLOAD_FILEPATH), "Failed to upload file");
		
	}
	
	
	@Test (enabled = true)
	//include CSV download verification login
	public void selectMySettings_TC07() throws IOException {
		UserMenuPage ump = new UserMenuPage(driver);
		ump.selectUserMenu(); 
		Assert.assertTrue(ump.verifyUserMenuOptions(), "Failed to verify Usermenu Options");
		ump.selectUserMenuOption(driver, FileUtils.getUserMenuTestData("usermenu.mysettings"));
		Assert.assertTrue(ump.verifyMySettingsPageDisplayed(driver),"Failed to load My Settings page");
		
		//Personal Menu, Login History
		ump.selectPersonalMenu(driver);
		ump.selectLoginHistory(driver);
		Assert.assertTrue(ump.verifyLoginHistoryDisplayed(),"Failed to display login history");
		ump.downloadLoginHistory(driver);
		//include CSV verification logic
		
		
		//Dipslay&Link Menu, Customize tabs
		  ump.customizeMyTabs(driver,FileUtils.getUserMenuTestData("custom.app.salesforce"),FileUtils.getUserMenuTestData("custom.tab.reports"));
		  Assert.assertTrue(ump.verifyTabInSelectedTabs(driver,FileUtils.getUserMenuTestData("custom.tab.reports")),"Failed to add reports tab in selected tabs"); 
		  ump.customizeTabsSave();
		  ump.selectAppMenuItem(driver,FileUtils.getUserMenuTestData("appmenu.salesforce"));
		  Assert.assertTrue(ump.verifyTabInTabBar(driver,FileUtils.getUserMenuTestData("custom.tab.reports")),"Falied to add reports tab in salesforce chatter tab bar");
		  ump.selectAppMenuItem(driver,FileUtils.getUserMenuTestData("appmenu.sales"));
		  Assert.assertTrue(ump.verifyTabInTabBar(driver,FileUtils.getUserMenuTestData("custom.tab.reports")),"Falied to add reports tab in sales tab bar"); 
		  ump.selectAppMenuItem(driver,FileUtils.getUserMenuTestData("appmenu.marketing"));
		  Assert.assertTrue(ump.verifyTabInTabBar(driver,FileUtils.getUserMenuTestData("custom.tab.reports")),"Falied to add reports tab in marketing tab bar");
		 
		
		//Email Menu, My Email Settings
		ump.selectUserMenu(); 
		ump.selectUserMenuOption(driver, FileUtils.getUserMenuTestData("usermenu.mysettings"));
		ump.performEmailSettings(driver, FileUtils.getUserMenuTestData("email.name"), FileUtils.getUserMenuTestData("email.address"));
		//not asserting the email address, bcoz it doesn't save the return address, but only gives an alert  
		Assert.assertTrue(ump.verifyEmailSettings(FileUtils.getUserMenuTestData("email.name")),"Falied to verify email settings");
		
		//Calendar & Reminders, Activity Reminders
		ump.selectCalendarAndReminders(driver);
		Assert.assertTrue(ump.verifyEventPopUpWindow(driver,FileUtils.getUserMenuTestData("reminder.popup.title")),"Failed to display event pop up window");
		
	}
	
	@Test (enabled = false)
	public void selectDeveloperConsole_TC08() throws IOException {
		UserMenuPage ump = new UserMenuPage(driver);
		ump.selectUserMenu(); 
		Assert.assertTrue(ump.verifyUserMenuOptions(), "Failed to verify Usermenu Options");
		ump.selectUserMenuOption(driver, FileUtils.getUserMenuTestData("usermenu.developerconsole"));
		Assert.assertTrue(ump.verifyDeveloperConsoleWindow(driver, FileUtils.getUserMenuTestData("developerconsole.title")),"Failed to display developer console window");
		ump.closeDeveloperConsoleWindow(driver);
		Assert.assertTrue(ump.verifyDeveloperConsoleWindowClosed(driver),"Failed to close developer console window");
	}
	
	@Test (enabled = false)
	public void logout_TC09() throws IOException, InterruptedException{
		UserMenuPage ump = new UserMenuPage(driver);
		LoginPage lp = new LoginPage(driver);
		ump.selectUserMenu(); 
		Assert.assertTrue(ump.verifyUserMenuOptions(), "Failed to verify Usermenu Options");
		ump.selectUserMenuOption(driver, FileUtils.getUserMenuTestData("usermenu.logout"));
		Thread.sleep(5000);  //implicit wait not working. tried using explicit wait for the login button to be clickable, then it works.
		Assert.assertEquals(lp.getPageTitle(driver),FileUtils.getLoginTestData("loginpage.title"));	
	}
	

}
