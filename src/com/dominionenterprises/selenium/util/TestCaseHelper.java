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

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

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
	
	private String _baseUrl;
	private int _timeout;
	private int _dimensionx;
	private int _dimensiony;
	private int _pointx;
	private int _pointy;
	private Boolean _sharedDriver;
	
	public TestCaseHelper() {
		super();
		
		this._baseUrl = null;
		this._timeout = -1;
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
			
			//get params
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(CONFIG_PATH + conf);
			prop.load(is);

			this._baseUrl = prop.getProperty("baseurl");
			this._timeout = Integer.parseInt(prop.getProperty("timeout").trim());
			this._dimensionx = Integer.parseInt(prop.getProperty("dimensionx").trim());
			this._dimensiony = Integer.parseInt(prop.getProperty("dimensiony").trim());
			this._pointx = Integer.parseInt(prop.getProperty("pointx").trim());
			this._pointy = Integer.parseInt(prop.getProperty("pointy").trim());
			this._sharedDriver = Boolean.valueOf(prop.getProperty("sharedDriver"));
			
			println("getProperty baseurl: " + prop.getProperty("baseurl"));
			println("getProperty timeout: " + prop.getProperty("timeout"));
			println("getProperty dimensionx: " + prop.getProperty("dimensionx"));
			println("getProperty dimensiony: " + prop.getProperty("dimensiony"));
			println("getProperty pointx: " + prop.getProperty("pointx"));
			println("getProperty pointy: " + prop.getProperty("pointy"));
			println("getProperty sharedDriver: " + prop.getProperty("sharedDriver"));
			
		} catch (IOException e) {
			e.printStackTrace();		
		}
		
		this.element = new HashMap<String, String>();		
		this.counter = 0;
		this.counterPass = 0;
		this.counterFail = 0;
		this.retval = -1;
		
	}
	
	public void finalize(){
		println("Cleaning up...");
		if(super.getDriver() != null)
			super.finalize();
	}

	public Boolean init(String testCaseName){
		if(this._baseUrl == null)
			return false;
		if(this._timeout == -1)
			this._timeout = 30; //default

		//re-use if there is already an instance
		if(_sharedDriver){
			WebDriver dr = super.getDriver();
			if(dr == null){	
				println("Driver is null. Creating new instance...");
				super.setDriver(new FirefoxDriver());
			}
		}else{
			super.setDriver(new FirefoxDriver());		
		}
		
		
		super.setTestCaseName(testCaseName);
		
		//setting params based on config file
		try{
			super.setDimension(new Dimension(this._dimensionx,this._dimensiony));
			super.setPoint(new Point(this._pointx,this._pointy));
			super.setBaseUrl(this._baseUrl);	
			super.setTimeout(this._timeout);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public Boolean setDriverBaseUrl(String url){
		try{
			super.setBaseUrl(url);
			println("baseurl: "+url);
		}catch(Exception e){
			return false;
		}	
		return true;
	}
	
	public Boolean setDriverTimeout(int to){
		try{
			super.setTimeout(to);
			println("timeout: "+to);
		}catch(Exception e){
			return false;
		}	
		return true;
	}

	public Boolean setDriverDimension(int x, int y){
	    Dimension d = new Dimension(x,y);
	    try{
	    	super.setDimension(d);	
	    	println("dimensionx: "+x);
	    	println("dimensiony: "+y);
	    }catch(Exception e){
			return false;
		}	
	    return true;
	}
	
	public Boolean setDriverPoint(int x, int y){
		Point p = new Point(1,1);
		try{
			super.setPoint(p);
			println("pointx: "+x);
			println("pointy: "+y);
		}catch(Exception e){
			return false;
		}	
		return true;
	}
	
	/*
	 * Printers
	 */
	
	public void result(String target, String tcName, Boolean pass, String method){
		reportTemplate(target,tcName, pass, method, null);
	}
	
	public void result(String target, String tcName, Boolean pass, String method, String xpath){
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
    	this.println("----------------------------------------------------------------------");
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
			if(retval == TestCaseHelper.PASS){
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
			if(retval == TestCaseHelper.PASS){
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
			if(retval == TestCaseHelper.PASS){
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
			if(retval == TestCaseHelper.PASS){
				result(lnkEntry.getKey(), super.getTestCaseName(), true, "doVerifyElementNotPresentList-"+lnkEntry.getValue());
				this.counterPass++;
			}else{
				result(lnkEntry.getKey(), super.getTestCaseName(), false, "doVerifyElementNotPresentList-"+lnkEntry.getValue());
				this.counterFail++;
			}
		}
    }    
    

}
