package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage {
	WebDriver driver;

	public AdminHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath = "//a[text()='logout']")
//	private WebElement logoutlink;

	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dashboardlink;

	@FindBy(xpath = "//a[text()='Messages']")
	private WebElement messageslink;

	@FindBy(xpath = "//a[text()='Transactions']")
	private WebElement transactionlink;

	@FindBy(xpath = "//a[text()='Customers']")
	private WebElement customerlink;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productslink;

	@FindBy(xpath = "//a[text()='Orders']")
	private WebElement orderlink;
	
	@FindBy(xpath = "//a[text()='Features']")
	private WebElement featurelink;
	@FindBy(xpath = "//a[text()='Football']")
	private WebElement footballlink;
	@FindBy(xpath = "//a[text()='Running']")
	private WebElement runninglink;
	@FindBy(xpath = "//a[text()='Basketball']")
	private WebElement basketballlink;

	@FindBy(linkText = "logout")
	private WebElement logoutBtn;

	
	public void adminlogout() {
		logoutBtn.click();
	}
	public WebElement getFeaturelink() {
		return featurelink;
	}
	public WebElement getFootballlink() {
		return footballlink;
	}
	public WebElement getRunninglink() {
		return runninglink;
	}
	public WebElement getBasketballlink() {
		return basketballlink;
	}
	public WebElement getDashboardlink() {
		return dashboardlink;
	}
	public WebElement getMessageslink() {
		return messageslink;
	}
	public WebElement getTransactionlink() {
		return transactionlink;
	}
	public WebElement getCustomerlink() {
		return customerlink;
	}
	public WebElement getProductslink() {
		return productslink;
	}
	public WebElement getOrderlink() {
		return orderlink;
	}
	
	

}
