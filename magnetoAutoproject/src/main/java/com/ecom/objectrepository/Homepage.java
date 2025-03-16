package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//a[@href='#profile']") 
	private WebElement Accname;
	
	public WebElement getAccname() {
		return Accname;
	}
	@FindBy(name="username")
	private WebElement usernametxtfield;
	
	@FindBy(name="password")
	private WebElement passwordtxtfield;
	
	@FindBy(xpath="//a[text()='Product']")
	private WebElement productlink;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactuslink;
	
	@FindBy(xpath="//a[text()='logout']")
	private WebElement logoutlink;
	
	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getContactuslink() {
		return contactuslink;
	}

	public WebElement getUsernametxtfield() {
		return usernametxtfield;
	}

	public WebElement getPasswordtxtfield() {
		return passwordtxtfield;
	}

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getHomelink() {
		return homelink;
	}

	@FindBy(xpath="//a[text()='Home']")
	private WebElement homelink;
	


}
