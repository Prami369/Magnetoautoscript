package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
		WebDriver driver;

		public Accountpage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(name= "edit")
		private WebElement editBtn;

		@FindBy(xpath = "//input[@name='mobile']")
		private WebElement mobiletxtfield;
		
		@FindBy(xpath = "//input[@type='submit']")
		private WebElement savechangesBtn;
		
		public WebElement getEditBtn() {
			return editBtn;
		}

		public WebElement getMobiletxtfield() {
			return mobiletxtfield;
		}

		public WebElement getSavechangesBtn() {
			return savechangesBtn;
		}
}
