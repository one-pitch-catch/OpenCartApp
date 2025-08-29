package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
	
	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkboxpp;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnctn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;


	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setemail(String mail)
	{
		txtemail.sendKeys(mail);
	}
	
	public void setPhone(String phoneno)
	{
		txtphone.sendKeys(phoneno);
	}
	
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setConfPassword(String pwd)
	{
		txtconpwd.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkboxpp.click();;
	}
	
	public void clickContinue()
	{
		btnctn.click();;
	}
	
	public String getConfirmationMsg() 
	{
		try 
		{
			return (msgConfirmation.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());

		}

	}
	

}
