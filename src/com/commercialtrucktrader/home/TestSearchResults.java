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
public class TestSearchResults extends TCUtil{

		private Map<String,String[]> makes;
		private Boolean makeFound;
		
		public TestSearchResults(){
			super(TestSearchResults.class.getName());
		}
  
		@Before
		public void setUp() throws Exception {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(super.timeout, TimeUnit.SECONDS);
			  
		    makes = new HashMap<String,String[]>();	
			makes.put("CHEVROLET", new String[]{"CHEVROLET","Chevrolet"});
			//makes.put("DODGE",new String[]{"DODGE"}); //moved to a special test case
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
			//makes.put("RAM",new String[]{" RAM "}); //moved to a special test case
			makes.put("STERLING",new String[]{"STERLING"});
			makes.put("VOLVO",new String[]{"VOLVO"});
			makes.put("WESTERN STAR",new String[]{"WESTERN STAR"});
			
			
	  }

	  @Test
	  public void testSearchResults() throws Exception {

		  driver.get(baseUrl + "/");

		  for(Map.Entry<String,String[]> make : makes.entrySet()){

			  try{
				  new Select(driver.findElement(By.id("makesDrop"))).selectByVisibleText(make.getKey());
				  makeFound = true;
				  super.counter++;
				  super.counterPass++;
			  }catch(Exception e){
				  super.counterFail++;
				  makeFound = false;
				  println(e.getMessage());
				  result(make.getKey(), TestSearchResults.class.getSimpleName(), false, "selectByVisibleText");
			  }
			  
			  if(makeFound){
			      driver.findElement(By.cssSelector("img[alt=\"Find It\"]")).click();
			
			      Thread.sleep(1000);
			
			      for(String kw : make.getValue()){
			    	  element.clear();
			    	  element.put("^[\\s\\S]*[19|20]{2}[0-9]{2}(?i:.*"+kw+"*)[\\s\\S]*$","xpath");
			    	  this.doVerifyTextPresent(element, "//h3/a");
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
			      this.doVerifyTextNotPresent(element, "//h3/a");
		
			      
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