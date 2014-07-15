package com.commercialtrucktrader.home;

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
public class TestBrowseMakeLinks extends TestCaseHelper{

	  @Before
	  public void setUp() throws Exception {
		  Boolean good = super.init(TestBrowseMakeLinks.class.getName());
			if(!good)
				throw new Exception();
		  //this.setDriverBaseUrl("http://www.commercialtrucktrader.com/");	
	  }
	
	  @Test
	  public void testHomeBrowseMakeLinks() throws Exception {
		  
		  //click("cssSelector","img[alt=\"Go To Commercial Truck Home Page\"]");
		  click("linkText","HOME");
		  moveToElement("id","browse");
		  click("linkText","Browse Trucks by Make");

		  element.put("Dodge/Ram","cssSelector");
		  element.put("Dodge / Ram","cssSelector");
		  element.put("Dodge.*.Ram","cssSelector");
		  doVerifyTextNotPresentList(element, "BODY");

		  
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
