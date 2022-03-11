Feature: Opencart Login Function

Scenario: Valid Login
Given User is on Home page
And User navigates to Login page
When User enters "trainer1@jpinfotek.com" and "testuser"
Then User navigates to My Account page

Scenario: Search Item
Given Uer is on My Account page
When User search item
		| phone |
Then Shoud display search result page

Scenario: Add to Cart
Given User is on search result page
When User Add Item to cart
Then Item must be available in cart
