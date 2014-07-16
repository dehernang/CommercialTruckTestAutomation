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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import junit.framework.TestCase;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 11, 2014
 *
 */
public class TestCaseExt extends TestCase{

	private static WebDriver _driver;
	private String testCaseName;
	private boolean acceptNextAlert;
	private StringBuffer verificationErrors;
	private String baseUrl;
	private int timeout;
	private Dimension dimension;
	private Point point;
	
	private static final String TYPE_NOT_FOUND = "Type Not Found";
	private static final String ERROR = "Error";
	private static final String EXCEPTION = "Exception";
	private static final String THROWABLE = "Throwable";
	
	protected static final int PASS = 1;
	protected static final int FAIL = 0;
	protected static final int ERR1 = -1;
	protected static final int ERR2 = -2;

	/* 
	 * Constructor and Destructor
	 */
	
	public TestCaseExt() {
		this.setAcceptNextAlert(true);
		this.setVerificationErrors(new StringBuffer());
	}

	public void finalize(){
		if(_driver != null)
			_driver.quit();
	}

	/* 
	 * Getters
	 */
	
	public WebDriver getDriver() {
		return _driver;
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public boolean isAcceptNextAlert() {
		return acceptNextAlert;
	}
	
	public StringBuffer getVerificationErrors() {
		return verificationErrors;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public int getTimeout() {
		return timeout;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Point getPoint() {
		return point;
	}

	/*
	 * Setters
	 */
	
	public Boolean setDriver(WebDriver driver) {
		_driver = driver;
		return true;
	}
	
	public Boolean setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
		return true;
	}
	
	public Boolean setAcceptNextAlert(boolean acceptNextAlert) {
		this.acceptNextAlert = acceptNextAlert;
		return true;
	}	
	
	public Boolean setVerificationErrors(StringBuffer verificationErrors) {
		this.verificationErrors = verificationErrors;
		return true;
	}
	
	public Boolean setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
		try{
			_driver.get(this.baseUrl + "/");
		}catch(Throwable e){
			return false;  		  
		}
		return true;
	}
	
	public Boolean setTimeout(int timeout) {
		this.timeout = timeout;
		try{
			_driver.manage().timeouts().implicitlyWait(this.timeout, TimeUnit.SECONDS);
		}catch(Throwable e){
			return false;  		  
		}
		return true;
	}
	
	public Boolean setDimension(Dimension dimension) {
		this.dimension = dimension;
		try{
			_driver.manage().window().setSize(this.dimension);
		}catch(Throwable e){
			return false;  		  
		}
		return true;
	}

	public Boolean setPoint(Point point) {
		this.point = point;	
		try{
			_driver.manage().window().setPosition(this.point);
		}catch(Throwable e){
			return false;  		  
		}
		return true;
	}
	
	/* 
	 * Selenium Methods
	 */
	
	private boolean isElementPresent(By by) {
		 try{
			 _driver.findElement(by);
		     return true;
		 }catch (NoSuchElementException e){
			 return false;
		 }
	 }
	
	private boolean isAlertPresent() {
		try{
		    _driver.switchTo().alert();
		    return true;
		}catch(NoAlertPresentException e){
		    return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = _driver.switchTo().alert();
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
				assertTrue(_driver.findElement(By.cssSelector(cssSelectorStr)).getText().matches(textStr));
			else{
				assertFalse(_driver.findElement(By.cssSelector(cssSelectorStr)).getText().matches(textStr));	
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
				assertTrue(_driver.findElement(By.xpath(xpathStr)).getText().matches(textStr));			
			else{
				assertFalse(_driver.findElement(By.xpath(xpathStr)).getText().matches(textStr));	
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
			return PASS;
		return FAIL;
	}	
	
	protected int doVerifyTextPresent(Map.Entry<String, String> lnkEntry, String locationStr){
		String retval = null;
	    retval = this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), true, locationStr);  
		if(retval == null)
			return PASS;
		return FAIL;
	}
	
	protected int doVerifyElementNotPresent(Map.Entry<String, String> lnkEntry){   
		String retval = null;
	    retval = this.verifyElementPresent(lnkEntry.getKey(),lnkEntry.getValue(), false); 
		if(retval == null)
			return PASS;
		return FAIL;
	}	
	
	protected int doVerifyTextNotPresent(Map.Entry<String, String> lnkEntry, String locationStr){
		String retval = null;
	    retval = this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), false, locationStr);    
		if(retval == null)
			return PASS;
		return FAIL;
	}	


	protected int click(String type, String target){
		try{	
			switch(type){		
				case "linkText":
					_driver.findElement(By.linkText(target)).click();
					break;			
				case "cssSelector":
					_driver.findElement(By.cssSelector(target)).click();
					break;	
				case "id":
					_driver.findElement(By.id(target)).click();
					break;
				default:
					return ERR2;			
			}
		}catch(Exception e){
			return ERR1; 
		}catch(Error e){	
			return ERR1; 
		}catch(Throwable e){
			return ERR1;  		  
		}
		return PASS;
	}

	protected int select(String type, String id, String target){
		try{
			switch(type){		
				case "id":
					new Select(_driver.findElement(By.id(id))).selectByVisibleText(target);
					break;				
				default:
					return ERR2;			
			}
		}catch(Exception e){
			return ERR1; 
		}catch(Error e){	
			return ERR1; 
		}catch(Throwable e){
			return ERR1;  		  
		}
		return PASS;
	}
	
	protected int input(String type, String id, String text){
		try{
			switch(type){		
				case "id":
					_driver.findElement(By.id(id)).clear();
					_driver.findElement(By.id(id)).sendKeys(text);
					break;				
				default:
					return ERR2;			
			}
		}catch(Exception e){
			return ERR1; 
		}catch(Error e){	
			return ERR1; 
		}catch(Throwable e){
			return ERR1;  		  
		}
		return PASS;
	}

	protected int moveToElement(String type, String target){
		Actions actions = new Actions(_driver);
		WebElement el;
		try{
			switch(type){		
				case "id":
					el = _driver.findElement(By.id(target));
					actions.moveToElement(el).perform();
					break;	
				case "linkText":
					el = _driver.findElement(By.linkText(target));
					actions.moveToElement(el).perform();
					break;
				case "cssSelector":
					el = _driver.findElement(By.cssSelector(target));
					actions.moveToElement(el).perform();
					break;	
				case "xpath":
					el = _driver.findElement(By.xpath(target));
					actions.moveToElement(el).perform();
					break;		
				default:
					return ERR2;			
			}
		}catch(Exception e){
			return ERR1; 
		}catch(Error e){	
			return ERR1; 
		}catch(Throwable e){
			return ERR1;  		  
		}
		return PASS;		  
	}
	
	protected String getValue(String type, String target){
		String val = null;
		try{	
			switch(type){		
				case "xpath":
					WebElement tmp = _driver.findElement(By.xpath(target));
					val = tmp.getText();
					break;			
				default:
					return "error";			
			}
		}catch(Exception e){
			return "error";	
		}catch(Error e){	
			return "error";	
		}catch(Throwable e){
			return "error";			  
		}
		return val;
	}
	
}
