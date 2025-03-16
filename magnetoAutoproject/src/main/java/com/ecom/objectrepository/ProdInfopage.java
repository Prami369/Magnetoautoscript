package com.ecom.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdInfopage {
	
WebDriver driver;
	
	public ProdInfopage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getaddtoCartBtn() {
		return addtoCartBtn;
	}

	@FindBy(xpath ="//input[@value='Add to Cart']")
	private WebElement addtoCartBtn;
	
	//tr[@class='table']/td[2]//h4
}
