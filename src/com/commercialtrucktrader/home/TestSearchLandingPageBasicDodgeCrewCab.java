package com.commercialtrucktrader.home;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import util.TCUtil;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class TestSearchLandingPageBasicDodgeCrewCab extends TCUtil{

	public TestSearchLandingPageBasicDodgeCrewCab(){
		super(TestSearchLandingPageBasicDodgeCrewCab.class.getName());
	}
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(super.timeout, TimeUnit.SECONDS);
	}

	@Test
	public void testSearchLandingPageBasicDodgeCrewCab() throws Exception {
		
		driver.get(baseUrl + "/");
		driver.findElement(By.id("keyword")).clear();
		driver.findElement(By.id("keyword")).sendKeys("dodge");
		//driver.findElement(By.id("lighttype")).click();
		new Select(driver.findElement(By.id("alltype"))).selectByVisibleText("Light Duty (Class 1-3)");
		new Select(driver.findElement(By.id("typeLight"))).selectByVisibleText("Crew Cab");
		driver.findElement(By.cssSelector("img[alt=\"Find It\"]")).click();
    
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
