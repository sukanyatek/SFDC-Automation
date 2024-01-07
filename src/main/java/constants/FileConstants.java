package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String LOGIN_TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/loginTestData.properties";
	public static final String USERMENU_TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/userMenuTestData.properties";
	public static final String ACCOUNTS_TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/accountsTestData.properties";
	public static final String OPPORTUNITIES_TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/opportunitiesTestData.properties";
	public static final String LEADS_TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/main/resources/leadsTestData.properties";
	public static final String FILE_UPLOAD_FILEPATH = "/Users/suki/Desktop/Dropdown selection.png";
	public static final String SCREENSHOTS_FOLDER_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/screenshots/"+CommonUtils.getDateAndTimeStamp()+".PNG";
	public static final String REPORTS_FOLDER_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/reports/SFDC_"+CommonUtils.getDateAndTimeStamp()+".html";
	

}
