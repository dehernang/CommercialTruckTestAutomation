import junit.framework.Test;
import junit.framework.TestSuite;

public class SuiteCommercialTruckTraderHome {

	  public static Test suite() {
		  
		  TestSuite suite = new TestSuite();
	    
		  suite.addTestSuite(com.commercialtrucktrader.home.TestLogoNav.class);
		  suite.addTestSuite(com.commercialtrucktrader.home.TestAdLinks.class);
		  suite.addTestSuite(com.commercialtrucktrader.home.TestAdLinksLandingPage.class);
		  
		  
		  suite.addTestSuite(com.commercialtrucktrader.home.TestSearchResults.class);


		  
		  //suite.addTestSuite(com.commercialtrucktrader.home.TestSearchLandingPageBasic.class);
		  //suite.addTestSuite(com.commercialtrucktrader.home.TestSearchLandingPageBasicDodgeCrewCab.class);
	    
		  return suite;
	  }
	
	  public static void main(String[] args) {
		  junit.textui.TestRunner.run(suite());
	  }

  
}
