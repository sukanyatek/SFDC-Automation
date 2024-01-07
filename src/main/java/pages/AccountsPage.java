package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.BaseTest;
import utils.CommonUtils;

public class AccountsPage extends BasePage {
	
	
	  public AccountsPage(WebDriver driver) { 
		  PageFactory.initElements(driver,
	  this); }
	 
	
	@FindBy(xpath = "//*[@id='Account_Tab']/a")
	public WebElement accountsTab;
	
	
	@FindBy(id = "acc2")
	public WebElement accountName;	

	@FindBy(id = "acc6")
	public WebElement accountTypeDropdown;
	
	@FindBy(id = "00NHo00000QyxMR")
	public WebElement customerPriorityDropdown;
	
	@FindBy(name = "save")
	public List<WebElement> accountSaveButton;
	
	@FindBy(xpath = "//*[@class='topName']")
	public WebElement accountNameTop;
	
	@FindBy(xpath = "//*[text()='Account Detail']")
	public WebElement accountDetail;
	
	@FindBy(id = "acc2_ileinner")
	public WebElement newAccountName;
	
	@FindBy(id = "acc6_ileinner")
	public WebElement newAccountType;
	
	@FindBy(id = "00NHo00000QyxMR_ileinner")
	public WebElement newAccountCustomerPriority;
	
	//@FindBy(className = "title")
	@FindBy(xpath = "//*[@class='title']")
	public WebElement viewDropdownFinal;
	
	@FindBy(id = "fcf")
	public WebElement viewDropdownInitial;
	
	@FindBy(linkText = "Create New View")
	public WebElement createNewView;
	
	@FindBy(linkText = "Edit")
	public WebElement editView;
	
	@FindBy(id = "fname")
	public WebElement viewName;
	
	@FindBy(id = "devname")
	public WebElement viewUniqueName;
	
	@FindBy(id = "fcol1")
	public WebElement filter1FieldDropdown;
	
	@FindBy(id = "fop1")
	public WebElement filter1OperatorDropdown;
	
	@FindBy(id = "fval1")
	public WebElement filter1Value;
	
	@FindBy(id = "colselector_select_0")
	public WebElement availableFieldsDropdown;
	
	@FindBy(id = "colselector_select_1")
	public WebElement selectedFieldsDropdown;
	
	@FindBy(xpath = "//*[@id='colselector_select_0_right']/img")
	public WebElement addButton;
	
	@FindBy(xpath = "(//*[@class='btn primary'])[1]")
	public WebElement viewSaveButton;
	
	@FindBy(xpath = "//*[@title='Last Activity']")
	public WebElement lastActivityColumn;
	
	@FindBy(linkText = "Merge Accounts")
	public WebElement mergeAccountLink;
	
	@FindBy(id = "srch")
	public WebElement accountsToSearch;
	
	@FindBy (xpath="//input[@value='Find Accounts' and @title='Find Accounts']")
	public WebElement findAccountButton;
	
	@FindBy(xpath = "(//input[@name='goNext'])[2]")
	public WebElement nextButton;
	
	@FindBy(xpath = "//h2[contains(text(),'Step 2')]")
	public WebElement step2MergeAccount;
	
	@FindBy(xpath = "(//*[@title='Merge'])[2]")
	public WebElement mergeButton;
	
	@FindBy(partialLinkText =  "Accounts with ")
	public WebElement accountsWithLastActivityGT30;
	
	@FindBy(id = "ext-gen20")
	public WebElement dateField;
	
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	public WebElement createdDate;
	
	/*
	 * @FindBy(id = "ext-gen152") public WebElement fromDateCalendar;
	 * 
	 * @FindBy(id = "ext-gen266") public WebElement fromDateCalendarToday;
	 * 
	 * @FindBy(id = "ext-gen154") public WebElement toDateCalendar;
	 * 
	 * @FindBy(id = "ext-gen306") public WebElement toDateCalendarToday;
	 */
	
	@FindBy(name = "startDate")
	public WebElement startDate;
	
	@FindBy(name = "endDate")
	public WebElement endDate;
	
	@FindBy(id = "ext-gen49")
	public WebElement saveButton;
	
	@FindBy(name = "reportName")
	public WebElement reportName;
	
	@FindBy(name = "reportDevName")
	public WebElement reportUniqueName;
	
	@FindBy(xpath = "//table[@id='dlgSaveAndRun']//tr[2]/td[2]/em/button")
	public WebElement saveAndRunButton;
	
	//@FindBy(xpath = "//*[text()='Save and Run Report']")
	//public WebElement saveAndRunButton;
	
	
	
	@FindBy(xpath = "//*[@class='noSecondHeader pageType']")
	public WebElement reportHeading;
	
	
	
	
	
	/**Verify if Accounts Page is loaded
	 * @param driver
	 * @param title - partial title of the accounts page
	 * @return true if Accounts Page is loaded, else false
	 */
	public boolean verifyAccountsPage(WebDriver driver, String title){
		logger.info("AccountsPage:verifyAccountsPage:");
		boolean isAccountsPageVerified = false;
		accountsTab.click();
		if(driver.getTitle().contains(title)) {
			isAccountsPageVerified = true;
		}
		return isAccountsPageVerified;
	}
	
	
	/**Create new Accounts with details passed
	 * @param driver
	 * @param accName 
	 * @param type
	 * @param priority
	 */
	public void createNewAccount(WebDriver driver, String accName, String type, String priority) {
		/*
		 * createNewButton.click(); 
		 * if(CommonUtils.waitForElement(driver,             --->moved this code to basepage to have a common mehtod for create new for account, opportunity etc
		 * createNewAccount)) { createNewAccount.click();
		 */
			accountName.sendKeys(accName);
			Select dropdown;
			dropdown = new Select(accountTypeDropdown);
			dropdown.selectByVisibleText(type);
			dropdown = new Select(customerPriorityDropdown);
			dropdown.selectByVisibleText(priority);
			accountSaveButton.get(0).click();	
		//}	
	}
	
	/**Verify if new account details are as per test data
	 * @param accName
	 * @param type
	 * @param priority
	 * @return true if account details match with input details, else false
	 */
	public boolean verifyNewAccount(String accName, String type, String priority) {
		boolean verifiedNewAccountDetails = false;
		if (accountDetail.isDisplayed()) {
			if (accountNameTop.isDisplayed() //&& newAccountName.getText().equals(accName)
					&& newAccountType.getText().equals(type) && newAccountCustomerPriority.getText().equals(priority)) {
				verifiedNewAccountDetails = true;

			}
		}
		return verifiedNewAccountDetails;
	}
	
	/**Create new view with details passed and verify 
	 * @param driver
	 * @param name
	 * @param uniqueName
	 * @return true if the new view created appears in the views drop down, else false
	 */
	public boolean createNewViewAndVerify(WebDriver driver, String name, String uniqueName) {
		boolean isNewViewVerified=false;
		//Create new view
		createNewView.click();
		viewUniqueName.clear();
		viewUniqueName.sendKeys(uniqueName);
		viewName.clear();
		viewName.sendKeys(name);
		
		viewSaveButton.click();
		
		//Verify if new view is available in the view dropdown
		if(CommonUtils.waitForElement(driver, viewDropdownFinal)) {
			Select dropdown = new Select(viewDropdownFinal);
			List<WebElement> viewNames = dropdown.getOptions();
			for (int i=0; i<viewNames.size(); i++) {
				if (viewNames.get(i).getText().equals(name)) {
					isNewViewVerified = true;
				}
			}
		}
		return isNewViewVerified;
	}
	
	/**Select edit view and verify
	 * @param driver
	 * @param name
	 * @param title
	 * @return true if edit view page is loaded, else false
	 */
	public boolean selectEditViewAndVerify(WebDriver driver, String name, String title) {
		boolean isEditViewPageDisplayed = false;
		if(CommonUtils.waitForElement(driver, viewDropdownInitial)) {
			Select dropdown = new Select(viewDropdownInitial);
			dropdown.selectByVisibleText(name);
			editView.click();	
			if(driver.getTitle().contains(title)) {
				isEditViewPageDisplayed = true;	
			}
		}
		return isEditViewPageDisplayed;
	}
	
	/**Edit view by changing the fields input and verify
	 * @param name
	 * @param newName
	 * @param filterField
	 * @param operator
	 * @param value
	 * @param displayField
	 * @return true if the edited view is available in the views dropdown and displayField is available in the view
	 */
	public boolean editViewAndVerify(String name, String newName, String filterField, String operator, String value, String displayField) {
		boolean isNewViewDisplayed = false, isNewColumnDisplayed = false;
		viewName.clear();
		viewName.sendKeys(newName);
		Select dropdown;
		dropdown = new Select(filter1FieldDropdown);
		dropdown.selectByVisibleText(filterField);
		dropdown = new Select(filter1OperatorDropdown);
		dropdown.selectByVisibleText(operator);
		filter1Value.clear();
		filter1Value.sendKeys(value);
		
		//Check if displayFied is already present in the selected fields dropdown
		dropdown = new Select(selectedFieldsDropdown);
		List<WebElement> options = dropdown.getOptions();
		boolean displayFieldPresent = false;
		for (int i=0; i<options.size(); i++) {
			if(options.get(i).getText().equals(displayField)) {
				displayFieldPresent = true;
				break;
			}
		}
		//If display field is already not present in the selected fields, select it from the available fields
		if (!displayFieldPresent) {
			dropdown = new Select(availableFieldsDropdown);
			dropdown.selectByVisibleText(displayField);
			addButton.click();
		}
		viewSaveButton.click();
		
		//Check if the edited view name is available in the views dropdown
		dropdown = new Select(viewDropdownFinal);
		List<WebElement> viewNames = dropdown.getOptions();
		for (int i=0; i<viewNames.size(); i++) {
			if (viewNames.get(i).getText().equals(newName)) {
				isNewViewDisplayed = true;
			}
		}
		
		if(lastActivityColumn.isDisplayed()) {
			isNewColumnDisplayed = true;			
		} 
		
		return (isNewViewDisplayed & isNewColumnDisplayed);
	}
	
	/**Select the accounts to merge and verify
	 * @param driver
	 * @param title
	 * @param searchKey
	 * @return true if the merge accounts page is displayed
	 */
	public boolean verifyAccountsSelectedToMerge(WebDriver driver, String title, String searchKey) {
		logger.info("AccountsPage:verifyAccountsSelectedToMerge:");
		boolean verifiedAccountsToMerge = false;
		mergeAccountLink.click();
		accountsToSearch.sendKeys(searchKey);
		findAccountButton.click();
		nextButton.click();
		
		if(driver.getTitle().contains(title) && step2MergeAccount.isDisplayed()) {
			//inlclude verifying the accounts here - todo
			verifiedAccountsToMerge = true;
		}
		return verifiedAccountsToMerge;
	}
	
	/**Merge acccounts and verify
	 * @param driver
	 * @return true id the accounts are merged successfully
	 */
	public boolean verifyMergeAccounts(WebDriver driver) {
		logger.info("AccountsPage:verifyMergeAccounts:");
		boolean verifiedMergeAccounts = false;
		mergeButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		verifiedMergeAccounts = true;
		return verifiedMergeAccounts;
	}
	
	
	
	public boolean createAccountReport(WebDriver driver, String title) {
		logger.info("AccountsPage:createAccountReport:");
		boolean isUnsavedReportPageDisplayed = false;
		accountsWithLastActivityGT30.click();
		if(driver.getTitle().contains(title)) {
			isUnsavedReportPageDisplayed = true;
		}
		return isUnsavedReportPageDisplayed;
	}
	
	
	
	public void selectReportOptions(WebDriver driver) {
		logger.info("AccountsPage:selectReportOptions:");
		dateField.click();
		if(CommonUtils.waitForElement(driver, createdDate)) {
			createdDate.click();
			startDate.clear();
			startDate.sendKeys(CommonUtils.getCurrentDate());
			endDate.clear();
			endDate.sendKeys(CommonUtils.getCurrentDate());
			//verify list of accounts -- table todo
		}
	}
	
	public boolean saveReport(WebDriver driver, String report, String uniqueReport) throws InterruptedException {
		logger.info("AccountsPage:saveReport:");
		boolean isReportDisplayed = false;
		saveButton.click();
		reportUniqueName.clear();
		reportUniqueName.sendKeys(uniqueReport);
		reportName.sendKeys(report);
		Thread.sleep(5000); //why is the below explicit wait not working? had to give sleep. Also, the saved report is not picking the end date correctly
		if(CommonUtils.waitForElement(driver, saveAndRunButton)) {
			saveAndRunButton.click();
		
			if(reportHeading.getText().equals(report)) {
				isReportDisplayed = true;
			}
		}
		//verify report details -- table, todo
		return isReportDisplayed;
	}
	
}

