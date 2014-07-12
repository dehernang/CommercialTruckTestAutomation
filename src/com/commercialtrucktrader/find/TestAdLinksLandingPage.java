package com.commercialtrucktrader.find;

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
	
	@Before
	public void setUp() throws Exception {  
		Boolean good = super.init(TestAdLinksLandingPage.class.getName());
		if(!good)
			throw new Exception();
	}
	
	@Test
	public void testAdLinksLandingPage() throws Exception {

		click("linkText","FIND");
		click("linkText","Bus");

		//--------- Chevy ---------

		element.put("^[\\s\\S]*Bus for Sale[\\s\\S]*$","xpath");	
	    doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		
		  

		  
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
