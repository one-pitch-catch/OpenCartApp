package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC_002LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void logintest()
	{
		try
		{
		logger.info("Test Started...");
		HomePage hp=new HomePage(driver);
		
		
		hp.clickaccount();
		logger.info("clicked account...");
		
		hp.clicklogin();
		logger.info("clicked login...");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("entered details...");
		
		MyAccountPage myap=new MyAccountPage(driver);
		logger.info("validating target...");
		boolean targetpage=myap.MyAccountExists();
		
		Assert.assertTrue(targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Test ended...");
		
	}
	
	
	
	
	
	

}
