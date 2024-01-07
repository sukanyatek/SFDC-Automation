package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {
	
	/**This method reads the login test data properties file 
	 * @param key
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String getLoginTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FileConstants.LOGIN_TESTDATA_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
	
	/**This method reads the user menu test data properties file 
	 * @param key
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String getUserMenuTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FileConstants.USERMENU_TESTDATA_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
	
	/**This method reads the accounts test data properties file 
	 * @param key
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String getAccountsTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FileConstants.ACCOUNTS_TESTDATA_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
	
	/**This method reads the opportunities test data properties file 
	 * @param key
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String getOpportunitiesTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FileConstants.OPPORTUNITIES_TESTDATA_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
	
	/**This method reads the leads test data properties file 
	 * @param key
	 * @return value of the key passed
	 * @throws IOException
	 */
	public static String getLeadsTestData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FileConstants.LEADS_TESTDATA_FILEPATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}


}
