/**
 * 
 */
package com.dominionenterprises.selenium.util;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.dominionenterprises.selenium.util.TCUtil;


/**
 * @author hernan
 * @version 1.0
 * @since Jul 10, 2014
 *
 */
public class TC extends TCUtil{

	/**
	 * 
	 * @param link
	 */
	protected void doVerifyElementPresent(Map<String,String> link){   
	    for(Map.Entry<String, String> lnkEntry : link.entrySet()){
	    	this.verifyElementPresent(lnkEntry.getKey(),lnkEntry.getValue(), true, this.getTcName()); 
	    	counter++;
	    }
	}	
	
	/**
	 * 
	 * @param link
	 * @param xpath
	 */
	protected void doVerifyTextPresent(Map<String,String> link, String xpath){
	    for(Map.Entry<String, String> lnkEntry : link.entrySet()){
	    	this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), true, this.getTcName(), xpath);    
	    	counter++;
	    }
	}
	
	/**
	 * 
	 * @param link
	 */
	protected void doVerifyElementNotPresent(Map<String,String> link){   
	    for(Map.Entry<String, String> lnkEntry : link.entrySet()){
	    	this.verifyElementPresent(lnkEntry.getKey(),lnkEntry.getValue(), false, this.getTcName()); 
	    	counter++;
	    }
	}	
	
	/**
	 * 
	 * @param link
	 * @param xpath
	 */
	protected void doVerifyTextNotPresent(Map<String,String> link, String xpath){
	    for(Map.Entry<String, String> lnkEntry : link.entrySet()){
	    	this.verifyTextPresent(lnkEntry.getKey(),lnkEntry.getValue(), false, this.getTcName(), xpath);    
	    	counter++;
	    }
	}	

	/**
	 * 
	 * @param type
	 * @param target
	 */
	protected void click(String type, String target){
		switch(type){
		
			case "linkText":
				driver.findElement(By.linkText(target)).click();
				break;
			
			case "cssSelector":
				driver.findElement(By.cssSelector(target)).click();
				break;
				
			default:
    			System.out.println(this.getTcName()+" Error - click [" + type + "] not found");
    			break;	
    			
		}
	}

	/**
	 * 
	 * @param type
	 * @param target
	 */
	protected void select(String type, String id, String target){
		switch(type){
		
			case "id":
				new Select(driver.findElement(By.id(id))).selectByVisibleText(target);
				break;
				
			default:
    			System.out.println(this.getTcName()+" Error - select [" + type + "] not found");
    			break;	
    			
		}
	}
	
	

}
