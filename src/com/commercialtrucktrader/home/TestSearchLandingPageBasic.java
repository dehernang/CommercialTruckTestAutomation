package com.commercialtrucktrader.home;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.TCUtil;

public class TestSearchLandingPageBasic extends TCUtil{

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://php5dev.commercialtrucktrader.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSearchLandingPageBasic() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("keyword")).clear();
		driver.findElement(By.id("keyword")).sendKeys("dodge");
		driver.findElement(By.id("zipcode")).clear();
		driver.findElement(By.id("zipcode")).sendKeys("23510");
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
		new Select(driver.findElement(By.id("alltype"))).selectByVisibleText("Light Duty (Class 1-3)");

    
		driver.findElement(By.linkText("Pickup Truck")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

 
}
