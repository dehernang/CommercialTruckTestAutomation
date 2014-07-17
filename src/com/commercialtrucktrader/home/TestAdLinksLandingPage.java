package com.commercialtrucktrader.home;

import java.util.ArrayList;
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
public class TestAdLinksLandingPage extends TestCaseHelper{
	
	  @Before
	  public void setUp() throws Exception {
		  Boolean good = super.init(TestAdLinksLandingPage.class.getName());
			if(!good)
				throw new Exception();
	  }
	
	  @Test
	  public void testHomeAdLinksLandingPage() throws Exception {

		  click("linkText","Chevy Trucks");
		  

		  //--------- Chevy ---------

		  elementList.add(newElement("xpath", "^[\\s\\S]*Chevrolet Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Chevrolet results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");

		  //--------- Ford ---------
		  
		  click("linkText","HOME");
		  click("linkText","Ford Trucks");
 
		  elementListReset();	  
		  elementList.add(newElement("xpath", "^[\\s\\S]*Ford Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Ford results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Freightliner ---------
		  
		  click("linkText","HOME");
		  click("linkText","Freightliner Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Freightliner Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/div/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Freightliner results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- GMC ---------
		  
		  click("linkText","HOME");
		  click("linkText","GMC Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Gmc Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/div/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Gmc results found[\\s\\S]*$"));	  
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  

		  //--------- Hino ---------
		  
		  click("linkText","HOME");
		  click("linkText","Hino Trucks");
	  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Hino Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/div/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Hino results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- International ---------
		  
		  click("linkText","HOME");
		  click("linkText","International Trucks");
  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*International Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*International results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Isuzu ---------
		  
		  click("linkText","HOME");
		  click("linkText","Isuzu Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Isuzu Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Isuzu results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Nissan ---------
		  
		  click("linkText","HOME");
		  click("linkText","Nissan Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Nissan Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/div/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Nissan results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Peterbilt ---------
		  
		  click("linkText","HOME");
		  click("linkText","Peterbilt Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Peterbilt Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/div/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Peterbilt results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Ram ---------
		  
		  click("linkText","HOME");
		  click("linkText","Ram Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Ram Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Ram results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Sterling ---------
		  
		  click("linkText","HOME");
		  click("linkText","Sterling Trucks");

		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Sterling Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/div/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Sterling results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Volvo ---------
		  
		  click("linkText","HOME");
		  click("linkText","Volvo Trucks");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Volvo Trucks for Sale[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='topic_container']/h1");
		  
		  elementListReset();
		  elementList.add(newElement("xpath", "^[\\s\\S]*Volvo results found[\\s\\S]*$"));
		  doVerifyTextPresentList(elementList, "//div[@id='pagineationSort_container']/h2");

		  
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
