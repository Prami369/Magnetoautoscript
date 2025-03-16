package com.ecom.objectrepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//tr[@class='table']/td[2]//h4")
	private List<WebElement> namelist;
	
	public List<String> getcartItemnamelist() {
		List<String> prodnamelist = new ArrayList<>();
		for(WebElement name: namelist) {
			prodnamelist.add(name.getText());
		}return prodnamelist;
	}
	
	
}
