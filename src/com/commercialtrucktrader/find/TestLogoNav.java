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
 * @since Jul 7, 2014
 *
 */
public class TestLogoNav extends TestCaseHelper {
	  
	  @Before
	  public void setUp() throws Exception {  
		  Boolean good = super.init(TestLogoNav.class.getName());
			if(!good)
				throw new Exception();
	  }
	
	  @Test
	  public void testFindLogoNav() throws Exception {
		  
		  click("linkText","FIND");
  	  
		  /*
		   * Part A
		   */
		  
		  //Logo
		  elementList.add(newElement("xpath", "//a[@id='cttol_icon']/img"));
		  elementList.add(newElement("id", "tol_logo"));

		  //Top Right Links
		  elementList.add(newElement("linkText", "Sign In"));
		  elementList.add(newElement("linkText", "Join Now"));
		  elementList.add(newElement("xpath", "(//a[contains(text(),'Help')])[2]"));

		  //Main Nav
		  elementList.add(newElement("linkText", "HOME"));
		  elementList.add(newElement("linkText", "FIND"));
		  elementList.add(newElement("linkText", "SELL"));
		  elementList.add(newElement("linkText", "AUCTIONS"));
		  elementList.add(newElement("linkText", "RESEARCH"));
	    
		  //Sub Nav
		  elementList.add(newElement("linkText", "» Search Trucks"));
		  elementList.add(newElement("linkText", "» Browse Trucks"));
		  elementList.add(newElement("linkText", "» Browse Trailers"));
		  elementList.add(newElement("linkText", "» Find A Dealer"));
		  elementList.add(newElement("linkText", "» Truck Locator"));
	    
		  //Right Sub Nav
		  elementList.add(newElement("id", "viewall_img1"));
	    
		  //Footer Nav
		  elementList.add(newElement("linkText", "About Us"));
		  elementList.add(newElement("linkText", "Become a Dealer"));
		  elementList.add(newElement("linkText", "Testimonials"));
		  elementList.add(newElement("linkText", "Advertise"));
		  elementList.add(newElement("linkText", "Contact Us"));
		  elementList.add(newElement("linkText", "Help Center"));
		  elementList.add(newElement("linkText", "Site Map"));
	    
		
		  //types of trucks
		  elementList.add(newElement("linkText", "Bus"));
		  elementList.add(newElement("linkText", "Crew Cab"));
		  elementList.add(newElement("linkText", "Extended Cab"));
		  elementList.add(newElement("linkText", "Pickup Truck"));
		  elementList.add(newElement("linkText", "Van"));
		  elementList.add(newElement("linkText", "Beverage Truck"));
		  elementList.add(newElement("linkText", "Box/Straight Truck"));
		  elementList.add(newElement("linkText", "Flatbed Truck"));
		  elementList.add(newElement("linkText", "Refrigerated Truck"));
		  elementList.add(newElement("linkText", "Cab Chassis"));
		  elementList.add(newElement("linkText", "Day Cab"));
		  elementList.add(newElement("linkText", "Sleeper Truck"));
		  elementList.add(newElement("linkText", "Dump Body"));
		  elementList.add(newElement("linkText", "Flatbed Body"));
		  elementList.add(newElement("linkText", "Reefer Body"));
		  elementList.add(newElement("linkText", "Service Body"));
		  elementList.add(newElement("linkText", "Van Body"));
		  elementList.add(newElement("linkText", "Dump Truck"));
		  elementList.add(newElement("linkText", "Bucket/Boom Truck"));
		  elementList.add(newElement("linkText", "Fire Truck"));
		  elementList.add(newElement("linkText", "Garbage Truck"));
		  elementList.add(newElement("linkText", "Landscape Truck"));
		  elementList.add(newElement("linkText", "Landscape Truck"));
		  elementList.add(newElement("linkText", "Utility/Service Truck"));
		  elementList.add(newElement("linkText", "Wrecker Tow Truck"));
		  elementList.add(newElement("linkText", "More Categories..."));
		  
		  //browse trucks by make
		  elementList.add(newElement("linkText", "Chevrolet"));
		  elementList.add(newElement("linkText", "Dodge"));
		  elementList.add(newElement("linkText", "Ford"));
		  elementList.add(newElement("linkText", "Freightliner"));
		  elementList.add(newElement("linkText", "GMC"));
		  elementList.add(newElement("linkText", "Hino"));
		  elementList.add(newElement("linkText", "International"));
		  elementList.add(newElement("linkText", "Isuzu"));
		  elementList.add(newElement("linkText", "Kenworth"));
		  elementList.add(newElement("linkText", "Mack"));
		  elementList.add(newElement("linkText", "Mitsubishi-Fuso"));
		  elementList.add(newElement("linkText", "Peterbilt"));
		  elementList.add(newElement("linkText", "Ram"));
		  elementList.add(newElement("linkText", "Sterling"));
		  elementList.add(newElement("linkText", "Volvo"));
		  elementList.add(newElement("linkText", "Western Star"));
		  elementList.add(newElement("linkText", "Browse All Makes..."));

		  //Footer Sub Nav
		  elementList.add(newElement("linkText", "Security Center"));
		  elementList.add(newElement("linkText", "Advertiser Agreement"));
		  elementList.add(newElement("linkText", "Privacy Policy"));
		  elementList.add(newElement("linkText", "Copyright"));
	    
		  //Terms of Use
		  elementList.add(newElement("linkText", "Terms of Use"));
	    
		  //Footer Dominion Enterprises
		  elementList.add(newElement("linkText", "Dominion Enterprises"));
    
		  doVerifyElementPresentList(elementList);

		  /*
		   * Part B
		   */
		  
		  elementListReset();
		  
		  click("id","viewall_img1");
	  
		  elementList.add(newElement("linkText", "Aero Trader"));
		  elementList.add(newElement("linkText", "ATV Trader"));
		  elementList.add(newElement("linkText", "Boat Trader"));
		  elementList.add(newElement("linkText", "Cycle Trader"));
		  elementList.add(newElement("linkText", "Equipment Trader"));
		  elementList.add(newElement("linkText", "PWC Trader"));
		  elementList.add(newElement("linkText", "RV Trader"));
		  elementList.add(newElement("linkText", "Snowmobile Trader"));
		  elementList.add(newElement("linkText", "Trader Online"));
		  elementList.add(newElement("linkText", "Trailer Trader"));
		  elementList.add(newElement("linkText", "Fraud Awareness Tips"));
		  elementList.add(newElement("cssSelector", "div.viewDomLogo"));
		  
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
