package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.FileUtils;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "idcard-identity")
	public WebElement inputUsername;
	
	@FindBy(name = "pw")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(id = "rememberUn")
	public WebElement rememberMe;
	
	@FindBy(id = "forgot_password_link")
	public WebElement forgotPassword;
	
	@FindBy(id="error") 
	public WebElement errorMessage;
	
	@FindBy(xpath="//a[text()='Home']")
	public WebElement homeTab;
	
	@FindBy(id = "un")
	public WebElement forgotPwdUsername;
	
	@FindBy(id = "continue")
	public WebElement forgotPwdContinueButton;
	
	@FindBy(xpath="//*[@class='mb12']")
	public WebElement checkYourEmailMessage;
	
	
	/**Launch URL
	 * @param driver
	 * @throws IOException
	 */
	public void launchApp(WebDriver driver) throws IOException {
		driver.get(FileUtils.getLoginTestData("prod.app.url"));
		driver.manage().window().maximize();
	}
	
	
	/**Get the title of the current page
	 * @param driver
	 * @return title of the current page
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	
	/**Input username field
	 * @param emailId
	 */
	public void enterUsername(String emailId) {
		if (username.isDisplayed()) {
			username.sendKeys(emailId);
		} else {
			System.out.println("LoginPage:enterUsername:Element not availabe:Username");
		}
	}
	
	
	/**Get the username entered
	 * @return username entered
	 */
	public String verifyUsername() {
		//return username.getText();
		return username.getAttribute("value");
	}
	
	
	
	/**Get the username saved during login
	 * @return username entered
	 */
	public String verifyInputUsername() {
		return inputUsername.getText();
	}
	
	
	/**Clear the password field
	 * 
	 */
	public void clearPassword() {
		if (password.isDisplayed()) {
		password.clear();
		} else {
			System.out.println("LoginPage:clearPassword:Element not availabe:Password");	
		}
	}
	
	
	/**Input password
	 * @param pwd
	 */
	public void enterPassword(String pwd) {
		if (password.isDisplayed()) {
			password.sendKeys(pwd);
		} else {
			System.out.println("LoginPage:enterPassword:Element not availabe:Password");
		}
	}
	
	
	/**Get the password
	 * @return password
	 */
	public String verifyPassword(){
		return password.getText();
	}
	
	
	/**Submit login button
	 * @param driver
	 */
	public void clickLogin(WebDriver driver) {
		if(CommonUtils.waitForElement(driver, loginButton)) {
			loginButton.click();
		} else {
			System.out.println("LoginPage:clickLogin:Element not availabe:Login");
		}
	}
	
	
	/**Get the error message if displayed
	 * @return text of the error message
	 */
	public String verifyErrorMessage(){
		if (errorMessage.isDisplayed()) {
			return errorMessage.getText();
		} else {
			return null;
		}
	}
	
	
	/**Check if home page is loaded
	 * @return true if home page is loaded, else false
	 */
	public boolean verifyHomePage() {
		boolean isHomePageDisplayed = false;
		if (homeTab.isDisplayed()) {
			isHomePageDisplayed = true;
		}
		return isHomePageDisplayed;
	}
	
	
	/**Select RememberMe check box in login page
	 * 
	 */
	public void selectRememberMe() {
		if (!rememberMe.isSelected()) {
			rememberMe.click();
		}
	}
	
	
	/**Verify if RememberMe check box in login page is checked
	 * @return true if RememberMe check box is checked, else false
	 */
	public boolean checkRememberMe() {
		boolean isRememberMeSelected = false;
		if (rememberMe.isSelected()) {
			isRememberMeSelected = true;
		}
		return isRememberMeSelected;
	}
	
	
	/**Click forgot password button
	 * @param driver
	 */
	public void selectForgotPassword(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, forgotPassword)){
			forgotPassword.click();
		}
	}
	
	
	/**Input username in forgot password page
	 * @param emailId
	 */
	public void enterForgotPwdUsername(String emailId) {
		if(forgotPwdUsername.isDisplayed()) {
			forgotPwdUsername.sendKeys(emailId);
		} else {
			System.out.println("LoginPage:enterForgotPwdUsername:Element not availabe:Forgot Password Username");
		}
	}
	
	
	/**Submit forgot password continue button
	 * 
	 */
	public void selectForgotPwdContinueButton() {
		forgotPwdContinueButton.click();
	}
	
	
	/**Verify if email sent message is displayed after submitting forgot password
	 * @return true if message displayed, else false
	 */
	public boolean checkEmailMessage() {
		boolean isCheckEmailMessagedisplayed=false;
		if (checkYourEmailMessage.isDisplayed()) {
			isCheckEmailMessagedisplayed = true;
		}
		return isCheckEmailMessagedisplayed;
	}
	
	
	/**Launch url and login
	 * @param driver
	 * @throws IOException
	 */
	public void loginToApp(WebDriver driver) throws IOException {
		driver.get(FileUtils.getLoginTestData("prod.app.url"));
		driver.manage().window().maximize();
		if(CommonUtils.waitForElement(driver, username)) {
			username.sendKeys(FileUtils.getLoginTestData("prod.username"));
			password.sendKeys(FileUtils.getLoginTestData("prod.password"));
			loginButton.click();
		}else {
			System.out.println("LoginPage:loginToApp:Could not login");
		}
		
	}
	
}
