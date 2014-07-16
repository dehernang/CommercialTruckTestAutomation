package com.commercialtrucktrader.sell;

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
	  public void testSellFindLogoNav() throws Exception {
		  
		  click("linkText","SELL");
	    
		  /*
		   * Common
		   */
		  
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
		  element.put("» Sell Your Trucks","linkText");
		  moveToElement("id","dealer-services");
		  element.put("» Dealer Services","linkText");
	    
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
	    
		  //Footer Sub Nav
		  element.put("Security Center","linkText");
		  element.put("Advertiser Agreement","linkText");
		  element.put("Privacy Policy","linkText");
		  element.put("Copyright","linkText");
	    
		  //Terms of Use
		  element.put("Terms of Use","linkText");
	    
		  //Footer Dominion Enterprises
		  element.put("Dominion Enterprises","linkText");
	    
		  doVerifyElementPresentList(element);

		  element.clear();		  
		  getDriver().findElement(By.id("viewall_img1")).click();		  
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
		  doVerifyElementPresentList(element);

		  /*
		   * Dynamic
		   */
		  
		  //Body
		  element.clear();	
		  element.put("^[\\s\\S]*SELL YOUR COMMERCIAL TRUCK AND TRAILER*[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element,"//div[@id='templateContainer']/div/h1");

		  element.clear();	
		  element.put("^[\\s\\S]*For Individual Sellers*[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element,"//div[@id='sellLeft']/div/h1");
		  
		  element.clear();	
		  element.put("^[\\s\\S]*For Dealers*[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element,"//div[@id='sellRight']/div/h1");
		
		  element.clear();	
		  element.put("^[\\s\\S]*Sell*[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element,"//div[@id='templateContainer']/div/div/span");
		
		
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
