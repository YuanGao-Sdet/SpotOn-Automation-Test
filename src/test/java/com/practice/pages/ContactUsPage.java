package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.practice.utils.BrowserUtils;
import com.practice.utils.Driver;

public class ContactUsPage {
	public ContactUsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "id_contact")
	public WebElement selectSubJectHeading;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "fileUpload")
	public WebElement fileUpload;
	
	@FindBy(id = "message")
	public WebElement message;
	
	@FindBy(id = "submitMessage")
	public WebElement submitMsgBtn;
	
	@FindBy(css = "div[class='alert alert-danger'] > ol")
	public WebElement errorMsgEmail;
	
	public ContactUsPage selectHeading(String str) {
		Select select = new Select(selectSubJectHeading);
		select.selectByVisibleText(str);
	
		return this;

	}
	
	public ContactUsPage enterEmailAddress(String emailAdd) {
		email.sendKeys(emailAdd);
		return this;
	}
	
	public boolean checkEmailForm() {
		String xpathEmailText = "//p[starts-with(@class,'form-group')]/label[@for='email'][1]";
		String text = Driver.getDriver().findElement(By.xpath("xpathEmailText")).getAttribute("class");
		
		return text.contains("form-ok");
	}
	
	public ContactUsPage reEnterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
		
		return this;
	}
	
	public ContactUsPage typeMessage(String msg) {
		message.sendKeys(msg);
		return this;
	}
	
	public ContactUsPage clickSendBtn() {
		submitMsgBtn.click();
		
		return this;
	}
	
	public ContactUsPage uploadFileinto(String filePath) {
		BrowserUtils.uploadFile(fileUpload, filePath);
		return this;
	}
	
	public boolean checkinvalidEmailAddErrorMessage() {
		String errorMsg = errorMsgEmail.getText();
		
		return errorMsg.equals("Invalid email address.");
	}
	
	
	
	
	
}
