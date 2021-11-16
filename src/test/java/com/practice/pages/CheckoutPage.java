package com.practice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utils.BrowserUtils;
import com.practice.utils.Driver;

public class CheckoutPage {
	public CheckoutPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(css = "a[title='Add']")
	public WebElement addItemBtn;
	
	@FindBy(name = "quantity_1_1_0_0")
	public WebElement quantity;
	
	@FindBy(css = "a[title='Subtract']")
	public WebElement subTractItemBtn;
	
	@FindBy(css = "a[title='Delete']")
	public WebElement deleteItemBtn;
	
	
	public void addOrSubtractItems(int targetItem) {
		int count= Integer.valueOf(quantity.getAttribute("value"));
		if(targetItem>count) {
			for (int i = count; i <targetItem; i++) {
				addItemBtn.click();
				BrowserUtils.waitForPageToLoad(15);
			}
		}else if(targetItem<count) {
			for (int i = count; i > targetItem; i--) {
				subTractItemBtn.click();
				BrowserUtils.waitForPageToLoad(15);
			}
		}
		
	}
	
	public void deleteAllItems() {
		BrowserUtils.waitForClickablility(deleteItemBtn, 10);
		deleteItemBtn.click();
	}
}
