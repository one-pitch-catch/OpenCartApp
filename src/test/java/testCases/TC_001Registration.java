package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.AccountRegisterPage;
import pageObject.HomePage;

public class TC_001Registration extends BaseClass{
	
	
	
	@Test(groups= {"Regression","Master"})
	public void RegistrationTest()
	{
		logger.info("Starting the Application");
		HomePage hp=new HomePage(driver);
		

		try
		{
		logger.info("Clicking on my account");
		
		hp.clickaccount();
		
		logger.info("Clicking on Register");
		hp.clickregister();
		
		AccountRegisterPage rp=new AccountRegisterPage(driver);
		
		logger.info("Providing Customer Details");
		rp.setFirstName(randomStr().toLowerCase());
		rp.setLastName(randomStr().toLowerCase());
		rp.setemail(randomStr()+"@gmail.com");
		rp.setPhone(randomNum());
		
		String pass=randomAlphaNumeric();
		rp.setPassword(pass);
		rp.setConfPassword(pass);
		
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("Validating the Message");
		String confmsg=rp.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("debug logs..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished Test...");

	}
	
	


}
