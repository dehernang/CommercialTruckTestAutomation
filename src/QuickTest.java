import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.commercialtrucktrader.home.TestAdLinks;
import com.dominionenterprises.selenium.util.TestCaseHelper;

/**
 * 
 */

/**
 * @author hernan
 * @version 1.0
 * @since Jul 17, 2014
 *
 */
public class QuickTest extends TestCaseHelper{

	@Before
	public void setUp() throws Exception {
		Boolean good = super.init(QuickTest.class.getName());
		if(!good)
			throw new Exception();
	}

	@Test
	public void testQuickTest() throws Exception {

		//click("cssSelector","img[alt=\"Go To Commercial Truck Home Page\"]");

	    elementList.add(newElement("linkText", "HOME"));
	    doVerifyElementPresentList(elementList);

	   
	  }
	
	  @After
	  public void tearDown() throws Exception {
		  printTotalVerification();
		  String verificationErrorString = this.getVerificationErrors().toString();
		  if (!"".equals(verificationErrorString)) {
			  fail(verificationErrorString);
		  }
	  }
	

}
