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
	//protected Map<String,String[]> makes;
	protected String testing;
	
	public TCUtil() {
		
		//driver = new FirefoxDriver();		
		element = new HashMap<String, String>();		
		/*
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
		
		String method = null;
	    try {    		    	
	    	switch(type){
	    		case "linkText":
	    			method = "verifyElementPresentBytLinkText";
	    			this.verifyElementPresentBytLinkText(target, verExist, testcaseName);
	    			break;
	    		case "id":
	    			method = "verifyElementPresentById";
	    			this.verifyElementPresentById(target, verExist, testcaseName);
	    			break;
	    		case "xpath":
	    			method = "verifyElementPresentByXpath";
	    			this.verifyElementPresentByXpath(target, verExist, testcaseName);
	    			break;
	    		case "cssSelector":
	    			method = "verifyElementPresentByCssSelector";
	    			this.verifyElementPresentByCssSelector(target, verExist, testcaseName);
	    			break;
	    		default:
	    			System.out.println(testcaseName+" Error - verifyElementPresent 'Type' param not found");
	    			break;	    	
	    	}	
	    

	     }catch(Error e){
	    	 if(!verExist)
	    		 method = "!"+method;    	 
	    	 result(target, testcaseName, false, method);
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
	
		String method = null;
		try {    		    	
			switch(type){
	    		case "cssSelector":
	    			method = "verifyTextPresentByCssSelector";
	    			this.verifyTextPresentByCssSelector(target, verExist, testcaseName);
	    			break;
	    		case "xpath":
	    			method = "verifyTextPresentByXpath";
	    			this.verifyTextPresentByXpath(xpath, target, verExist, testcaseName);    			
	    			break;
	    		default:
	    			System.out.println(testcaseName+" Error - verifyTextPresent 'Type' param not found");
	    			break;	    	
	    	}	
	    	

	     }catch(Error e){  
	    	 if(!verExist)
	    		 method = "!"+method; 
	    	 if(xpath != null)
	    		 result(target, testcaseName, false, method, xpath);
	    	 else
	    		 result(target, testcaseName, false, method);
	         
	     }
	     

	}
	
	/**
	 * 
	 * @param str String id name
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param testcaseName String test case name
	 */
	protected void verifyElementPresentById(String str, Boolean verExist, String testcaseName){
		
		String msg = "verifyElementPresentById";
		try{		
			if(verExist)
				assertTrue(isElementPresent(By.id(str)));
			else{
				msg = "!"+msg;
				assertFalse(isElementPresent(By.id(str)));	
			}
			result(str, testcaseName, true, msg); 
		}catch(Exception e){
			result(str, testcaseName, false, msg); 
			println(e.getMessage());  		  
		}
	
	}
	
	/**
	 * 
	 * @param str String link text name
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param testcaseName String test case name
	 */
	protected void verifyElementPresentBytLinkText(String str, Boolean verExist, String testcaseName){
		
		String msg = "verifyElementPresentBytLinkText";
		try{	
			if(verExist)
				assertTrue(isElementPresent(By.linkText(str)));
			else{
				msg = "!"+msg;
				assertFalse(isElementPresent(By.linkText(str)));
			}
			result(str, testcaseName, true, msg); 
		}catch(Exception e){
			result(str, testcaseName, false, msg); 
			println(e.getMessage());  		  
		}
	
	}
	
	/**
	 * 
	 * @param str String XPath regular expression string
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param testcaseName String test case name
	 */
	protected void verifyElementPresentByXpath(String str, Boolean verExist, String testcaseName){
		
		String msg = "verifyElementPresentByXpath";
		try{		
			if(verExist)
				assertTrue(isElementPresent(By.xpath(str)));
			else{
				msg = "!"+msg;
				assertFalse(isElementPresent(By.xpath(str)));	
			}
			result(str, testcaseName, true, msg); 
		}catch(Exception e){
			result(str, testcaseName, false, msg); 
			println(e.getMessage());  		  
		}
	
	}
	
	/**
	 * 
	 * @param str String CSS label
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param testcaseName String test case name
	 */
	protected void verifyElementPresentByCssSelector(String str, Boolean verExist, String testcaseName){
		
		String msg = "verifyElementPresentByCssSelector";
		try{		
			if(verExist)	
				assertTrue(isElementPresent(By.cssSelector(str)));
			else{
				msg = "!"+msg;
				assertFalse(isElementPresent(By.cssSelector(str)));	
			}
			result(str, testcaseName, true, msg); 
		}catch(Exception e){
			result(str, testcaseName, false, msg); 
			println(e.getMessage());  		  
		}
	
	}
	
	/**
	 * 
	 * @param str String CSS label
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param testcaseName String test case name
	 */
	protected void verifyTextPresentByCssSelector(String str, Boolean verExist, String testcaseName){
		
		String msg = "verifyTextPresentByCssSelector";
		try{		
			if(verExist)
				assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches(str));
			else{
				msg = "!"+msg;
				assertFalse(driver.findElement(By.cssSelector("BODY")).getText().matches(str));	
			}
			result(str, testcaseName, true, msg); 
		}catch(Exception e){
			result(str, testcaseName, false, msg); 
			println(e.getMessage());  		  
		}
	
	}	

	/**
	 * 
	 * @param str String xpath
	 * @param str2 String regex
	 * @param verExist Boolean true for assertTrue, false for assertFalse
	 * @param testcaseName String test case name
	 */
	protected void verifyTextPresentByXpath(String str, String str2, Boolean verExist, String testcaseName){

		String msg = "verifyTextPresentByXpath";
		try{	
			if(verExist)
				assertTrue(driver.findElement(By.xpath(str)).getText().matches(str2));			
			else{
				msg = "!"+msg;
				assertFalse(driver.findElement(By.xpath(str)).getText().matches(str2));	
			}
			result(str2, testcaseName, true, msg, str); 
		}catch(Exception e){
			result(str2, testcaseName, false, msg, str); 
			println(e.getMessage());  		  
		}
				
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
	
	
	public void result(String target, String tcName, Boolean pass, String method){
		
		String status = "Passed";
		if(!pass)
			status = "<<<Failed>>>";
	
		println(tcName+" "+status+" - "+method+" [" + target + "]");
	}
	
	public void result(String target, String tcName, Boolean pass, String method, String xpath){
		
		String status = "Passed";
		if(!pass)
			status = "<<<Failed>>>";
	
		println(tcName+" "+status+" - "+method+" [" + target + "] xpath["+xpath+"]");
	}
	
	public void println(String msg){
		System.out.println(msg);
	}

    
	
}
