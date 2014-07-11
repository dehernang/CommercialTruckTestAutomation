package com.commercialtrucktrader.home;

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
public class TestLogoNav extends TC{

	  @Before
	  public void setUp() throws Exception {
		  super.init(TestLogoNav.class.getName());
	  }
	
	  @Test
	  public void testLogoNav() throws Exception {
		  
		  click("cssSelector","img[alt=\"Go To Commercial Truck Home Page\"]");
	    
		  //Logo
		  element.put("//a[@id='cttol_icon']/img", "xpath");
		  element.put("tol_logo2", "id");
	    
		  //Social Media
		  element.put("//img[@alt='Commercial Truck Trader Facebook']", "xpath");
		  element.put("//img[@alt='Commercial Truck Trader Google+']", "xpath");
		  element.put("//img[@alt='Commercial Truck Trader Twitter']", "xpath");
		  element.put("//img[@alt='Commercial Truck Trader LinkedIn']", "xpath");
	    
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
		  element.put("» Browse Trucks","linkText");
		  element.put("» Browse Trailers","linkText");
		  element.put("» Search Trucks","linkText");
		  element.put("» Find Dealers","linkText");
		  element.put("» Industry Resources","linkText");
		  element.put("» Dealer Services/Login","linkText");
	    
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
	    
		  //Research Trucks and Trailers
		  element.put("Insurance","linkText");
		  element.put("Truck Auctions","linkText");
		  element.put("Jobs & Training","linkText");
		  element.put("Vehicle History","linkText");
		  element.put("Truck Bodies","linkText");
		  element.put("Finance/Lease","linkText");
		  element.put("Shipping or Transport","linkText");
		  element.put("Truck Parts","linkText");
		  element.put("Steel Buildings","linkText");
		  element.put("Fuel Management","linkText");
		  element.put("Parts Providers","linkText");
		  element.put("Marketplace Advertisers","linkText");
		  element.put("Insurance","linkText");
		  element.put("View All Resources","linkText");
	    
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
