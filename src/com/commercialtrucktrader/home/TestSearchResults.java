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

import com.commercialtrucktrader.find.TestAdLinksLandingPage;
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
		private ArrayList<String> xpaths;

		@Before
		public void setUp() throws Exception {
			Boolean good = super.init(TestSearchResults.class.getName());
			if(!good)
				throw new Exception();
		    makes = new HashMap<String,String[]>();	
		    makes.put("CHEVROLET", new String[]{"CHEVROLET"});
			makes.put("DODGE",new String[]{"DODGE"});
			makes.put("FORD",new String[]{"FORD"});
			makes.put("FREIGHTLINER",new String[]{"FREIGHTLINER"});
			makes.put("GMC",new String[]{"GMC"});
			makes.put("HINO",new String[]{"HINO"});
			makes.put("INTERNATIONAL",new String[]{"INTERNATIONAL"});
			makes.put("ISUZU",new String[]{"ISUZU"});	
			makes.put("KENWORTH",new String[]{"KENWORTH"});
			makes.put("MACK",new String[]{"MACK"});
			makes.put("MERCEDES-BENZ",new String[]{"MERCEDES","BENZ"});
			makes.put("MITSUBISHI-FUSO",new String[]{"MITSUBISHI"});
			makes.put("NISSAN",new String[]{"NISSAN"});
			makes.put("PETERBILT",new String[]{"PETERBILT"});
			makes.put("RAM",new String[]{" RAM "});
			makes.put("STERLING",new String[]{"STERLING"});
			makes.put("VOLVO",new String[]{"VOLVO"});
			makes.put("WESTERN STAR",new String[]{"W*STAR"});
			   
			xpaths = new ArrayList<String>();
			xpaths.add("//h3/a");
			xpaths.add("//div[4]/div/h3/a");
			xpaths.add("//div[5]/div/h3/a");
			xpaths.add("//div[7]/div/h3/a");
			xpaths.add("//div[8]/div/h3/a");
			xpaths.add("//div[9]/div/h3/a");
			xpaths.add("//div[10]/div/h3/a");
			xpaths.add("//div[11]/div/h3/a");
			xpaths.add("//div[12]/div/h3/a");
			xpaths.add("//div[13]/div/h3/a");
			xpaths.add("//div[14]/div/h3/a");
			xpaths.add("//div[15]/div/h3/a");
			xpaths.add("//div[17]/div/h3/a");
			xpaths.add("//div[18]/div/h3/a");
			xpaths.add("//div[19]/div/h3/a");
			xpaths.add("//div[20]/div/h3/a");
			xpaths.add("//div[21]/div/h3/a");
			xpaths.add("//div[22]/div/h3/a");
			xpaths.add("//div[23]/div/h3/a");
			xpaths.add("//div[24]/div/h3/a");
			xpaths.add("//div[25]/div/h3/a");
			xpaths.add("//div[26]/div/h3/a");
			xpaths.add("//div[27]/div/h3/a");
			xpaths.add("//div[28]/div/h3/a");
			xpaths.add("//div[29]/div/h3/a");
			
	  }

	  @Test
	  public void testHomeSearchResults() throws Exception {

		  //Make list
		  for(Map.Entry<String,String[]> make : makes.entrySet()){

			  wait(1);
			  try{
				  select("id","makesDrop",make.getKey());
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

			      click("cssSelector","img[alt=\"Find It\"]");
			      wait(1);
			
			      //Evaluate each item in the array per Make
			      for(String kw : make.getValue()){
			    	  elementListReset();
			    	  elementList.add(newElement("xpath", "^[\\s\\S]*[19|20]{2}[0-9]{2}(?i:.*"+kw+"*)[\\s\\S]*$"));
			    	  
			    	  //Verify all results header/title
			    	  for(String xpath : xpaths){
			    		  doVerifyTextPresentList(elementList, xpath);
			    	  }
			    	  
			      }
			      
			      wait(1);
			      getDriver().findElement(By.linkText("HOME")).click();
			      //wait(1);
		  
			  }
			  
		 }
		 
		  
	  }
	
	  @After
	  public void tearDown() throws Exception {
		  printTotalVerification();
		  String verificationErrorString = this.getVerificationErrors().toString();
		  if (!"".equals(verificationErrorString)) {
			  fail(verificationErrorString);
		  }
	  }
	  

 
}