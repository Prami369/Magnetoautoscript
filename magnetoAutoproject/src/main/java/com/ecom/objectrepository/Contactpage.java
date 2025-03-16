package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	WebDriver driver;

	public Contactpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	private WebElement emailtxtfield;
	
	@FindBy(xpath = "//textarea[@name='message']")
	private WebElement msgtxtfield;
	
	@FindBy(name = "send")
	private WebElement sendBtn;
	

	public WebElement getSendBtn() {
		return sendBtn;
	}

	public WebElement getEmailtxtfield() {
		return emailtxtfield;
	}

	public WebElement getmsgtxtfield() {
		return msgtxtfield;
	}
	
	
	
}
