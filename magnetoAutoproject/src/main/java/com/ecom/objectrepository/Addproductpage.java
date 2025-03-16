package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addproductpage {
	WebDriver driver;

	public Addproductpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name= "product_name")
	private WebElement prodNametxtfield;
	@FindBy(name = "product_price")
	private WebElement prodPriceField;
	@FindBy(name= "product_size")
	private WebElement prodSizetxtfield;
	@FindBy(name= "brand")
	private WebElement prodbrandtxtfield;
	@FindBy(name= "qty")
	private WebElement prodQtytxtfield;
	public WebElement getCloseBtn() {
		return closeBtn;
	}

	@FindBy(xpath = "//input[@type='file']")
	private WebElement prodImgFileuploadField;
	@FindBy(xpath = "//input[@name='add']")
	private WebElement addBtn;
	@FindBy(xpath = "//button[text()='Close']")
	private WebElement closeBtn;
	

	public WebElement getProdNametxtfield() {
		return prodNametxtfield;
	}
	public WebElement getprodPriceField() {
		return prodPriceField;
	}
	public WebElement getProdSizetxtfield() {
		return prodSizetxtfield;
	}
	public WebElement getProdbrandtxtfield() {
		return prodbrandtxtfield;
	}
	public WebElement getProdQtytxtfield() {
		return prodQtytxtfield;
	}
	public WebElement getProdImgFileuploadField() {
		return prodImgFileuploadField;
	}
	public WebElement getAddBtn() {
		return addBtn;
	}

	
	
	
}
