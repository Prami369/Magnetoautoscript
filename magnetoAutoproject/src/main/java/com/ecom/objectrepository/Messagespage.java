package com.ecom.objectrepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Messagespage {
	
WebDriver driver;
	
	public Messagespage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//tr[@class='visible']/td[2]")
	private List<WebElement> txtmessagelist;
	
	
	
	public List<String> gettextmsglist() {
		List<String> msglist = new ArrayList<>();
		for(WebElement msg: txtmessagelist) {
			msglist.add(msg.getText());
		} return msglist;
	}
}
