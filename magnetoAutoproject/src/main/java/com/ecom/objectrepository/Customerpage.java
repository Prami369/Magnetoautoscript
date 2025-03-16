package com.ecom.objectrepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerpage {
WebDriver driver;
	
	public Customerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//tr[@class='visible']/td[7]")
	private List<WebElement> useremaillist ;
	
	@FindBy(xpath ="//tr[@class='visible']/td[5]")
	private List<WebElement> userMobnumlist ;
	
	public List<WebElement> getUsernamelist() {
		return useremaillist;
	}
	public List<WebElement> getUserMobnumlist() {
		return userMobnumlist;
	}
	
	public List<String> getlistOf_usermobnum() {
		List<String> mobnumlist = new ArrayList<>();
		for(WebElement mobnum: userMobnumlist) {
			mobnumlist.add(mobnum.getText());
		}return mobnumlist;
	}
	
	public List<String> getlistOf_useremail() {
		List<String> emaillist = new ArrayList<>();
		for(WebElement name: useremaillist) {
			emaillist.add(name.getText());
		}return emaillist;
	}

	
	
	
}
