/**
 * 
 */
package com.dominionenterprises.selenium.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.dominionenterprises.selenium.util.TestCaseExt;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 11, 2014
 *
 */
public class TestCaseHelper extends TestCaseExt{

	protected Map<String, String> element;
	protected String testing;
	protected int counter;
	protected int counterPass;
	protected int counterFail;
	protected int retval;
	
	protected Iterator<String> iterator;
	protected String lnkName;
	protected String msg;
	
	private String conf;
	private String env;
	private static final String CONFIG_DEV = "dev.properties";
	private static final String CONFIG_LIVE = "live.properties";
	private static final String LIVE = "live";
	private static final String DEV = "dev";
	private static final String CONFIG_PATH = "com/dominionenterprises/selenium/util/";
	
	private String baseUrlTmp;
	private int timeoutTmp;
	
	public TestCaseHelper() {
		super();
		
		this.baseUrlTmp = null;
		this.timeoutTmp = -1;
		Properties prop = new Properties();	
		try {

			env = (String)System.getenv("ENV_TEST_AUTO");
			println("ENV_TEST_AUTO = " + env + ".");
			
			//ENV_TEST_AUTO has to be set up already
			if(LIVE.equalsIgnoreCase(env)){
				conf = CONFIG_LIVE;
				println("Loading LIVE. " + conf + " " + LIVE + "==" + env);
			}else if(DEV.equalsIgnoreCase(env)){
				conf = CONFIG_DEV;
				println("Loading DEV. " + conf + " " + DEV + "==" + env);
			}else{
				conf = CONFIG_DEV;
				println("Loading Default DEV. " + conf + " " + DEV + "==" + env);
			}
			
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(CONFIG_PATH + conf);
			prop.load(is);
			println("getProperty baseurl: " + prop.getProperty("baseurl"));
			
			this.baseUrlTmp = prop.getProperty("baseurl");
			this.timeoutTmp = Integer.parseInt(prop.getProperty("timeout"));
			
		} catch (IOException e) {
			e.printStackTrace();		
		}
		
		this.element = new HashMap<String, String>();		
		this.counter = 0;
		this.counterPass = 0;
		this.counterFail = 0;
		this.retval = -1;
		
	}
	
	public Boolean init(String testCaseName){
		if(this.baseUrlTmp == null)
			return false;
		if(this.timeoutTmp == -1)
			this.timeoutTmp = 30; //default
		super.setDriver(new FirefoxDriver());
		super.setTestCaseName(testCaseName);
		super.setBaseUrl(this.baseUrlTmp);	
		super.setTimeout(this.timeoutTmp);
		return true;
	}
	
	/*
	 * Printers
	 */
	
	public void result(String target, String tcName, Boolean pass, String method){
		
		/*
		String status = "Passed";
		if(!pass)
			status = "<<<Failed>>>";
	
		println("<"+status+"> - <"+tcName+"> <"+method+"> <" + target + ">");
		*/
		reportTemplate(target,tcName, pass, method, null);
	}
	
	public void result(String target, String tcName, Boolean pass, String method, String xpath){
		/*
		String status = "Passed";
		if(!pass)
			status = "<<<Failed>>>";
	
		println("<"+status+"> - <"+tcName+"> <"+method+"> <" + target + "> <"+xpath+">");
		*/
		reportTemplate(target,tcName, pass, method, xpath);
	}
	
	private void reportTemplate(String target, String tcName, Boolean pass, String method, String xpath){
		String status = "Passed";
		if(!pass)
			status = "!Failed!";
		
		StringBuilder text = new StringBuilder();
		text.append(status);
		text.append(" <"+tcName+">");
		text.append(" <"+method+">");
		text.append(" <"+target+">");
		if(xpath != null)
			text.append(" <"+xpath+">");
		System.out.println(text);
	}
	
	public void println(String msg){
		System.out.println(msg);
	}

    public void printTotalVerification(){
    	this.println(super.getTestCaseName() + " Total: " + this.counter + " Pass: " + this.counterPass + " Fail: " + this.counterFail);  	
    }
    
    
    /*
     * others
     */
    
    public void wait(int sec) throws InterruptedException{
    	long msec = sec * 1000;
    	Thread.sleep(msec);
    }
    
    
    /*
     * Operations
     */
    
    public void doVerifyTextPresentList(Map<String, String> e, String locationStr){
		for(Map.Entry<String, String> lnkEntry : e.entrySet()){
			retval = this.doVerifyTextPresent(lnkEntry, locationStr);
			this.counter++;
			if(retval == super.PASS){
				result(lnkEntry.getKey(), super.getTestCaseName(), true, "doVerifyTextPresentList("+lnkEntry.getValue()+")", locationStr);
				this.counterPass++;
			}else{
				result(lnkEntry.getKey(), super.getTestCaseName(), false, "doVerifyTextPresentList("+lnkEntry.getValue()+")", locationStr);
				this.counterFail++;
			}
		}
    }
    
    public void doVerifyElementPresentList(Map<String, String> e){
		for(Map.Entry<String, String> lnkEntry : e.entrySet()){
			retval = this.doVerifyElementPresent(lnkEntry);
			this.counter++;
			if(retval == super.PASS){
				result(lnkEntry.getKey(), super.getTestCaseName(), true, "doVerifyElementPresentList("+lnkEntry.getValue()+")");
				this.counterPass++;
			}else{
				result(lnkEntry.getKey(), super.getTestCaseName(), false, "doVerifyElementPresentList("+lnkEntry.getValue()+")");
				this.counterFail++;
			}
		}
    }

    public void doVerifyTextNotPresentList(Map<String, String> e, String locationStr){
		for(Map.Entry<String, String> lnkEntry : e.entrySet()){
			retval = this.doVerifyTextNotPresent(lnkEntry, locationStr);
			this.counter++;
			if(retval == super.PASS){
				result(lnkEntry.getKey(), super.getTestCaseName(), true, "doVerifyTextNotPresentList-"+lnkEntry.getValue(), locationStr);
				this.counterPass++;
			}else{
				result(lnkEntry.getKey(), super.getTestCaseName(), false, "doVerifyTextNotPresentList-"+lnkEntry.getValue(), locationStr);
				this.counterFail++;
			}
		}
    }
    
    public void doVerifyElementNotPresentList(Map<String, String> e){
		for(Map.Entry<String, String> lnkEntry : e.entrySet()){
			retval = this.doVerifyElementNotPresent(lnkEntry);
			this.counter++;
			if(retval == super.PASS){
				result(lnkEntry.getKey(), super.getTestCaseName(), true, "doVerifyElementNotPresentList-"+lnkEntry.getValue());
				this.counterPass++;
			}else{
				result(lnkEntry.getKey(), super.getTestCaseName(), false, "doVerifyElementNotPresentList-"+lnkEntry.getValue());
				this.counterFail++;
			}
		}
    }    
    

}
