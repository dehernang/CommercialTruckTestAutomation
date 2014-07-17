package com.commercialtrucktrader.home;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.commercialtrucktrader.find.TestAdLinksLandingPage;
import com.dominionenterprises.selenium.util.TestCaseHelper;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestAdLinks extends TestCaseHelper{
  
	@Before
	public void setUp() throws Exception {
		Boolean good = super.init(TestAdLinks.class.getName());
		if(!good)
			throw new Exception();
	}

	@Test
	public void testHomeAdLinks() throws Exception {

		click("cssSelector","img[alt=\"Go To Commercial Truck Home Page\"]");
    
	    //top truck manufacturers - dynamic may change
	    elementList.add(newElement("linkText", "Chevy Trucks"));
	    //elementList.add(newElement("linkText", "Dodge / Ram Trucks"));
	    elementList.add(newElement("linkText", "Ram Trucks"));
	    elementList.add(newElement("linkText", "Ford Trucks"));
	    elementList.add(newElement("linkText", "Freightliner Trucks"));
	    elementList.add(newElement("linkText", "GMC Trucks"));
	    elementList.add(newElement("linkText", "Hino Trucks"));
	    elementList.add(newElement("linkText", "International Trucks"));
	    elementList.add(newElement("linkText", "Isuzu Trucks"));
	    elementList.add(newElement("linkText", "Nissan Trucks"));
	    elementList.add(newElement("linkText", "Peterbilt Trucks"));
	    elementList.add(newElement("linkText", "Sterling Trucks"));
	    elementList.add(newElement("linkText", "Volvo Trucks"));
	    elementList.add(newElement("linkText", "More Trucks"));
	    
	    
	    //top trucks for sale - dynamic may change
	    elementList.add(newElement("linkText", "Box Truck"));
	    elementList.add(newElement("linkText", "Bucket Truck"));
	    elementList.add(newElement("linkText", "Cab Chassis"));
	    elementList.add(newElement("linkText", "Cabover - Sleeper"));
	    elementList.add(newElement("linkText", "Cargo Van"));
	    elementList.add(newElement("linkText", "Conventional - Day Cab"));
	    elementList.add(newElement("linkText", "Conventional - Sleeper"));
	    elementList.add(newElement("linkText", "Crane Truck"));
	    elementList.add(newElement("linkText", "Crew Cab"));
	    elementList.add(newElement("linkText", "Dump Truck"));
	    elementList.add(newElement("linkText", "Flatbed Truck"));
	    elementList.add(newElement("linkText", "Garbage Truck"));
	    elementList.add(newElement("linkText", "Pickup Truck"));
	    elementList.add(newElement("linkText", "Reefer Truck"));
	    elementList.add(newElement("linkText", "Rollback Tow Truck"));
	    elementList.add(newElement("linkText", "Utility/Service Truck"));
	    elementList.add(newElement("linkText", "Wrecker Tow Truck"));
	    elementList.add(newElement("linkText", "More Truck Categories"));
	    
	    //top trailers for sale - dynamic may change
	    elementList.add(newElement("linkText", "Dry Van Trailer"));
	    elementList.add(newElement("linkText", "Dump Trailer"));
	    elementList.add(newElement("linkText", "Enclosed Trailer"));
	    elementList.add(newElement("linkText", "Box Truck"));
	    elementList.add(newElement("linkText", "Flat Trailer"));
	    elementList.add(newElement("linkText", "More Trailers"));
	    
	    //trucks
	    elementList.add(newElement("linkText", "Heavy Duty Trucks"));
	    elementList.add(newElement("linkText", "Medium Duty Trucks"));
	    elementList.add(newElement("linkText", "Light Duty Trucks"));
	    elementList.add(newElement("linkText", "Trailers"));
	    doVerifyElementPresentList(elementList);

	   
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
