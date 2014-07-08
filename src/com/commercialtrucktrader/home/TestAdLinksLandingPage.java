package com.commercialtrucktrader.home;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.TCUtil;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestAdLinksLandingPage extends TCUtil{
		
	
	public TestAdLinksLandingPage(){
		super();
		super.classname = TestAdLinksLandingPage.class.getSimpleName();
	}
	
	  @Before
	  public void setUp() throws Exception {
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(super.timeout, TimeUnit.SECONDS);
	  }
	
	  @Test
	  public void testAdLinksLandingPage() throws Exception {
		  
		  driver.get(baseUrl + "/");
		  driver.findElement(By.linkText("Chevy Trucks")).click();

		  //--------- Chevy ---------

		  element.put("^[\\s\\S]*Chevrolet Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/h1");	
		  
		  //element.clear();
		  //element.put("//img[@alt='Chevy for Sale']","xpath");
		  //this.doVerifyElementPresent(element);	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Chevrolet results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");	

		  		  
		  //--------- Ford ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Ford Trucks")).click();
		  
		  element.clear();
		  
		  element.put("^[\\s\\S]*Ford Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/h1");	
		  
		  //element.clear();
		  //element.put("//img[@alt='Isuzu for Sale']","xpath");
		  //this.doVerifyElementPresent(element);	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Ford results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Freightliner ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Freightliner Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Freightliner Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/div/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Freightliner results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- GMC ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("GMC Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Gmc Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/div/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Gmc results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");		  
		  

		  //--------- Hino ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Hino Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Hino Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/div/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Hino results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		
		  
		  //--------- International ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("International Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*International Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*International results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Isuzu ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Isuzu Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Isuzu Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Isuzu results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Nissan ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Nissan Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Nissan Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/div/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Nissan results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Peterbilt ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Peterbilt Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Peterbilt Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/div/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Peterbilt results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Ram ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Ram Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Ram Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Ram results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");	

		  
		  //--------- Sterling ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Sterling Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Sterling Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/div/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Sterling results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  
		  
		  //--------- Volvo ---------
		  
		  driver.findElement(By.linkText("HOME")).click();
		  driver.findElement(By.linkText("Volvo Trucks")).click();
		  
		  element.clear();
		  element.put("^[\\s\\S]*Volvo Trucks for Sale[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='topic_container']/h1");	
		  
		  element.clear();
		  element.put("^[\\s\\S]*Volvo results found[\\s\\S]*$","xpath");
		  this.doVerifyTextPresent(element, true, TestAdLinksLandingPage.class.getSimpleName(), "//div[@id='pagineationSort_container']/h2");
		  

		  
		  
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
