package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{

	//PageFactory

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement acctLink;
	
	@FindBy(linkText = "Login")
	WebElement lgnLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLogin() {
		acctLink.click();
		lgnLink.click();
	}
}
