package util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class TCUtil extends TestCase{

	protected Iterator<String> iterator;
	protected String lnkName;
	protected String msg;
	protected Map<String, String> element;
	protected WebDriver driver;
	protected boolean acceptNextAlert = true;
	protected StringBuffer verificationErrors = new StringBuffer();
	protected String baseUrl;
	protected Map<String,String[]> makes;
	protected String testing;
	
	public TCUtil() {
		
		//driver = new FirefoxDriver();
		
		element = new HashMap<String, String>();		
		makes = new HashMap<String,String[]>();	

		makes.put("CHEVROLET", new String[]{"CHEVROLET","Chevrolet"});

		makes.put("FORD",new String[]{"FORD"});

		makes.put("FREIGHTLINER",new String[]{"FREIGHTLINER"});

		makes.put("GMC",new String[]{"GMC"});

		makes.put("HINO",new String[]{"HINO"});

		makes.put("INTERNATIONAL",new String[]{"INTERNATIONAL"});

		makes.put("ISUZU",new String[]{"ISUZU"});
	
		makes.put("KENWORTH",new String[]{"KENWORTH"});

		makes.put("MACK",new String[]{"MACK"});

		makes.put("MERCEDES-BENZ",new String[]{"MERCEDES-BENZ"});

		makes.put("MITSUBISHI-FUSO",new String[]{"MITSUBISHI FUSO"});

		makes.put("NISSAN",new String[]{"NISSAN"});

		makes.put("PETERBILT",new String[]{"PETERBILT"});

		makes.put("RAM",new String[]{"RAM"});

		makes.put("STERLING",new String[]{"STERLING"});

		makes.put("VOLVO",new String[]{"VOLVO"});

		makes.put("WESTERN STAR",new String[]{"WESTERN STAR"});

		 
		/*
		OutputStream output = null;
		Properties prop = new Properties();
		try {
			 
			output = new FileOutputStream("config.properties");
	 
			// set the properties value
			//prop.setProperty("database", "localhost");
			//prop.setProperty("dbuser", "mkyong");
			//prop.setProperty("dbpassword", "password");
	 
			// save properties to project root folder
			//prop.store(output, null);
			
			prop.getProperty(key)
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
		*/
	}
	
	/**
	 * 
	 * @param link Map list of element and type
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void doVerifyElementPresent(Map<String,String> link, Boolean verExist, String testcaseName){
	    Set<Map.Entry<String, String>> set = link.entrySet();
	    
	    for(Map.Entry<String, String> lnkEntry : set){
	    	this.verifyElementPresent(lnkEntry.getKey(),lnkEntry.getValue(), verExist, testcaseName);    	
	    }
	}
	
	/**
	 * 
	 * @param link Map list of element and type
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param xpath String
	 */
	protected void doVerifyTextPresent(Map<String,String> link, Boolean verExist, String testcaseName, String xpath){
	    Set<Map.Entry<String, String>> set = link.entrySet();
	    
	    for(Map.Entry<String, String> lnkEntry : set){
	    	this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), verExist, testcaseName, xpath);    	
	    }
	}
	
	/**
	 * 
	 * @param target String element name to be searched
	 * @param type String type of element id, linkText, etc
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void verifyElementPresent(String target, String type, Boolean verExist, String testcaseName){
		
		String not = "";
		if(!verExist)
			not = "!";

	    try {    		    	
	    	switch(type){
	    		case "linkText":
	    			this.verifyElementPresentBytLinkText(target, verExist);
	    			System.out.println(testcaseName+" Passed - "+not+"verifyElementPresentBytLinkText[" + target + "]");
	    			break;
	    		case "id":
	    			this.verifyElementPresentById(target, verExist);
	    			System.out.println(testcaseName+" Passed - "+not+"verifyElementPresentById[" + target + "]");
	    			break;
	    		case "xpath":
	    			this.verifyElementPresentByXpath(target, verExist);
	    			System.out.println(testcaseName+" Passed - "+not+"verifyElementPresentByXpath[" + target + "]");
	    			break;
	    		case "cssSelector":
	    			this.verifyElementPresentByCssSelector(target, verExist);
	    			System.out.println(testcaseName+" Passed - "+not+"verifyElementPresentByCssSelector[" + target + "]");
	    			break;
	    		default:
	    			System.out.println(testcaseName+" Error - "+not+"verifyElementPresent 'Type' param not found");
	    			break;	    	
	    	}	
	    	
	     } catch (Error e) {
	    	 
	    	 if(verExist)
	    		 System.out.println(testcaseName+" <<<Failed!>>> - Not found element["+target+"] type["+type+"]");
	    	 else
	    		 System.out.println(testcaseName+" <<<Failed!>>> - Not expecting element["+target+"] type["+type+"]");
	    	 verificationErrors.append(e.toString());
	     }

	}
	
	/**
	 * 
	 * @param target String element name to be searched
	 * @param type String type of element id, linkText, etc
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param xpath String
	 */
	protected void verifyTextPresent(String target, String type, Boolean verExist, String testcaseName, String xpath){

		String not = "";
		if(!verExist)
			not = "!";
		
	    try {    		    	
	    	switch(type){
	    		case "cssSelector":
	    			this.verifyTextPresentByCssSelector(target, verExist);
	    			System.out.println(testcaseName+" Passed - "+not+"verifyTextPresentByCssSelector[" + target + "]");
	    			break;
	    		case "xpath":
	    			this.verifyTextPresentByXpath(xpath, target, verExist);
	    			System.out.println(testcaseName+" Passed - "+not+"verifyTextPresentByXpath[" + target + "]");
	    			break;
	    		default:
	    			System.out.println(testcaseName+" Error - verifyTextPresent 'Type' param not found");
	    			break;	    	
	    	}	
	    	
	     } catch (Error e) {
	    	 
	    	 if(verExist)
	    		 System.out.println(testcaseName+" <<<Failed!>>> - Not found text["+target+"] type["+type+"]");
	    	 else
	    		 System.out.println(testcaseName+" <<<Failed!>>> - Not expecting text["+target+"] type["+type+"]");
	        verificationErrors.append(e.toString());
	     }

	}
	
	/**
	 * 
	 * @param str String id name
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void verifyElementPresentById(String str, Boolean verExist){
		if(verExist)
			assertTrue(isElementPresent(By.id(str)));
		else
			assertFalse(isElementPresent(By.id(str)));
	}
	
	/**
	 * 
	 * @param str String link text name
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void verifyElementPresentBytLinkText(String str, Boolean verExist){
		if(verExist)
			assertTrue(isElementPresent(By.linkText(str)));
		else
			assertFalse(isElementPresent(By.linkText(str)));
	}
	
	/**
	 * 
	 * @param str String XPath regular expression string
	 */
	protected void verifyElementPresentByXpath(String str, Boolean verExist){
		if(verExist)
			assertTrue(isElementPresent(By.xpath(str)));
		else
			assertFalse(isElementPresent(By.xpath(str)));
	}
	
	/**
	 * 
	 * @param str String CSS label
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void verifyElementPresentByCssSelector(String str, Boolean verExist){
		if(verExist)	
			assertTrue(isElementPresent(By.cssSelector(str)));
		else
			assertFalse(isElementPresent(By.cssSelector(str)));
	}
	
	/**
	 * 
	 * @param str String CSS label
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void verifyTextPresentByCssSelector(String str, Boolean verExist){
		if(verExist)
			assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches(str));
		else
			assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches(str));
	}	

	/**
	 * 
	 * @param str String Xpath String
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 */
	protected void verifyTextPresentByXpath(String xp, String str, Boolean verExist){
		if(verExist)
			assertTrue(driver.findElement(By.xpath(xp)).getText().matches(str));
		else
			assertFalse(driver.findElement(By.xpath(xp)).getText().matches(str));
	}	
	
	/**
	 * 
	 * @param by org.openqa.selenium.By type
	 * @return boolean
	 */
	protected boolean isElementPresent(By by) {
		  try {
			  driver.findElement(by);
		      return true;
		  } catch (NoSuchElementException e) {
		      return false;
		  }
	 }
	
	protected boolean isAlertPresent() {
		try {
		      driver.switchTo().alert();
		      return true;
		 } catch (NoAlertPresentException e) {
		      return false;
		 }
	}

	protected String closeAlertAndGetItsText() {
		try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		} finally {
		      acceptNextAlert = true;
		}
	}	
	

    
	
}
