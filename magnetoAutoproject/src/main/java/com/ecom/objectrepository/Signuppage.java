package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signuppage {
WebDriver driver;
	
	public Signuppage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "firstname")
	private WebElement firstname;
	@FindBy(name = "lastname")
	private WebElement lastname;
	@FindBy(name = "mi")
	private WebElement mnametxtfield;
	@FindBy(name = "mobile")
	private WebElement mobiletxtfield;
	@FindBy(xpath  = "(//input[@name='email'])[2]")
	private WebElement emailtxtfield;
	@FindBy(name = "country")
	private WebElement provinancetxtfield;
	@FindBy(name = "zipcode")
	private WebElement zipcodetxtfield;
	@FindBy(name = "address")
	private WebElement addresstxtfield;
	@FindBy(xpath = "(//input[@name='password'])[2]")
	private WebElement passwordtxtfield;
	@FindBy(xpath  = "//input[@value='Sign Up']")
	private WebElement signupBtn;

	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getMnametxtfield() {
		return mnametxtfield;
	}
	public WebElement getMobiletxtfield() {
		return mobiletxtfield;
	}
	public WebElement getEmailtxtfield() {
		return emailtxtfield;
	}
	public WebElement getProvinancetxtfield() {
		return provinancetxtfield;
	}
	public WebElement getZipcodetxtfield() {
		return zipcodetxtfield;
	}
	public WebElement getAddresstxtfield() {
		return addresstxtfield;
	}
	public WebElement getPasswordtxtfield() {
		return passwordtxtfield;
	}
	public WebElement getSignupBtn() {
		return signupBtn;
	}
	
	
	
	
}
