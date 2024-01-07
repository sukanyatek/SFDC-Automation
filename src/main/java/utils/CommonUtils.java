package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.WaitConstants;

public class CommonUtils {
	
	/** Waits for the webelement to be loaded and to become clickable
	 * @param driver 
	 * @param element
	 * @return true if the element becomes clickable, false otherwise 
	 */
	public static boolean waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT);
		boolean isElementClickable = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}

	
	/**Waits for the webelement to disappear
	 * @param driver
	 * @param element
	 * @return true if element disappears, else false
	 */
	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		boolean isElementInvisible = false;
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementInvisible = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isElementInvisible;
	}
	
	/**Waits for new window to appear 
	 * @param driver
	 * @param noOfWindows 
	 * @return true if new window is loaded, else false
	 */
	public static boolean waitForWindowToAppear(WebDriver driver, int noOfWindows) {
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_WINDOW);
		boolean isWindowVisible = false;
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindows));
			isWindowVisible = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isWindowVisible;
	}
	
	
	/**Mousehover to an element
	 * @param driver
	 * @param element 
	 */
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	
	public static String getScreenshot(WebDriver driver) {
		String filePath = FileConstants.SCREENSHOTS_FOLDER_FILEPATH;
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		src.renameTo(dest);
		return filePath;
 	}
	
	public static String getDateAndTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	public static String getCurrentDate() {
		return new SimpleDateFormat("M/d/yyyy").format(new Date());
	}
}
