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

public class OpportunitiesPage extends BasePage {
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='Opportunity_Tab']/a")
	public WebElement opportunitiesTab;
	
	@FindBy(id = "fcf")
	public WebElement opportunitiesDropdown;
	
	@FindBy(id = "opp3")
	public WebElement opportunityName;
	
	@FindBy(id = "opp4")
	public WebElement accountName;
	
	@FindBy(id = "opp6")
	public WebElement leadSource;
	
	@FindBy(id = "opp9")
	public WebElement closeDate;
	
	@FindBy(xpath = "//*[@class='calToday']")  //today button in the calendar
	public WebElement dateToday;
	
	@FindBy(xpath = "//*[@class='dateFormat']/a")  //today button in the calendar
	public WebElement currentDate;
	
	@FindBy(id = "opp11")
	public WebElement stage;
	
	@FindBy(id = "opp12")
	public WebElement probability;
	
	@FindBy(id = "opp17")
	public WebElement primaryCampaignSource;
	
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[@name='save']")
	public WebElement newOppSaveButton;
	
	@FindBy(xpath = "//*[@class='pageType']")
	public WebElement newOppPage;
	
	@FindBy(xpath = "//*[@class='pageDescription']")
	public WebElement newOppPageDescription;
	
	@FindBy(id = "opp3_ileinner")
	public WebElement newOppName;
	
	@FindBy(xpath = "//*[@id='opp4_ileinner']/a")
	public WebElement newAccout;
	
	@FindBy(id = "opp6_ileinner")
	public WebElement newLeadSource;
	
	@FindBy(id = "opp9_ileinner")
	public WebElement newCloseDate;
	
	@FindBy(id = "opp11_ileinner")
	public WebElement newStage;
	
	@FindBy(id = "opp12_ileinner")
	public WebElement newProbability;
	
	@FindBy(linkText = "Opportunity Pipeline") 
	public WebElement oppPipelineLink;
	
	@FindBy(xpath = "//*[text()='Opportunity Pipeline']") 
	public WebElement oppPipelineReport;
	
	@FindBy(id = "status")
	public WebElement reportStatus;
	
	@FindBy(linkText = "Stuck Opportunities") 
	public WebElement stuckOppLink;

	@FindBy(xpath = "//*[text()='Stuck Opportunities']") 
	public WebElement stuckOppReport;
	
	@FindBy(id = "quarter_q")
	public WebElement quarterlySummaryInterval;
	
	@FindBy(id = "open")
	public WebElement quarterlySummaryInclude;
	
	@FindBy(xpath = "//*[@value='Run Report']") 
	public WebElement runReportButton;	
	
	@FindBy(xpath = "//*[text()='Opportunity Report']") 
	public WebElement quarterlySummReport;
	
	
	public boolean selectOpportunitiesTab(WebDriver driver) throws IOException {
		boolean isOppHomePageloaded = false;
		opportunitiesTab.click();
		if(driver.getTitle().contains(FileUtils.getOpportunitiesTestData("opportunities.page.title"))) {
			isOppHomePageloaded = true;
		}
		return isOppHomePageloaded;	
	}
	
	public boolean verifyOppDropdown() throws IOException {
		boolean allOptionsVerified = true;
		List<WebElement> actualOptions = (new Select(opportunitiesDropdown)).getOptions();
		String[] expectedOptions = (FileUtils.getOpportunitiesTestData("opportunities.dropdown.options")).split(",");
		for (int i=0; i < actualOptions.size(); i++) {
			if (!actualOptions.get(i).getText().equals(expectedOptions[i])) {
				allOptionsVerified = false;
				break;
			}
		}
		return allOptionsVerified;
	}
	
	public void createNewOpp() throws IOException {
		opportunityName.sendKeys(FileUtils.getOpportunitiesTestData("new.opp.name"));
		accountName.sendKeys(FileUtils.getOpportunitiesTestData("new.opp.account.name"));
		(new Select(leadSource)).selectByValue(FileUtils.getOpportunitiesTestData("new.opp.leadsource"));
		currentDate.click();
		(new Select(stage)).selectByValue(FileUtils.getOpportunitiesTestData("new.opp.stage"));
		probability.clear();
		probability.sendKeys(FileUtils.getOpportunitiesTestData("new.opp.probability"));
		newOppSaveButton.click();
		
	}
	
	public boolean verifyNewOpp() throws IOException {
		boolean newOppCreated = false;
		if (newOppPage.getText().equals(FileUtils.getOpportunitiesTestData("opportunities.new")) &&
				newOppPageDescription.getText().equals(FileUtils.getOpportunitiesTestData("new.opp.name"))) {
			if (newOppName.getText().equals(FileUtils.getOpportunitiesTestData("new.opp.name")) &&
					newAccout.getText().equals(FileUtils.getOpportunitiesTestData("new.opp.account.name")) &&
					newLeadSource.getText().equals(FileUtils.getOpportunitiesTestData("new.opp.leadsource")) &&
					newCloseDate.getText().equals(CommonUtils.getCurrentDate()) &&
					newStage.getText().equals(FileUtils.getOpportunitiesTestData("new.opp.stage")) &&
					newProbability.getText().equals(FileUtils.getOpportunitiesTestData("new.opp.probability") + "%")) {
				newOppCreated = true;
			}
		}
		return newOppCreated;
	}
	
	public boolean selectOppPipeline() {
		boolean isReportDisplayed = false; 
		oppPipelineLink.click();
		if (oppPipelineReport.isDisplayed() && reportStatus.isDisplayed()) {
			isReportDisplayed = true;
		}
		return isReportDisplayed;
	}
	
	public boolean selectStuckOpp() {
		boolean isReportDisplayed = false; 
		stuckOppLink.click();
		if (stuckOppReport.isDisplayed() && reportStatus.isDisplayed()) {
			isReportDisplayed = true;
		}
		return isReportDisplayed;
	}
	
	public boolean selectQuarterlySummary() throws IOException {
		boolean isReportDisplayed = false; 
		Select dropdown;
		dropdown = new Select(quarterlySummaryInterval);
		dropdown.selectByVisibleText(FileUtils.getOpportunitiesTestData("quarterly.summary.interval"));
		dropdown = new Select(quarterlySummaryInclude);
		dropdown.selectByVisibleText(FileUtils.getOpportunitiesTestData("quarterly.summary.include"));
		runReportButton.click();
		if (quarterlySummReport.isDisplayed() && reportStatus.isDisplayed()) {
			isReportDisplayed = true;
		}
		return isReportDisplayed;
	}
}


