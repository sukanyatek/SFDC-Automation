package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDCListeners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		BaseTest.test = BaseTest.extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.test.pass(MarkupHelper.createLabel("PASSED "+result.getName(), ExtentColor.GREEN));
		//BaseTest.test.pass("PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		BaseTest.test.fail(MarkupHelper.createLabel("FAILED "+result.getName(), ExtentColor.RED));
		//BaseTest.test.fail("FAIL");
	}
}
