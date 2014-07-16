package com.commercialtrucktrader.home;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.commercialtrucktrader.find.TestAdLinksLandingPage;
import com.dominionenterprises.selenium.util.TestCaseHelper;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestSearchTrucks extends TestCaseHelper{

	  private ArrayList<String> xpaths;
		
	  @Before
	  public void setUp() throws Exception {
		  Boolean good = super.init(TestSearchTrucks.class.getName());
			if(!good)
				throw new Exception();
			
			xpaths = new ArrayList<String>();
			xpaths.add("//h3/a");
			xpaths.add("//div[4]/div/h3/a");
			xpaths.add("//div[5]/div/h3/a");
			xpaths.add("//div[6]/div/h3/a");
			xpaths.add("//div[7]/div/h3/a");
			xpaths.add("//div[8]/div/h3/a");
			xpaths.add("//div[9]/div/h3/a");
			xpaths.add("//div[10]/div/h3/a");
			xpaths.add("//div[11]/div/h3/a");
			xpaths.add("//div[12]/div/h3/a");
			xpaths.add("//div[13]/div/h3/a");
			xpaths.add("//div[14]/div/h3/a");
			xpaths.add("//div[15]/div/h3/a");
			xpaths.add("//div[16]/div/h3/a");
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
			xpaths.add("//div[30]/div/h3/a");
			xpaths.add("//div[31]/div/h3/a");
			xpaths.add("//div[32]/div/h3/a");
			xpaths.add("//div[33]/div/h3/a");
			
	  }
	
	  @Test
	  public void testHomeSearchTrucks() throws Exception {
		  
		  String make = "DODGE";
		  
		  //click("cssSelector","img[alt=\"Go To Commercial Truck Home Page\"]");
		  click("linkText","HOME");
		  //moveToElement("linkText","» Search Trucks");
		  click("linkText","» Search Trucks");

		  element.put("SEARCH TRUCK LISTINGS","xpath");
		  doVerifyTextPresentList(element, "//h2");
		  
		  click("id","newOrUsed");
		  select("id","lYear","2001");
		  select("id","hYear","2009");
		  select("id","makesDrop",make);
		  input("id","zipcode","23510");
		  click("cssSelector","a.sGo");
		  
		  element.clear();
		  element.put("Dodge Trucks for Sale near Norfolk, Virginia","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Dodge results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  verifyResults(make, xpaths);
	  }
	
	  @After
	  public void tearDown() throws Exception {
		  printTotalVerification();
		  String verificationErrorString = this.getVerificationErrors().toString();
		  if (!"".equals(verificationErrorString)) {
			  fail(verificationErrorString);
		  }
	  }

	  private void verifyResults(String mk, ArrayList<String> xps){
		  element.clear(); 
		  element.put("^[\\s\\S]*200[1-9](?i:.*"+mk+"*)[\\s\\S]*$","xpath");	  
		  for(String xp : xps){ 
			  doVerifyTextPresentList(element, xp); //Verify all results header/title
		  }
	  }  
	
}
