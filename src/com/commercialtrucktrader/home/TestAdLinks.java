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
	public void testAdLinks() throws Exception {

		click("cssSelector","img[alt=\"Go To Commercial Truck Home Page\"]");
    
	    //top truck manufacturers - dynamic may change
	    element.put("Chevy Trucks","linkText");
	    //element.put("Dodge / Ram Trucks","linkText");
	    element.put("Ram Trucks","linkText");
	    element.put("Ford Trucks","linkText");
	    element.put("Freightliner Trucks","linkText");
	    element.put("GMC Trucks","linkText");
	    element.put("Hino Trucks","linkText");
	    element.put("International Trucks","linkText");
	    element.put("Isuzu Trucks","linkText");
	    element.put("Nissan Trucks","linkText");
	    element.put("Peterbilt Trucks","linkText");
	    element.put("Sterling Trucks","linkText");
	    element.put("Volvo Trucks","linkText");
	    element.put("More Trucks","linkText");
	    
	    
	    //top trucks for sale - dynamic may change
	    element.put("Box Truck","linkText");
	    element.put("Bucket Truck","linkText");
	    element.put("Cab Chassis","linkText");
	    element.put("Cabover - Sleeper","linkText");
	    element.put("Cargo Van","linkText");
	    element.put("Conventional - Day Cab","linkText");
	    element.put("Conventional - Sleeper","linkText");
	    element.put("Crane Truck","linkText");
	    element.put("Crew Cab","linkText");
	    element.put("Dump Truck","linkText");
	    element.put("Flatbed Truck","linkText");
	    element.put("Garbage Truck","linkText");
	    element.put("Pickup Truck","linkText");
	    element.put("Reefer Truck","linkText");
	    element.put("Rollback Tow Truck","linkText");
	    element.put("Utility/Service Truck","linkText");
	    element.put("Wrecker Tow Truck","linkText");
	    element.put("More Truck Categories","linkText");
	    
	    //top trailers for sale - dynamic may change
	    element.put("Dry Van Trailer","linkText");
	    element.put("Dump Trailer","linkText");
	    element.put("Enclosed Trailer","linkText");
	    element.put("Box Truck","linkText");
	    element.put("Flat Trailer","linkText");
	    element.put("More Trailers","linkText");
	    
	    //trucks
	    element.put("Heavy Duty Trucks","linkText");
	    element.put("Medium Duty Trucks","linkText");
	    element.put("Light Duty Trucks","linkText");
	    element.put("Trailers","linkText");
	    doVerifyElementPresentList(element);

	   
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
	
	  
	
}
