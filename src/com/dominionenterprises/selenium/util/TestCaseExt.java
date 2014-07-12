/**
 * 
 */
package com.dominionenterprises.selenium.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.TestCase;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 11, 2014
 *
 */
public class TestCaseExt extends TestCase{

	private WebDriver driver;
	private String testCaseName;
	private boolean acceptNextAlert;
	private StringBuffer verificationErrors;
	private String baseUrl;
	private int timeout;
	
	private static final String TYPE_NOT_FOUND = "Type Not Found";
	private static final String ERROR = "Error";
	private static final String EXCEPTION = "Exception";
	private static final String THROWABLE = "Throwable";

	/* 
	 * Constructor and Destructor
	 */
	
	public TestCaseExt() {
		this.setAcceptNextAlert(true);
		this.setVerificationErrors(new StringBuffer());
	}

	public void finalize(){
		if(this.driver != null)
			this.driver.quit();
	}


	/* 
	 * Getters and Setters
	 */
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	
	public boolean isAcceptNextAlert() {
		return acceptNextAlert;
	}

	public void setAcceptNextAlert(boolean acceptNextAlert) {
		this.acceptNextAlert = acceptNextAlert;
	}	
	
	public StringBuffer getVerificationErrors() {
		return verificationErrors;
	}

	public void setVerificationErrors(StringBuffer verificationErrors) {
		this.verificationErrors = verificationErrors;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
		this.driver.get(this.baseUrl + "/");
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
		this.driver.manage().timeouts().implicitlyWait(this.timeout, TimeUnit.SECONDS);
	}

	
	/* 
	 * Selenium Methods
	 */
	
	private boolean isElementPresent(By by) {
		 try{
			 this.driver.findElement(by);
		     return true;
		 }catch (NoSuchElementException e){
			 return false;
		 }
	 }
	
	private boolean isAlertPresent() {
		try{
		    this.driver.switchTo().alert();
		    return true;
		}catch(NoAlertPresentException e){
		    return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
		    if(acceptNextAlert){
		    	alert.accept();
		    }else{
		        alert.dismiss();
		    }
		    return alertText;
		}finally{
		    acceptNextAlert = true;
		}
	}	
	
	/* 
	 * Extensions
	 */
	
	private String verifyElementPresentById(String idStr, Boolean verifyExist){
		try{		
			if(verifyExist)
				assertTrue(isElementPresent(By.id(idStr)));
			else{
				assertFalse(isElementPresent(By.id(idStr)));	
			}
		}catch(Exception e){
			return EXCEPTION; 
		}catch(Error e){	
			return ERROR; 
		}catch(Throwable e){
			return THROWABLE;  		  
		}
		return null;
	}
	
	private String verifyElementPresentBytLinkText(String linkTextStr, Boolean verifyExist){
		try{	
			if(verifyExist){
				assertTrue(isElementPresent(By.linkText(linkTextStr)));
			}else{
				assertFalse(isElementPresent(By.linkText(linkTextStr)));
			}			
		}catch(Exception e){
			return EXCEPTION; 
		}catch(Error e){	
			return ERROR; 
		}catch(Throwable e){
			return THROWABLE;  		  
		}
		return null;
	}
	
	private String verifyElementPresentByXpath(String xpathStr, Boolean verifyExist){
		try{		
			if(verifyExist)
				assertTrue(isElementPresent(By.xpath(xpathStr)));
			else{
				assertFalse(isElementPresent(By.xpath(xpathStr)));	
			}
		}catch(Exception e){
			return EXCEPTION; 
		}catch(Error e){	
			return ERROR; 
		}catch(Throwable e){
			return THROWABLE;  		  
		}
		return null;
	}
	
	private String verifyElementPresentByCssSelector(String cssSelectorStr, Boolean verifyExist){
		try{		
			if(verifyExist)	
				assertTrue(isElementPresent(By.cssSelector(cssSelectorStr)));
			else{
				assertFalse(isElementPresent(By.cssSelector(cssSelectorStr)));	
			}
		}catch(Exception e){
			return EXCEPTION; 
		}catch(Error e){	
			return ERROR; 
		}catch(Throwable e){
			return THROWABLE;  		  
		}
		return null;
	}
	
	private String verifyTextPresentByCssSelector(String cssSelectorStr, String textStr, Boolean verifyExist){
		try{		
			if(verifyExist)
				assertTrue(this.driver.findElement(By.cssSelector(cssSelectorStr)).getText().matches(textStr));
			else{
				assertFalse(this.driver.findElement(By.cssSelector(cssSelectorStr)).getText().matches(textStr));	
			}
		}catch(Exception e){
			return EXCEPTION; 
		}catch(Error e){	
			return ERROR; 
		}catch(Throwable e){
			return THROWABLE;  		  
		}
		return null;
	}	

	private String verifyTextPresentByXpath(String xpathStr, String textStr, Boolean verifyExist){
		try{	
			if(verifyExist)
				assertTrue(this.driver.findElement(By.xpath(xpathStr)).getText().matches(textStr));			
			else{
				assertFalse(this.driver.findElement(By.xpath(xpathStr)).getText().matches(textStr));	
			}
		}catch(Exception e){
			return EXCEPTION; 
		}catch(Error e){	
			return ERROR; 
		}catch(Throwable e){
			return THROWABLE;  		  
		}
		return null;
	}	

	/* 
	 * Controllers
	 */
	
	private String verifyElementPresent(String targetStr, String type, Boolean verifyExist){  		    	
	    switch(type){
	    	case "linkText":
	    		return this.verifyElementPresentBytLinkText(targetStr, verifyExist);
	    	case "id":
	    		return this.verifyElementPresentById(targetStr, verifyExist);
	    	case "xpath":
	    		return this.verifyElementPresentByXpath(targetStr, verifyExist);
	    	case "cssSelector":
	    		return this.verifyElementPresentByCssSelector(targetStr, verifyExist);
	    	default:
	    		return TYPE_NOT_FOUND; 	
	    }
	}
	
	private String verifyTextPresent(String targetStr, String type, Boolean verifyExist, String locationStr){		    	
		switch(type){
	    	case "cssSelector":
	    		return this.verifyTextPresentByCssSelector(locationStr, targetStr, verifyExist);
	    	case "xpath":   		
	    		return this.verifyTextPresentByXpath(locationStr, targetStr, verifyExist);    			
	    	default:
	    		return TYPE_NOT_FOUND; 	
		}
	}
	
	/* 
	 * Wrappers
	 */
	
	protected int doVerifyElementPresent(Map.Entry<String, String> lnkEntry){
		String retval = null;
		retval = this.verifyElementPresent(lnkEntry.getKey(),lnkEntry.getValue(), true); 
		if(retval == null)
			return 0;
		return 1;
	}	
	
	protected int doVerifyTextPresent(Map.Entry<String, String> lnkEntry, String locationStr){
		String retval = null;
	    retval = this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), true, locationStr);  
		if(retval == null)
			return 0;
		return 1;
	}
	
	protected int doVerifyElementNotPresent(Map.Entry<String, String> lnkEntry){   
		String retval = null;
	    retval = this.verifyElementPresent(lnkEntry.getKey(),lnkEntry.getValue(), false); 
		if(retval == null)
			return 0;
		return 1;
	}	
	
	protected int doVerifyTextNotPresent(Map.Entry<String, String> lnkEntry, String locationStr){
		String retval = null;
	    retval = this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), false, locationStr);    
		if(retval == null)
			return 0;
		return 1;
	}	


	protected int click(String type, String target){
		try{	
			switch(type){		
				case "linkText":
					this.driver.findElement(By.linkText(target)).click();
					break;			
				case "cssSelector":
					this.driver.findElement(By.cssSelector(target)).click();
					break;			
				default:
					return 2;			
			}
		}catch(Exception e){
			return 1; 
		}catch(Error e){	
			return 1; 
		}catch(Throwable e){
			return 1;  		  
		}
		return 0;
	}

	protected int select(String type, String id, String target){
		try{
			switch(type){		
				case "id":
					new Select(this.driver.findElement(By.id(id))).selectByVisibleText(target);
					break;				
				default:
					return 2;	
			}
		}catch(Exception e){
			return 1; 
		}catch(Error e){	
			return 1; 
		}catch(Throwable e){
			return 1;  		  
		}
		return 0;
	}
	

}
