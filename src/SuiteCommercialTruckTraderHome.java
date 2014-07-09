import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
public class SuiteCommercialTruckTraderHome {

	  public static Test suite() {
		  
		  TestSuite suite = new TestSuite();
	    
		  suite.addTestSuite(com.commercialtrucktrader.home.TestLogoNav.class);
		  suite.addTestSuite(com.commercialtrucktrader.home.TestAdLinks.class);
		  suite.addTestSuite(com.commercialtrucktrader.home.TestAdLinksLandingPage.class);  
		  suite.addTestSuite(com.commercialtrucktrader.home.TestSearchResults.class);
		  suite.addTestSuite(com.commercialtrucktrader.home.TestSearchResultsDodge.class);
		  suite.addTestSuite(com.commercialtrucktrader.home.TestSearchResultsRAM.class);
		  
		  //suite.addTestSuite(com.commercialtrucktrader.home.TestSearchLandingPageBasic.class);
		  //suite.addTestSuite(com.commercialtrucktrader.home.TestSearchLandingPageBasicDodgeCrewCab.class);
	    
		  return suite;
	  }
	
	  public static void main(String[] args) {
		  junit.textui.TestRunner.run(suite());
	  }

  
}
