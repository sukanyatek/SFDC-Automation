package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;
import utils.FileUtils;

public class LeadsPage extends BasePage {
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='Lead_Tab']/a")
	public WebElement leadsTab;
	
	@FindBy(id = "fcf")
	public WebElement leadsDropdown;
	
	@FindBy(xpath = "//*[@class='title']")
	public WebElement leadsDropdownViewPage;
	
	@FindBy(xpath = "//input[@title='Go!']")
	public WebElement leadsDropdownGoButton;
	
	
	
	public boolean selectLeadsTab(WebDriver driver) throws IOException {
		boolean isLeadsHomepageDisplayed = false;
		leadsTab.click();
		if(driver.getTitle().contains(FileUtils.getLeadsTestData("leads.page.title"))) {
			isLeadsHomepageDisplayed = true;
		}
		return isLeadsHomepageDisplayed;
	}
	
	public boolean verifyLeadsDropdown() throws IOException {
		boolean allOptionsVerified = true;
		leadsDropdown.click();
		String[] expectedOptions = FileUtils.getLeadsTestData("leads.dropdown.options").split(",");
		List<WebElement> actualOptions = (new Select(leadsDropdown)).getOptions();
		for(int i=0; i<expectedOptions.length;i++) {
			if(!expectedOptions[i].equals(actualOptions.get(i).getText())){
				allOptionsVerified = false;
				break;
			}
		}
		return allOptionsVerified;
		
	}
	
	public void selectLeadsDropdown(String option) {
		leadsDropdown.click();
		(new Select(leadsDropdown)).selectByVisibleText(option);
	}
	
	public boolean verifyLeadsDropdownSelected(WebDriver driver, String option) {
		boolean dropdownVerified = false;
		if((new Select(leadsDropdown)).getFirstSelectedOption().getText().equals(option)) {
			leadsDropdownGoButton.click();
			if(CommonUtils.waitForElement(driver,leadsDropdownViewPage)) {
				if((new Select(leadsDropdownViewPage)).getFirstSelectedOption().getText().equals(option)) {
					dropdownVerified = true;
				}	
			}
		}
		return dropdownVerified;
	}
	
	
}
