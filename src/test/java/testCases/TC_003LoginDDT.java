package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;




/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verifyloginDDT(String email, String password, String exp) throws InterruptedException
	{
		
		
		try {
	
		//Home page
			HomePage hp=new HomePage(driver);
			hp.clickaccount();;
			hp.clicklogin();; //Login link under MyAccount
				
			//Login page
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();; //Login button
				
			//My Account Page
			MyAccountPage myap=new MyAccountPage(driver);
			boolean targetPage=myap.MyAccountExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					myap.ClkLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					myap.ClkLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
			
		
	}
	
}








