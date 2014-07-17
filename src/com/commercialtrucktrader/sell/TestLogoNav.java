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
		  elementList.add(newElement("linkText", "» Sell Your Trucks"));
		  moveToElement("id","dealer-services");
		  elementList.add(newElement("linkText", "» Dealer Services"));
	    
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

		  /*
		   * Dynamic
		   */

		  //Body
		  elementListReset();	
		  elementList.add(newElement("xpath", "^[\\s\\S]*SELL YOUR COMMERCIAL TRUCK AND TRAILER*[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList,"//div[@id='templateContainer']/div/h1");

		  elementListReset();	
		  elementList.add(newElement("xpath", "^[\\s\\S]*For Individual Sellers*[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList,"//div[@id='sellLeft']/div/h1");
		  
		  elementListReset();	
		  elementList.add(newElement("xpath", "^[\\s\\S]*For Dealers*[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList,"//div[@id='sellRight']/div/h1");
		
		  elementListReset();	
		  elementList.add(newElement("xpath", "^[\\s\\S]*Sell*[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList,"//div[@id='templateContainer']/div/div/span");
		
		
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
