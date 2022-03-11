package stepDef;

import java.util.List;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SearchResultPage;

public class OpenCartStepDef extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage acctPage;
	SearchResultPage resultPage;
	
	@Given("User is on Home page")
	public void user_is_on_home_page() {
		initialize();
	}
		
	@Given("User navigates to Login page")
	public void user_navigates_to_login__page() {
		homePage = new HomePage();
		homePage.navigateToLogin();
	}
	
	@When("User enters (string) and (string)") 
	public void user_enters_and(String strUser, String strPwd) {
		loginPage = new LoginPage();
		loginPage.login(strUser, strPwd);
	}

	@Then("User navigates to My Account page")
	public void user_navigates_to_my_account_page() {
		acctPage = new MyAccountPage();
		acctPage.getPageTitle();
		Assert.assertEquals(acctPage.getPageTitle(), "Account Login");
	}
	
	@When("User search item") 
	public void user_search_item(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> items = dataTable.asLists();
		String strItem = items.get(0).get(0);
		System.out.println(strItem);
		System.out.println("Update for CR1");
		acctPage.searchItem(strItem);
	}

	@Then("Shoud display search result page")
	public void should_display_search_result_page() {
		resultPage = new SearchResultPage();
		boolean isPage = resultPage.isSearchResult();
		Assert.assertTrue(isPage);
	}
	
	@When("User Add Item to cart") 
	public void user_add_item_to_cart() {
		resultPage.addItemToCart();
	}
	
	@Then("Item must be available in cart")
	public void item_must_be_availabe_in_cart() {
		boolean isAdded = resultPage.isItemAdded();
		Assert.assertTrue(isAdded);
	}
}
