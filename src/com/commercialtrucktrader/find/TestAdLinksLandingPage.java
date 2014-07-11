package com.commercialtrucktrader.find;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dominionenterprises.selenium.util.TC;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 10, 2014
 *
 */
public class TestAdLinksLandingPage extends TC{
	
	@Before
	public void setUp() throws Exception {  
		super.init(TestAdLinksLandingPage.class.getName());
	}
	
	@Test
	public void testAdLinksLandingPage() throws Exception {

		click("linkText","FIND");
		click("linkText","Bus");

		//--------- Chevy ---------

		element.put("^[\\s\\S]*Bus for Sale[\\s\\S]*$","xpath");
		this.doVerifyTextPresent(element, "//div[@id='topic_container']/div/h1");	
		  

		  		  


		  
		  
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
