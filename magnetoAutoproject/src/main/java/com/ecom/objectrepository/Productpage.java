package com.ecom.objectrepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	WebDriver driver;

	public Productpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Football")
	private WebElement footballink;
	

	@FindBy(linkText = "Running")
	private WebElement runninglink;
	@FindBy(linkText = "Basketball")
	private WebElement basketballink;	
	@FindBy(xpath  = "//center[contains(text(),' ')]")
	private List<WebElement> prodinfolist;
	
	public List<String> getprodnamelist_fromUserAcc() {
		List<String> prodnamelist = new ArrayList<>();
		for(WebElement ele: prodinfolist) {
			prodnamelist.add(ele.getText().split("P ")[0].trim());
			
		}return prodnamelist;
	}
	
	public WebElement getRunninglink() {
		return runninglink;
	}
	public WebElement getBasketballink() {
		return basketballink;
	}
	public List<WebElement> getProdinfolist() {
		return prodinfolist;
	}

	public WebElement getFootballink() {
		return footballink;
	}

}
