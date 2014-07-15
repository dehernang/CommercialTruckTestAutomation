package com.commercialtrucktrader.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.dominionenterprises.selenium.util.TestCaseHelper;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 10, 2014
 *
 */
public class TestAdLinksLandingPage extends TestCaseHelper{
	
	private HashMap<String,String> targets;
	private Map<String, ArrayList<HashMap<String,String>>> link;
	
	public TestAdLinksLandingPage(){
		link = new HashMap<String, ArrayList<HashMap<String,String>>>();
	}

	@Before
	public void setUp() throws Exception {  
		Boolean good = super.init(TestAdLinksLandingPage.class.getName());
		if(!good)
			throw new Exception();
		
		
		targets = new HashMap<String,String>();
		
		targets.put("Bus for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Bus results found","//div[@id='pagineationSort_container']/h2");		
		addToVerification("Bus",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Crew Cab for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Crew Cab results found","//div[@id='pagineationSort_container']/h2");		
		addToVerification("Crew Cab",targets);

		targets = new HashMap<String,String>();
		targets.put("Extended Cab for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Extended Cab results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Extended Cab",targets);

		targets = new HashMap<String,String>();
		targets.put("Pickup Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Pickup Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Pickup Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Van for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Van results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Van",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Beverage Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Beverage Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Beverage Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Box.*.Straight Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Box.*.Straight Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Box/Straight Truck",targets);
	
		targets = new HashMap<String,String>();
		targets.put("Flatbed Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Flatbed Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Flatbed Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Refrigerated Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Refrigerated Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Refrigerated Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Cab Chassis for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Cab Chassis results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Cab Chassis",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Day Cab for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Day Cab results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Day Cab",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Sleeper Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Sleeper Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Sleeper Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Dump Body for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Dump Body results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Dump Body",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Flatbed Body for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Flatbed Body results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Flatbed Body",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Reefer Body for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Reefer Body results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Reefer Body",targets);

		targets = new HashMap<String,String>();
		targets.put("Service Body for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Service Body results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Service Body",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Van Body for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Van Body results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Van Body",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Dump Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Dump Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Dump Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Bucket.*.Boom Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Bucket.*.Boom Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Bucket/Boom Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Fire Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Fire Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Fire Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Garbage Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Garbage Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Garbage Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Landscape Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Landscape Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Landscape Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Utility.*.Service Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Utility.*.Service Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Utility/Service Truck",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Wrecker Tow Truck for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Wrecker Tow Truck results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Wrecker Tow Truck",targets);

		// Browse by Trucks

		targets = new HashMap<String,String>();
		targets.put("Chevrolet Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("Chevrolet results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Chevrolet",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Dodge Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Dodge results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Dodge",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Ford Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("Ford results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Ford",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Freightliner Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Freightliner results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Freightliner",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Gmc Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Gmc results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("GMC",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Hino Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Hino results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Hino",targets);
		
		targets = new HashMap<String,String>();
		targets.put("International Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("International results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("International",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Isuzu Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("Isuzu results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Isuzu",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Kenworth Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Kenworth results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Kenworth",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Mack Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Mack results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Mack",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Mitsubishi.*.Fuso Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("Mitsubishi.*.Fuso results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Mitsubishi-Fuso",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Peterbilt Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Peterbilt results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Peterbilt",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Ram Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("Ram results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Ram",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Sterling Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("Sterling results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Sterling",targets);
		
		targets = new HashMap<String,String>();
		targets.put("Volvo Trucks for Sale","//div[@id='topic_container']/h1");
		targets.put("Volvo results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Volvo",targets);
		
		targets = new HashMap<String,String>();
		targets.put("W.*.Star Trucks for Sale","//div[@id='topic_container']/div/h1");
		targets.put("W.*.Star results found","//div[@id='pagineationSort_container']/h2");
		addToVerification("Western Star",targets);

		targets = new HashMap<String,String>();
		targets.put("Commercial Trucks for Sale by Manufacturer","//h1");
		targets.put("Ford Trucks, Chevy Trucks, Peterbilt Trucks.*.Choose a Manufacturer","//h5");
		addToVerification("Browse All Makes...",targets);
		
	}
	
	@Test
	public void testFindAdLinksLandingPage() throws Exception {

		for(Map.Entry<String, ArrayList<HashMap<String,String>>> e: link.entrySet()){
			click("linkText","FIND");
			click("linkText",e.getKey());
			
			for(HashMap<String,String> kws : e.getValue()){
				for(Map.Entry<String,String> targs: kws.entrySet()){
					element.clear();
					element.put("^[\\s\\S]*"+targs.getKey()+"[\\s\\S]*$", "xpath");
					doVerifyTextPresentList(element, targs.getValue());
				}
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
	  
	  private void addToVerification(String textLink, HashMap<String,String> targets){		  
		  ArrayList<HashMap<String,String>> targetList = new ArrayList<HashMap<String,String>>();
		  targetList.add(targets);
		  this.link.put(textLink,targetList);
	  }

}
