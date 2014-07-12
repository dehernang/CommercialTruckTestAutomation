package com.commercialtrucktrader.home;

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
	  public void testAdLinksLandingPage() throws Exception {

		  click("linkText","Chevy Trucks");

		  //--------- Chevy ---------

		  element.put("^[\\s\\S]*Chevrolet Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Chevrolet results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  		  
		  //--------- Ford ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Ford Trucks")).click();
		  
		  element.clear();
		  
		  element.put("^[\\s\\S]*Ford Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Ford results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Freightliner ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Freightliner Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Freightliner Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Freightliner results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- GMC ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("GMC Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Gmc Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Gmc results found[\\s\\S]*$","xpath");	  
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  

		  //--------- Hino ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Hino Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Hino Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Hino results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- International ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("International Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*International Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*International results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Isuzu ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Isuzu Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Isuzu Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Isuzu results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Nissan ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Nissan Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Nissan Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Nissan results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Peterbilt ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Peterbilt Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Peterbilt Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Peterbilt results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Ram ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Ram Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Ram Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Ram results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Sterling ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Sterling Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Sterling Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/div/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Sterling results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Volvo ---------
		  
		  getDriver().findElement(By.linkText("HOME")).click();
		  getDriver().findElement(By.linkText("Volvo Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Volvo Trucks for Sale[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='topic_container']/h1");
		  
		  element.clear();
		  element.put("^[\\s\\S]*Volvo results found[\\s\\S]*$","xpath");
		  doVerifyTextPresentList(element, "//div[@id='pagineationSort_container']/h2");

		  
		  
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
