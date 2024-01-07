package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class BasePage {
	
	public static Logger logger = LogManager.getLogger();
	
	@FindBy(id = "createNewButton")
	public WebElement createNewButton;
	
	@FindBy(id = "createNewMenu")
	public WebElement createNewMenu;
	
	//@FindBy(className = "accountMru menuButtonMenuLink")
	@FindBy(xpath = "//*[@class='accountMru menuButtonMenuLink']")
	public WebElement createNewAccount;
	
	@FindBy(xpath = "//*[@class='opportunityMru menuButtonMenuLink']")
	public WebElement createNewOpportunity;
	
	public void createNew(WebDriver driver, String option) {
		createNewButton.click();
		if(CommonUtils.waitForElement(driver, createNewMenu)) {
			switch (option) {
				case "Account":
					createNewAccount.click();
					break;
				case "Opportunity":
					createNewOpportunity.click();
					break;
				default:
					System.out.println("Base Page:createNew:Invalid option");
					break;
			}
					
		}
		
	}
	

}
