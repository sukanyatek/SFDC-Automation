package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.CommonUtils;
import utils.FileUtils;

/**
 * 
 */
public class UserMenuPage extends BasePage {

	public UserMenuPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userNavButton")
	public WebElement userMenu;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
	@FindBy(linkText = "My Profile") 
	public WebElement myProfile;
	
	
	@FindBy(linkText = "My Settings")
	public WebElement mySettings;
	
	@FindBy(linkText = "Developer Console")
	public WebElement developerConsole;
	
	@FindBy(partialLinkText = "Switch to")
	public WebElement switchTo;
	
	@FindBy(linkText = "Logout")
	public WebElement logoutOption;
	
	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;
	
	@FindBy (xpath = "//a[contains(@class,'contactInfoLaunch')]//child::img") 
	public WebElement editContact;
	
	@FindBy (id = "contactInfoContentId")
	public WebElement editContactIframe;
	
	@FindBy (id = "aboutTab")
	public WebElement aboutTab;
	
	@FindBy (id = "contactTab")
	public WebElement contactTab;
	
	@FindBy (id = "lastName")
	public WebElement aboutTabLastName;
	
	@FindBy (xpath = "//input[@value='Save All']")
	public WebElement saveAllButton;
	
	@FindBy (id = "tailBreadcrumbNode")
	public WebElement userDisplayName;
	
	@FindBy (id = "publisherAttachTextPost")
	public WebElement post;
	
	@FindBy (xpath = "//iframe[contains(@title,'Rich Text Editor')]")
	public WebElement postIframe;
	
	@FindBy (xpath = "//body[contains(@class,'chatterPublisherRTE')]")
	public WebElement postTextArea;
	
	@FindBy(id = "publishersharebutton")
	public WebElement shareButton;
	
	@FindBy(id = "publisherAttachContentPost")
	public WebElement fileLink;
	
	@FindBy(id = "chatterUploadFileAction")
	public WebElement fileUpload;
	
	@FindBy(xpath = "//input[@id='chatterFile']")
	public WebElement chooseFile;
	
	@FindBy(id = "progressIcon")
	public WebElement progressIcon;
	
	@FindBy(xpath = "//input[@value=\"Cancel Upload\"]")
	public WebElement cancelUploadButton;
	
	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]") //Index 1 gives the File Title of the first file in the list (recently uploaded)
	public WebElement verifyFilePost;
	
	@FindBy(id = "displayBadge")
	public WebElement moderatorButton;
	
	@FindBy(id = "uploadLink")
	public WebElement photoUploadButton;
	
	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;
	
	@FindBy(xpath= "//input[@class = 'fileInput']")
	public WebElement photoFileName;
	
	@FindBy(id = "j_id0:uploadFileForm:save")
	public WebElement savePhotoButton;
	
	@FindBy(xpath= "//span[@class='folderIcon PersonalSetup_icon']")
	public WebElement mySettingsMenu;
	
	@FindBy(xpath = "//*[@class='noSecondHeader pageType']")
	public WebElement mySettingsPage;
	
	@FindBy(id = "PersonalInfo_font")
	public WebElement personalMenu;
	
	@FindBy(xpath = "//*[text()='Login History']")
	public WebElement loginHistoryOption;
	
	@FindBy(xpath = "//div[@class='pbHeader']")
	public WebElement loginHistoryDetails;
	
	@FindBy(xpath = "//table[@class='list']")
	public WebElement loginHistoryTable;
	
	@FindBy(partialLinkText = "Download login history")
	public WebElement downloadLoginHistory;
	
	@FindBy(id = "DisplayAndLayout_font")
	public WebElement displayAndLayoutMenu;
	
	@FindBy(id = "CustomizeTabs_font")
	public WebElement customizeMyTabs;
	
	@FindBy(id = "p4")
	public WebElement customAppDropdown;
	
	@FindBy(id = "duel_select_0")
	public WebElement availableTabsDropdown;
	
	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	public WebElement addArrow;
	
	@FindBy(id = "duel_select_1")
	public WebElement selectedTabsDropdown;
	
	@FindBy(xpath="//input[@class='btn primary']")
	public WebElement customizeTabsSaveButton;
	
	@FindBy(xpath = "//*[@id='tabBar']/li/a")
	public List<WebElement> tabBarOptions;
	
	@FindBy(id = "tsidButton")
	public WebElement appMenuCurrentOption;
	
	@FindBy(id = "EmailSetup_font")
	public WebElement emailMenu;
	
	@FindBy(xpath = "//*[text()='My Email Settings']")
	public WebElement emailSettings;
	
	@FindBy(id = "sender_name")
	public WebElement emailName;
	
	@FindBy(id = "sender_email")
	public WebElement emailAddress;
	
	@FindBy(id = "auto_bcc1")
	public WebElement autoBccYes;
	
	@FindBy(name = "save")
	public WebElement emailSettingsSave;
	
	@FindBy(xpath = "//*[@class='messageText']")
	public WebElement emailSettingsSavedMessage;
	
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement calendarAndRemindersMenu;
	
	@FindBy(xpath = "//*[text()='Activity Reminders']")
	public WebElement activityReminders;
	
	@FindBy(id = "testbtn")
	public WebElement openTestReminderButton;
	

	/**Click usermenu 
	 * 
	 */
	public void selectUserMenu() {
		if(userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("UserMenuPage:selectUserMenu:Element not available:User Menu");
		}
	}
	
	/**Check if the username displayed is valid
	 * @param userName
	 * @return true if the username is valid, else false
	 */
	public boolean verifyHomepageUsername(String userName){
		boolean isUserNameDisplayed = false;
		if(userMenu.isDisplayed()) {
			if(userMenu.getText().equals(userName)){
			isUserNameDisplayed = true;
			} 
		} else {
				System.out.println("UserMenuPage:verifyHomepageUsername:Element not available:User Menu");
		}
		return isUserNameDisplayed;
	}
	
	/**Verify if all the options of usermenu are displayed as expected
	 * @return true if all options are as expected, else false
	 * @throws IOException
	 */
	public boolean verifyUserMenuOptions() throws IOException {
		boolean allOptionsVerified = true;
		String[] expectedUserMenuOptions = FileUtils.getUserMenuTestData("usermenu.items").split(",");
		for(int i=0; i < expectedUserMenuOptions.length; i++) {
			String actualOption = userMenuOptions.get(i).getText();
			if(expectedUserMenuOptions[i].equals(actualOption)) {
				System.out.println("UserMenuPage:verifyUserMenuOptions: Expected Option: " + expectedUserMenuOptions[i] + ", Actual Option: " + actualOption);
			} else {
				System.out.println("UserMenuPage:verifyUserMenuOptions: Expected Option: " + expectedUserMenuOptions[i] + " Actual Option: " + actualOption);
				allOptionsVerified = false;
			}
		}
		return allOptionsVerified;
			
	}
	
	/**Select the user menu option passed
	 * @param driver
	 * @param option to select
	 */
	public void selectUserMenuOption(WebDriver driver, String option) {
			WebElement userMenuOption = driver.findElement(By.linkText(option));  
			if(CommonUtils.waitForElement(driver, userMenuOption)) {
			userMenuOption.click();
			} 
	}
	
	/**Verify if the profile page is loaded
	 * @return true if profile page displayed, else false
	 */
	public boolean verifyProfilePageDispalyed() {
		return profilePage.isDisplayed();
	}
	
	/**Select edit contact
	 * @param driver
	 */
	public void selectEditContact(WebDriver driver) {
		if(CommonUtils.waitForElement(driver, editContact)) {
			editContact.click();
		}
	}
	
	/**Verify if the tabs 'About' and 'Contact' are displayed in the edit contact frame 
	 * @param driver
	 * @return true if the expected tabs are displayed, else false
	 */
	public boolean verifyEditContactIframe(WebDriver driver) {
		boolean isIframeloaded = false;
		if(CommonUtils.waitForElement(driver,editContactIframe)){
			driver.switchTo().frame(editContactIframe);
			if (aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeloaded = true;
			}
		}
		return isIframeloaded;
	}
	
	/**Change the lastname in about tab and verify if the same is reflected in the profile page 
	 * @param driver
	 * @param newLastname
	 * @return true is the lastname is changed as expected, else false
	 */
	public boolean verifyLastnameChangeInAboutTab(WebDriver driver, String newLastname) {
		boolean isNameChangeVerified = false;
		if (CommonUtils.waitForElement(driver, aboutTab)) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(newLastname);
			saveAllButton.click();
			driver.switchTo().defaultContent();
			if (userDisplayName.isDisplayed()) {
				String displayName = userDisplayName.getText();
				if (displayName.contains(newLastname)) {
					isNameChangeVerified = true;
				}
			} else {
				System.out
						.println("UserMenuPage:verifyLastnameChangeInAboutTab:Element not available:User display name");
			}
		}
		return isNameChangeVerified;
	}
	 
	
	/**Create a new post and share 
	 * @param driver
	 * @param message
	 * @return true is post created, else false
	 */
	public boolean verifyNewPost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if (post.isDisplayed()) {
			post.click();
			if (CommonUtils.waitForElement(driver, postIframe)) {
				driver.switchTo().frame(postIframe);
				postTextArea.sendKeys(message);
				driver.switchTo().defaultContent();
				if (shareButton.isDisplayed()) {
					shareButton.click();
					isPostCreated = true;
				}
			}
		}
		return isPostCreated;
	}
	
	/**Upload file and verify if successful
	 * @param driver
	 * @param filePath
	 * @return true if file uploaded, else false
	 */
	public boolean verifyFileUpload(WebDriver driver, String filePath) {
		boolean isFileUploaded = false;
		if (fileLink.isDisplayed()) {
			fileLink.click();
			if (CommonUtils.waitForElement(driver, fileUpload)) {
				fileUpload.click();
			}
			if (CommonUtils.waitForElement(driver, chooseFile)) {
				chooseFile.sendKeys(filePath);
				shareButton.click();
				if (CommonUtils.waitForElementToDisappear(driver, cancelUploadButton)) {
					if (verifyFilePost.isDisplayed()) {
						isFileUploaded = true;
					}
				}
			}
		}
		return isFileUploaded;
	}
	
	
	/**Verify if my settings page is loaded
	 * @param driver
	 * @return true if my settings page is loaded, else false
	 */
	public boolean verifyMySettingsPageDisplayed(WebDriver driver) {
		//boolean isMySettingsPageDisplayed = false;
		//return CommonUtils.waitForElement(driver, mySettingsMenu);
		return mySettingsPage.isDisplayed();	
		
	}
	
	
	/**Select Personal Menu in My settings
	 * @param driver
	 */
	public void selectPersonalMenu(WebDriver driver) {
		if(CommonUtils.waitForElement(driver, personalMenu)) {
			personalMenu.click();
		}
	}
	
	/**Select Login History
	 * @param driver
	 */
	public void selectLoginHistory(WebDriver driver) {
		if(CommonUtils.waitForElement(driver, loginHistoryOption)) {
			loginHistoryOption.click();
		}
	}
	
	/**Verify if login history is generated
	 * @return true if login history is displayed, else false
	 */
	public boolean verifyLoginHistoryDisplayed() {
		boolean isLoginHistoryDisplayed = false;
		if (loginHistoryDetails.isDisplayed() && loginHistoryTable.isDisplayed()) {
			isLoginHistoryDisplayed = true;
		}
		return isLoginHistoryDisplayed;
	}
	
	/**Select download login histoty link
	 * @param driver
	 */
	public void downloadLoginHistory(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, downloadLoginHistory)) {
			downloadLoginHistory.click();
		}
	}
	
	
	/**Select Display&Layout Menu and then Customize My Tabs. Select the Custom App from the dropdown and then add a tab from available tabs dropdown.
	 * @param driver
	 * @param customAppToSelect
	 * @param tabToAdd
	 */
	public void customizeMyTabs(WebDriver driver, String customAppToSelect, String tabToAdd) {
		displayAndLayoutMenu.click();
		if(CommonUtils.waitForElement(driver, customizeMyTabs)) {
			customizeMyTabs.click();
			Select dropDown;
			dropDown = new Select(customAppDropdown);
			dropDown.selectByVisibleText(customAppToSelect);
			dropDown = new Select(availableTabsDropdown);
			dropDown.selectByVisibleText(tabToAdd);
			addArrow.click();
			}
	}
	
	/**Verify if the tab selected appears in the selected tabs
	 * @param driver
	 * @param tabToAdd
	 * @return true if the tab is added, else false
	 */
	public boolean verifyTabInSelectedTabs(WebDriver driver, String tabToAdd) {
		boolean isTabAdded = false;
		Select dropDown = new Select(selectedTabsDropdown);
		List<WebElement> selectedTabs = dropDown.getOptions();
		for (int i = 0; i < selectedTabs.size(); i++) {
			if (selectedTabs.get(i).getText().equals(tabToAdd)) {
				isTabAdded = true;
			}
		}
		return isTabAdded;
	}
	
	/**Click the customize tabs save button
	 * 
	 */
	public void customizeTabsSave() {
		customizeTabsSaveButton.click();
	}
	
	
	/**Select the App Menu 
	 * @param driver
	 * @param option
	 */
	public void selectAppMenuItem(WebDriver driver, String option) {
		//Check the current option in the AppMenu. If its different from the option passed, click it and select the option passed from the dropdown. 
		if(!appMenuCurrentOption.getText().equals(option)) {
			appMenuCurrentOption.click();
			WebElement appMenuItem = driver.findElement(By.linkText(option));
			if(CommonUtils.waitForElement(driver, appMenuItem)) {
				appMenuItem.click();
			}
			
		}
	}
	
	/**Verify if the tab that was added appears in the tab bar of the selected App Menu
	 * @param driver
	 * @param tabAdded
	 * @return true is tab appears, else false
	 */
	public boolean verifyTabInTabBar(WebDriver driver, String tabAdded) {
		boolean isTabAdded = false;
		for (int i=0; i<tabBarOptions.size(); i++) {
			if(tabBarOptions.get(i).getText().equals(tabAdded)) {
				isTabAdded = true;
				break;
			}
		}
		return isTabAdded;
	}
	
	/**Select email menu and then email settings. Do a change in the email name and address and save.
	 * @param driver
	 * @param name
	 * @param email
	 */
	public void performEmailSettings(WebDriver driver, String name, String email) {
		emailMenu.click();
		if(CommonUtils.waitForElement(driver, emailSettings)) {
			emailSettings.click();
			emailName.clear();
			emailName.sendKeys(name);
			emailAddress.clear();
			emailAddress.sendKeys(email);
			autoBccYes.click();
			emailSettingsSave.click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}
	
	/**Verify if the change in email settings is saved.
	 * @param name
	 * @return true if email settings saved, else false
	 */
	public boolean verifyEmailSettings(String name) {
		boolean isEmailSettingsVerified = false;
		if (emailSettingsSavedMessage.isDisplayed()) {
			if (emailName.getAttribute("value").equals(name)) {
				isEmailSettingsVerified = true;
			}
		}
		return isEmailSettingsVerified;	
	}
	
	/**Select Calendar & Reminders menu and then activity reminders. Click open test reminder button.
	 * @param driver
	 */
	public void selectCalendarAndReminders(WebDriver driver){
		calendarAndRemindersMenu.click();
		if(CommonUtils.waitForElement(driver, activityReminders)) {
			activityReminders.click();
			if(CommonUtils.waitForElement(driver, openTestReminderButton)) {
				openTestReminderButton.click();
			}
		}
		
	}
	
	/**Verify if the event pop up window appears
	 * @param driver
	 * @param title
	 * @return true if event pop up window appears, else false
	 */
	public boolean verifyEventPopUpWindow(WebDriver driver, String title) {
		boolean isEventPopUpWindowDisplayed = false;
		if (CommonUtils.waitForWindowToAppear(driver, 2)) {
			String parentWindow = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					if(driver.getTitle().contains(title)){
						isEventPopUpWindowDisplayed = true;
					}
				}
			}
		}
		return isEventPopUpWindowDisplayed;
	}
	
	
	String parentWindow; 
	/** Verify if the developer console window is loaded
	 * @param driver
	 * @param title
	 * @return true if developer console is displayed
	 */
	public boolean verifyDeveloperConsoleWindow(WebDriver driver, String title) {
		boolean isDeveloperConsoleWindowDisplayed = false;
		if (CommonUtils.waitForWindowToAppear(driver, 2)) {
			parentWindow = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					if(driver.getTitle().equals(title)){
						isDeveloperConsoleWindowDisplayed = true;
					}
				}
			}
		}
		return isDeveloperConsoleWindowDisplayed;
	}
	
	/**Close the developer console window
	 * @param driver
	 */
	public void closeDeveloperConsoleWindow(WebDriver driver) {
		driver.close();		
	}
	
	/**Verify if the developer console window is closed
	 * @param driver
	 * @return true if developer console window is closed else false
	 */
	public boolean verifyDeveloperConsoleWindowClosed(WebDriver driver) {
		boolean isDeveloperConsoleWindowClosed = false;
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1) {
			isDeveloperConsoleWindowClosed = true;
		}
		return isDeveloperConsoleWindowClosed;
	}
	
}
