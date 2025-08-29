package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkregister;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	
	public void clickaccount() {
		lnkaccount.click();
	}
	
	public void clickregister() {
		lnkregister.click();
	}
	
	public void clicklogin() {
		lnklogin.click();
	}

}
