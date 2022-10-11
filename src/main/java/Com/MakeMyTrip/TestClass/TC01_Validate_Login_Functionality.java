package Com.MakeMyTrip.TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.MakeMyTrip.LoginPOMClass.LoginPOMClass;

public class TC01_Validate_Login_Functionality extends TestBaseClass {
 
	@Test
	public void Validate_Login_Functionality()
	{
		String expectedText ="Hi dhanashri";
		 LoginPOMClass a= new LoginPOMClass(driver);
		 String actualText = a.getTextOfProfile();
		 log.info(actualText);
		 Assert.assertEquals(expectedText, actualText);
	}
}
