package com.practice.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.practice.utils.BrowserUtils;
import com.practice.utils.Driver;


public class SearchResultsPage {
	public SearchResultsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(css = ".product-container img")
	public WebElement item_img;
	
	@FindBy(css = "a[title='Add to cart']")
	public WebElement add_to_cart_button;

	@FindBy(id = "selectProductSort")
	public WebElement sortByElement;
	
	@FindBy(css = "a[title='Proceed to checkout']")
	public WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath = "(//ul[@class='product_list grid row']/li//div[@class='right-block']//span[@class='price product-price'])")
	public List<WebElement> allItemPrices;
	
	
	public boolean checkItemPriceHightToLow() {
		List<Double> allPrices = new ArrayList<Double>();
		for (WebElement ele : allItemPrices) {
			allPrices.add(Double.valueOf(ele.getText().substring(1)));
		}
		
		List<Double> sortPrices = allPrices;
		Collections.sort(sortPrices);
		
		return allPrices.equals(sortPrices);
		
		
	}
	public void sortByText(String text) {
		Select select = new Select(sortByElement);
		select.selectByValue(text);
	}
	
	public void addItemToCart() {
		BrowserUtils.hover(item_img);
		add_to_cart_button.click();
		BrowserUtils.waitForClickablility(proceedToCheckoutBtn, 10);
		proceedToCheckoutBtn.click();
	}
	

}
