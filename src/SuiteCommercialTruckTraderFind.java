import junit.framework.Test;
import junit.framework.TestSuite;

public class SuiteCommercialTruckTraderFind {

	
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(com.commercialtrucktrader.find.TestLogoNav.class);
    suite.addTestSuite(com.commercialtrucktrader.find.TestSearchResults.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }

  
}
