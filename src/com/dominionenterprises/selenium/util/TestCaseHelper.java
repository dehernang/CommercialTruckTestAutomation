/**
 * 
 */
package com.dominionenterprises.selenium.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

	//protected Map<String, String> element;
	protected ArrayList<Map<String,String>> elementList;

	protected String testing;
	protected int counter;
	protected int counterPass;
	protected int counterFail;
	protected int retval;

	protected static int counterOverall;
	protected static int counterPassOverall;
	protected static int counterFailOverall;

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

	private Properties prop;

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
		prop = new Properties();

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

		this.elementList = new ArrayList<Map<String,String>>();
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

		if(this._baseUrl == null) return false;

		if(this._timeout == -1)
			this._timeout = 30; //default

		//re-use if there is already an instance
		if(_sharedDriver){
			WebDriver dr = super.getDriver();
			if(dr == null){	
				println("Driver is null. Creating new instance...");
				if(!super.setDriver(new FirefoxDriver())) return false;
			}
		}else{
			if(!super.setDriver(new FirefoxDriver())) return false;
		}

		if(!super.setTestCaseName(testCaseName)) return false;

		//setting params based on config file
		try{
			if(!super.setDimension(new Dimension(this._dimensionx,this._dimensiony))) return false;
			if(!super.setPoint(new Point(this._pointx,this._pointy))) return false;
			if(!super.setBaseUrl(this._baseUrl)) return false;	 
			if(!super.setTimeout(this._timeout)) return false;
		}catch(Exception e){ return false; }
		return true;
	}

	public Boolean setDriverBaseUrl(String url){
		if(!super.setBaseUrl(url))
			return false;		
		println("set baseUrl: "+url);
		return true;
	}

	public Boolean setDriverTimeout(int to){
		if(!super.setTimeout(to))
			return false;
		println("set timeout: "+to);
		return true;
	}

	public Boolean setDriverDimension(int x, int y){
		Dimension d = new Dimension(x,y);
		if(!super.setDimension(d))
			return false;
		println("set dimension("+x+","+y+")");
		return true;
	}

	public Boolean setDriverPoint(int x, int y){
		Point p = new Point(1,1);
		if(!super.setPoint(p))
			return false;
		println("set point("+x+","+y+")");
		return true;
	}

	private void generateResult(int result, String method, String type, String target){
		if(result == TestCaseHelper.PASS){
			result(target, super.getTestCaseName(), true, method+"-"+type);
			incrementCounterPass();
		}else{
			result(target, super.getTestCaseName(), false, method+"-"+type);
			incrementCounterFail();
		}
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

		StringBuilder fStr = trimTestCaseName(tcName);

		StringBuilder text = new StringBuilder();
		text.append(status);
		text.append(" <"+fStr+">");
		text.append(" <"+method+">");
		text.append(" <"+target+">");
		if(xpath != null)
			text.append(" <"+xpath+">");
		System.out.println(text);
	}

	//remove the com.xxx
	private StringBuilder trimTestCaseName(String tcName){
		final String dot = ".";
		String[] tmp = tcName.split("\\"+dot);
		StringBuilder str = new StringBuilder();
		String prep = "";
		for(int x=0; x<tmp.length; x++){
			if(x != 0 && x != 1){
				str.append(prep + tmp[x]);
				prep = dot;
			}
		}
		return str;
	}


	public void println(String msg){
		System.out.println(msg);
	}

	public void printTotalVerification(){
		this.println(super.getTestCaseName() + " TestCase Total: " + this.counter + " Pass: " + this.counterPass + " Fail: " + this.counterFail);
		this.println(super.getTestCaseName() + " Suite Total: " + TestCaseHelper.counterOverall
				+ " Pass: " + TestCaseHelper.counterPassOverall
				+ " Fail: " + TestCaseHelper.counterFailOverall);
		this.println("------------- ---------------- ---------------");
	}


    /*
     * Helpers
     */
    
	public Map<String,String> newElement(String k, String v){
		 Map<String,String> tmp = new HashMap<String,String>();
		 tmp.put(k,v);
		 return tmp;
	}

	public void elementListReset(){
		this.elementList = new ArrayList<Map<String,String>>();
	}

	public void wait(int sec) throws InterruptedException{
		long msec = sec * 1000;
		Thread.sleep(msec);
	}

	public void incrementCounterPass(){
		this.counterPass++;
		this.incrementCounters();
	}

	public void incrementCounterFail(){
		this.counterFail++;
		this.incrementCounters();
	}

	private void incrementCounters(){
		this.counter++;
		TestCaseHelper.counterOverall++;
		TestCaseHelper.counterPassOverall++;
		TestCaseHelper.counterFailOverall++;
	}

    /*
     * Operations
     */

	public void doVerifyTextPresentList(ArrayList<Map<String, String>> e, String locationStr){
		for(Map<String, String> list: e){
			for(Map.Entry<String, String> listEntry : list.entrySet()){
				retval = this.doVerifyTextPresent(listEntry.getKey(), listEntry.getValue(), locationStr);
				generateResult(retval,"doVerifyTextPresentList",listEntry.getKey(), listEntry.getValue());
			}
		}
	}

	public void doVerifyElementPresentList(ArrayList<Map<String, String>> e){
		for(Map<String, String> list: e){
			for(Map.Entry<String, String> listEntry : list.entrySet()){		
				retval = this.doVerifyElementPresent(listEntry.getKey(), listEntry.getValue());
				generateResult(retval,"doVerifyElementPresentList",listEntry.getKey(), listEntry.getValue());
			}
		}
	}

	public void doVerifyTextNotPresentList(ArrayList<Map<String, String>> e, String locationStr){
		for(Map<String, String> list: e){
			for(Map.Entry<String, String> listEntry : list.entrySet()){
				retval = this.doVerifyTextNotPresent(listEntry.getKey(), listEntry.getValue(), locationStr);
				generateResult(retval,"doVerifyTextNotPresentList",listEntry.getKey(), listEntry.getValue());
			}
		}
	}

	public void doVerifyElementNotPresentList(ArrayList<Map<String, String>> e){
		for(Map<String, String> list: e){
			for(Map.Entry<String, String> listEntry : list.entrySet()){
				retval = this.doVerifyElementNotPresent(listEntry.getKey(), listEntry.getValue());
				generateResult(retval,"doVerifyElementNotPresentList",listEntry.getKey(), listEntry.getValue());
			}
		}
	}




}
