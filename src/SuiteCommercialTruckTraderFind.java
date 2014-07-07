import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author hernan
 * @version 1.0
 * @since Jul 7, 2014
 *
 */
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
