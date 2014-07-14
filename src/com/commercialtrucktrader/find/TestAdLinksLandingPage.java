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

		
	}
	
	@Test
	public void testAdLinksLandingPage() throws Exception {

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
		
		
		/*
		for(Map.Entry<String, String[]> e: link.entrySet()){
			
			click("linkText","FIND");
			click("linkText",e.getKey());
			
			element.clear();
			element.put("^[\\s\\S]*"+e.getValue()[0]+"[\\s\\S]*$","xpath");
			doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
			
			element.clear();
			element.put("^[\\s\\S]*"+e.getValue()[1]+"[\\s\\S]*$","xpath");
			doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
			
			
////////////
			element.clear();
			for(String target: e.getValue()){			
				//element.put("^[\\s\\S]*"+target+"[\\s\\S]*$","xpath");	
				//element.put("^[\\s\\S]*Bus results found[\\s\\S]*$","xpath");	
			}
			
			Bus for Sale
			element.put("^[\\s\\S]*Bus results found[\\s\\S]*$","xpath");
			
			wait(1);
			doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
			//div[@id='pagineationSort_container']/h2
		    
///////////////
		
		
		
		}
		*/
		
	    
	    
	  }
	  
	  
	  @After
	  public void tearDown() throws Exception {
		  printTotalVerification();
		  super.finalize();
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
