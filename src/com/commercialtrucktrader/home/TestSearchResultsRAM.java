package com.commercialtrucktrader.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.commercialtrucktrader.find.TestAdLinksLandingPage;
import com.dominionenterprises.selenium.util.TestCaseHelper;

import java.util.Map;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestSearchResultsRAM extends TestCaseHelper{

		private static final String make = "RAM";
		private Map<String,String[]> notExistsKW;
		private ArrayList<String> xpaths;

		@Before
		public void setUp() throws Exception {
			Boolean good = super.init(TestSearchResultsRAM.class.getName());
			if(!good)
				throw new Exception();
			notExistsKW = new HashMap<String,String[]>();	
			notExistsKW.put("RAM",new String[]{"DODGE","DODGE/RAM"});
			
			xpaths = new ArrayList<String>();
			xpaths.add("//h3/a");
			xpaths.add("//div[4]/div/h3/a");
			xpaths.add("//div[5]/div/h3/a");
			xpaths.add("//div[7]/div/h3/a");
			xpaths.add("//div[8]/div/h3/a");
			xpaths.add("//div[9]/div/h3/a");
			xpaths.add("//div[10]/div/h3/a");
			xpaths.add("//div[11]/div/h3/a");
			xpaths.add("//div[12]/div/h3/a");
			xpaths.add("//div[13]/div/h3/a");
			xpaths.add("//div[14]/div/h3/a");
			xpaths.add("//div[15]/div/h3/a");
			xpaths.add("//div[17]/div/h3/a");
			xpaths.add("//div[18]/div/h3/a");
			xpaths.add("//div[19]/div/h3/a");
			xpaths.add("//div[20]/div/h3/a");
			xpaths.add("//div[21]/div/h3/a");
			xpaths.add("//div[22]/div/h3/a");
			xpaths.add("//div[23]/div/h3/a");
			xpaths.add("//div[24]/div/h3/a");
			xpaths.add("//div[25]/div/h3/a");
			xpaths.add("//div[26]/div/h3/a");
			xpaths.add("//div[27]/div/h3/a");
			xpaths.add("//div[28]/div/h3/a");
			xpaths.add("//div[29]/div/h3/a");
			
	  }

	  @Test
	  public void testHomeSearchResultsRAM() throws Exception {
		  
		  /*
		   * Search by selecting from drop down menu
		   */
		  
		  wait(1);		  
		  try{
			  select("id","makesDrop",make);
			  click("cssSelector","img[alt=\"Find It\"]");
			  wait(1);		  
			  
			  verifyResults();
			  
			  wait(1);
			  getDriver().findElement(By.linkText("HOME")).click();  
		  }catch(Exception e){
			  println(e.getMessage());
			  result(make, TestSearchResultsRAM.class.getSimpleName(), false, "selectByVisibleText");
		  }
			  
		  
		  /*
		   * Search using keyword only
		   */
		  
		  click("linkText","HOME");
		  input("id","keyword",make);
		  click("cssSelector","img[alt=\"Find It\"]");
		  verifyResults();
		  
	  }
	
	  @After
	  public void tearDown() throws Exception {
		  printTotalVerification();	  
		  String verificationErrorString = this.getVerificationErrors().toString();
		  if (!"".equals(verificationErrorString)) {
			  fail(verificationErrorString);
		  }
	  }
	  
	  private void verifyResults(){
		  element.clear();
		  element.put("^[\\s\\S]*201[1-9](?i:.*"+make+"*)[\\s\\S]*$","xpath");	
		  for(String xpath : xpaths){ 
			  doVerifyTextPresentList(element, xpath); //Verify all results header/title
		  }
	  }
 
}