package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("****Starting TC_001_AccountRegistrationTest****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating expected message");
		String confmsg=regpage.getConfirmationMsg();
		AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
		  logger.error("Error logs...",e);
		  //logger.debug("Debug logs..");
		  AssertJUnit.fail("Test failed due to exception"+e.getMessage());
		}
		
		logger.info("****Finished TC_001_AccountRegistrationTest****");
		
	}
	
	
	
	
}






