package com.ecom.objectrepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdStockpage {
	WebDriver driver;

	public ProdStockpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//tr[contains(@class,'visible')]//td[2]")
	private List<WebElement> productlist;
	
	@FindBy(xpath = "//a[text()='Add Product']")
	private WebElement productAddBtn;
	
	@FindBy(xpath = "//a[text()=' Stock In']")
	private WebElement stockInBtn;
	
	@FindBy(xpath = "//a[text()=' Stock Out']")
	private WebElement stockOutBtn;
	
	public List<String> getprodnameList_FromadminAcc() {
		List<String> prodnamelist = new ArrayList<>() ;
		for(WebElement ele: productlist) {
			prodnamelist.add(ele.getText());
		}
		System.out.println(productlist.size());
		System.out.println("name: "+prodnamelist.size());
		return prodnamelist;
	}
	
	public WebElement getProductAddBtn() {
		return productAddBtn;
	}

	public WebElement getStockInBtn() {
		return stockInBtn;
	}

	public WebElement getStockOutBtn() {
		return stockOutBtn;
	}

	public List<WebElement> getProductnamelist() {
		return productlist;
	}

	

	
}
