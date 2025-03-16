package com.ecom.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stockoutpage {
	
WebDriver driver;
	
	public Stockoutpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="new_stck")
	private WebElement stocknumtxtfield;
	
	@FindBy(xpath ="//button[@name='stockout']")
	private WebElement saveBtn;
	
	
}
