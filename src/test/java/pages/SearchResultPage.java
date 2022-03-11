package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchResultPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(), 'Add to Cart')]")
	WebElement addCartBtn;
	
	@FindBy(css = "#cart-total")
	WebElement cartTotal;

	@FindBy(xpath = "//h1[contains(text(), 'Search')]")
	WebElement resultHeader;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);

	}
	
	//Actions
	public void addItemToCart() {
		addCartBtn.click();
	}
	
	public boolean isItemAdded() {
		try {
			Thread.sleep(2000);
			
		} catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		
		String strTotal = cartTotal.getText();
		System.out.println("Total : + strTotal");
		String strItemCnt = strTotal.split(" ")[0];
		int intCount = Integer.parseInt(strItemCnt);
		if(intCount > 0)
			return true;
		else 
			return false;
	}

	public boolean isSearchResult() {
		// TODO Auto-generated method stub
		return resultHeader.isDisplayed();
	}


}
