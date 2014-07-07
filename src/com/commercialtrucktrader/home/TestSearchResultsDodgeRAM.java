package com.commercialtrucktrader.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import util.TCUtil;
import java.util.Map;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestSearchResultsDodgeRAM extends TCUtil{

		private Map<String,String[]> makes;
		private Map<String,String[]> notExistsKW;
		private Boolean makeFound;
		
		public TestSearchResultsDodgeRAM(){
			super();
			super.classname = TestSearchResultsDodgeRAM.class.getSimpleName();
		}
  
		@Before
		public void setUp() throws Exception {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(super.timeout, TimeUnit.SECONDS);
			  
		    makes = new HashMap<String,String[]>();	
			makes.put("DODGE",new String[]{"DODGE"});
			makes.put("RAM",new String[]{" RAM "});
			
			notExistsKW = new HashMap<String,String[]>();	
			notExistsKW.put("DODGE",new String[]{"RAM","DODGE/RAM"});
			notExistsKW.put("RAM",new String[]{"DODGE","DODGE/RAM"});
			
	  }

	  @Test
	  public void testSearchResults() throws Exception {

		  driver.get(baseUrl + "/");

		  for(Map.Entry<String,String[]> make : makes.entrySet()){

			  try{
				  new Select(driver.findElement(By.id("makesDrop"))).selectByVisibleText(make.getKey());
				  makeFound = true;
			  }catch(Exception e){
				  makeFound = false;
				  println(e.getMessage());
				  result(make.getKey(), TestSearchResultsDodgeRAM.class.getSimpleName(), false, "selectByVisibleText");
			  }
			  
			  if(makeFound){
			      driver.findElement(By.cssSelector("img[alt=\"Find It\"]")).click();
			
			      Thread.sleep(1000);
			
			      for(String kw : make.getValue()){
			    	  element.clear();
			    	  element.put("^[\\s\\S]*[19|20]{2}[0-9]{2}(?i:.*"+kw+"*)[\\s\\S]*$","xpath");
			    	  this.doVerifyTextPresent(element, true, TestSearchResultsDodgeRAM.class.getSimpleName(), "//h3/a");
			      }
			      
			      element.clear();		    		      
			      for(Map.Entry<String,String[]> e : makes.entrySet()){	    	  
			    	  //skip itself
			    	  if(!e.getKey().equals(make.getKey())){ 	    		  
			    		  //loop keywords of the make
			    		  for(String kw : e.getValue()){
			    			  element.put("^[\\s\\S]*[19|20]{2}[0-9]{2}(?i:.*"+kw+"*)[\\s\\S]*$","xpath");
			    		  }		    		
			    	  }
			      }
			      this.doVerifyTextPresent(element, false, TestSearchResultsDodgeRAM.class.getSimpleName(), "//h3/a");
		
			      
			      Thread.sleep(1000);
			      driver.findElement(By.linkText("HOME")).click();
			      Thread.sleep(1000);
		  
			  }
			  
		 }
		 
		  
	  }
	
	  @After
	  public void tearDown() throws Exception {
		  super.printTotalVerification(); 
		  driver.quit();
		  String verificationErrorString = verificationErrors.toString();
		  if (!"".equals(verificationErrorString)) {
			  fail(verificationErrorString);
		  }
	  }
	  

 
}