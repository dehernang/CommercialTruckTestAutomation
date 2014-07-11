package com.commercialtrucktrader.find;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dominionenterprises.selenium.util.TC;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestLogoNav extends TC {
	  
	  @Before
	  public void setUp() throws Exception {
		  super.init(TestLogoNav.class.getName());
	  }
	
	  @Test
	  public void testLogoNav() throws Exception {
		  
		  click("linkText","FIND");
	    
		  //Logo
		  element.put("//a[@id='cttol_icon']/img", "xpath");
		  element.put("tol_logo", "id");

		  //Top Right Links
		  element.put("Sign In","linkText");
		  element.put("Join Now","linkText");
		  element.put("(//a[contains(text(),'Help')])[2]","xpath");
	    
		  //Main Nav
		  element.put("HOME","linkText");
		  element.put("FIND","linkText");
		  element.put("SELL","linkText");
		  element.put("AUCTIONS","linkText");
		  element.put("RESEARCH","linkText");
	    
		  //Sub Nav
		  element.put("» Search Trucks","linkText");
		  element.put("» Browse Trucks","linkText");
		  element.put("» Browse Trailers","linkText");
		  element.put("» Find A Dealer","linkText");
		  element.put("» Truck Locator","linkText");
	    
		  //Right Sub Nav
		  element.put("viewall_img1","id");
	    
		  //Footer Nav
		  element.put("About Us","linkText");
		  element.put("Become a Dealer","linkText");
		  element.put("Testimonials","linkText");
		  element.put("Advertise","linkText");
		  element.put("Contact Us","linkText");
		  element.put("Help Center","linkText");
		  element.put("Site Map","linkText");
	    
		
		  //types of trucks
		  element.put("Bus","linkText");
		  element.put("Crew Cab","linkText");
		  element.put("Extended Cab","linkText");
		  element.put("Pickup Truck","linkText");
		  element.put("Van","linkText");
		  element.put("Beverage Truck","linkText");
		  element.put("Box/Straight Truck","linkText");
		  element.put("Flatbed Truck","linkText");
		  element.put("Refrigerated Truck","linkText");
		  element.put("Cab Chassis","linkText");
		  element.put("Day Cab","linkText");
		  element.put("Sleeper Truck","linkText");
		  element.put("Dump Body","linkText");
		  element.put("Flatbed Body","linkText");
		  element.put("Reefer Body","linkText");
		  element.put("Service Body","linkText");
		  element.put("Van Body","linkText");
		  element.put("Dump Truck","linkText");
		  element.put("Bucket/Boom Truck","linkText");
		  element.put("Fire Truck","linkText");
		  element.put("Garbage Truck","linkText");
		  element.put("Landscape Truck","linkText");
		  element.put("Landscape Truck","linkText");
		  element.put("Utility/Service Truck","linkText");
		  element.put("Wrecker Tow Truck","linkText");
		  element.put("More Categories...","linkText");
		  
		  //browse trucks by make
		  element.put("Chevrolet","linkText");
		  element.put("Dodge","linkText");
		  element.put("Ford","linkText");
		  element.put("Freightliner","linkText");
		  element.put("GMC","linkText");
		  element.put("Hino","linkText");
		  element.put("International","linkText");
		  element.put("Isuzu","linkText");
		  element.put("Kenworth","linkText");
		  element.put("Mack","linkText");
		  element.put("Mitsubishi-Fuso","linkText");
		  element.put("Peterbilt","linkText");
		  element.put("Ram","linkText");
		  element.put("Sterling","linkText");
		  element.put("Volvo","linkText");
		  element.put("Western Star","linkText");
		  element.put("Browse All Makes...","linkText");

		  //Footer Sub Nav
		  element.put("Security Center","linkText");
		  element.put("Advertiser Agreement","linkText");
		  element.put("Privacy Policy","linkText");
		  element.put("Copyright","linkText");
	    
		  //Terms of Use
		  element.put("Terms of Use","linkText");
	    
		  //Footer Dominion Enterprises
		  element.put("Dominion Enterprises","linkText");
	    
		  this.doVerifyElementPresent(element);
	    
		  element.clear();		  
		  driver.findElement(By.id("viewall_img1")).click();		  
		  element.put("Aero Trader", "linkText");
		  element.put("ATV Trader", "linkText");
		  element.put("Boat Trader", "linkText");
		  element.put("Cycle Trader", "linkText");
		  element.put("Equipment Trader", "linkText");
		  element.put("PWC Trader", "linkText");
		  element.put("RV Trader", "linkText");
		  element.put("Snowmobile Trader", "linkText");
		  element.put("Trader Online", "linkText");
		  element.put("Trailer Trader", "linkText");
		  element.put("Fraud Awareness Tips", "linkText");
		  element.put("div.viewDomLogo", "cssSelector");		  
		  this.doVerifyElementPresent(element);
	   
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
