package com.practice.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utils.BrowserUtils;
import com.practice.utils.Driver;


public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "search_query_top")
	public WebElement search;
	
	@FindBy(name = "submit_search")
	public WebElement search_button;
	
	@FindBy(css = "a[title='Best sellers']")
	public WebElement bestSellersLinkBtn;

	@FindBy(linkText = "Contact us")
	public WebElement contactUsLinkBtn;
	
	public void searchItem(String item) {
		search.sendKeys(item);
		search_button.click();
	}
	
	public void clickBestSellersLinkBtn() {
		BrowserUtils.waitForClickablility(bestSellersLinkBtn, 10);
		bestSellersLinkBtn.click();
	}
	
	public void clickContactUsLinkBtn() {
		contactUsLinkBtn.click();
	}
}







