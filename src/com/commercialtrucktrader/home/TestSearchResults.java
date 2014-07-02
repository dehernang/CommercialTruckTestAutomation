package com.commercialtrucktrader.home;

import java.util.ArrayList;
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

public class TestSearchResults extends TCUtil{

	  public TestSearchResults(){
		  super();
	  }
	  
	  @Before
	  public void setUp() throws Exception {
		  driver = new FirefoxDriver();
		  baseUrl = "http://php5dev.commercialtrucktrader.com/";
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testSearchResults() throws Exception {

		  driver.get(baseUrl + "/");
		  
		  //System.out.println(TestSearchResults.class.getSimpleName());


		  for(Map.Entry<String,String[]> make : makes.entrySet()){

		      //String lMake = "WESTERN STAR";
		      //new Select(driver.findElement(By.id("alltype"))).selectByVisibleText("Light Duty (Class 1-3)");
		      //new Select(driver.findElement(By.id("typeLight"))).selectByVisibleText("Crew Cab");
		      new Select(driver.findElement(By.id("makesDrop"))).selectByVisibleText(make.getKey());
		
		      driver.findElement(By.cssSelector("img[alt=\"Find It\"]")).click();
		
		      Thread.sleep(1000);
		
		      for(String kw : make.getValue()){
		    	  element.clear();
		    	  element.put("^[\\s\\S]*[19|20]{2}[0-9]{2} (?i:.*"+kw+"*)[\\s\\S]*$","xpath");
		    	  this.doVerifyTextPresent(element, true, TestSearchResults.class.getSimpleName(), "//h3/a");
		      }
		      
		      element.clear();		    		      
		      for(Map.Entry<String,String[]> e : makes.entrySet()){	    	  
		    	  //skip itself
		    	  if(!e.getKey().equals(make.getKey())){ 	    		  
		    		  //loop keywords of the make
		    		  for(String kw : e.getValue()){
		    			  element.put("^[\\s\\S]*[19|20]{2}[0-9]{2} (?i:.*"+kw+"*)[\\s\\S]*$","xpath");
		    		  }		    		
		    	  }
		      }
		      this.doVerifyTextPresent(element, false, TestSearchResults.class.getSimpleName(), "//h3/a");
	
		      
		      Thread.sleep(1000);
		      driver.findElement(By.linkText("HOME")).click();
		      Thread.sleep(1000);
		      
		 }
		 
		  
		  
	  }
	
	  @After
	  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		    	fail(verificationErrorString);
		    }
	  }
	  

 
}