import junit.framework.Test;
import junit.framework.TestSuite;

public class SuiteCommercialTruckTraderFind {

	
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(com.commercialtrucktrader.find.TestLogoNav.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }

  
}
