package com.practice.test;

import com.github.javafaker.Faker;
import com.practice.pages.CheckoutPage;
import com.practice.pages.ContactUsPage;
import com.practice.pages.HomePage;
import com.practice.pages.SearchResultsPage;
import com.practice.utils.BrowserUtils;
import com.practice.utils.testBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SpotonAuotmationTest extends testBase{
	
	
	@Test
	public void selenium_automation_test() {
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultPage = new SearchResultsPage();
		CheckoutPage checkoutPage = new CheckoutPage();
		ContactUsPage contactUsPage = new ContactUsPage();

//		Search for and view a shirt using the search bar
		homePage.searchItem("shirt");
		
//		•	Add a shirt and a dress to the cart and continue to the checkout section. 
		searchResultPage.addItemToCart();
		
//		Change the shirt quantity to 2 and remove the dress

		checkoutPage.addOrSubtractItems(2);
		checkoutPage.deleteAllItems();
		
//		•	Compare the features of two clothing items ??
		
//		•	Navigate to the Bestsellers section and sort by highest to lowest price
		homePage.clickBestSellersLinkBtn();
		searchResultPage.sortByText("price:desc");
		Assert.assertTrue(searchResultPage.checkItemPriceHightToLow());
		
//		•	Navigate to the Contact Us section and send a message. Check form validation.
		homePage.clickContactUsLinkBtn();
		Faker faker = new Faker();
		String validEmail = faker.internet().emailAddress();
		String invalidEml = faker.internet().emailAddress().replace('@', 'e');
		String message = faker.address().fullAddress();
		
		
		contactUsPage.selectHeading("Customer service").enterEmailAddress(invalidEml).typeMessage(message).clickSendBtn();
		contactUsPage.checkinvalidEmailAddErrorMessage();
		contactUsPage.reEnterEmail(validEmail).uploadFileinto("src/test/resources/SpotOnImage.jpg").clickSendBtn();
		
		
	}
}
