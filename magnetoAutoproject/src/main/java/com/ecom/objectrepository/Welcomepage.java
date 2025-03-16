package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcomepage {
	WebDriver driver;
	
	public Welcomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[text()='Admin Login']")
	private WebElement adminLoginlink;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement userloginlink;
	
	@FindBy(linkText  = "Sign Up")
	private WebElement signUplink;
	
	public WebElement getUserloginlink() {
		return userloginlink;
	}
	public WebElement getSignUplink() {
		return signUplink;
	}
	public WebElement getAdminLoginlink() {
		return adminLoginlink;
	}
	
public void launchApplication(String url) {
	driver.get(url);
}

}
