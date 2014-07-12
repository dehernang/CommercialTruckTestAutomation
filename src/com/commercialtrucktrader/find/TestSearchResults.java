package com.commercialtrucktrader.find;

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
import com.dominionenterprises.selenium.util.TestCaseHelper;

import java.util.Map;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestSearchResults extends TestCaseHelper{

		private Map<String,String[]> makes;
		private Boolean makeFound;
	  
		@Before
		public void setUp() throws Exception {
			Boolean good = super.init(TestSearchResults.class.getName());
			if(!good)
				throw new Exception();
		    makes = new HashMap<String,String[]>();	
			makes.put("CHEVROLET", new String[]{"CHEVROLET","Chevrolet"});
			makes.put("DODGE",new String[]{"DODGE"});
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
	  }

	  @Test
	  public void testSearchResults() throws Exception {

		  click("linkText","FIND");
		  for(Map.Entry<String,String[]> make : makes.entrySet()){

			  if(make.getKey() == "RAM"){
	
				  try{
					  select("id","makesDrop","RAM");
					  makeFound = true;
				  }catch(Exception e){
					  makeFound = false;
					  println(e.getMessage());
					  result(make.getKey(), TestSearchResults.class.getSimpleName(), false, "selectByVisibleText");
				  }
				  
				  if(makeFound){
					  
					  click("cssSelector","img[alt=\"Find It\"]");				
				      Thread.sleep(1000);				
				      for(String kw : make.getValue()){
				    	  element.clear();
				    	  element.put("^[\\s\\S]*[19|20]{2}[0-9]{2}(?i:.*"+kw+"*)[\\s\\S]*$","xpath");
				    	  doVerifyTextPresentList(element, "//h3/a");					      
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
				      doVerifyTextNotPresentList(element, "//h3/a");
				      
				      Thread.sleep(1000);
				      getDriver().findElement(By.linkText("HOME")).click();
				      Thread.sleep(1000);
			  
				  }
		  	}	  
		 }
		 
		  
	  }
	
	  @After
	  public void tearDown() throws Exception {
		  this.finalize();
		  String verificationErrorString = this.getVerificationErrors().toString();
		  if (!"".equals(verificationErrorString)) {
			  fail(verificationErrorString);
		  }
	  }
	  

 
}