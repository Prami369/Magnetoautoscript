package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Userloginpage {
WebDriver driver;
	
	public Userloginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "email")
	private WebElement emailtxtfield;
	
	@FindBy(name = "password")
	private WebElement passwordtxtField;
	
	@FindBy(xpath = "//input[@name='login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement logincloseBtn;

	
	public void userLogintoAppliaction(String email, String password) throws InterruptedException {
		Thread.sleep(1000);
		emailtxtfield.sendKeys(email);
		passwordtxtField.sendKeys(password);
		
		loginBtn.click();		
	}

}
