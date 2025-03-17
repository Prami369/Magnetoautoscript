package com.ecom.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ecom.generic.webdriverUtility.WebdriverUtility;

public class AdminLoginpage  extends WebdriverUtility{
	WebDriver driver;

	public AdminLoginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernametxtfield;

	@FindBy(name = "password")
	private WebElement passwordtxtfield;

	@FindBy(name = "enter")
	private WebElement enterbtn;

	public void adminlogin( String username, String adminpassword) throws InterruptedException {
		waitforPageLoad(driver);
		Welcomepage wc = new Welcomepage(driver);
		for(;;) {
			try {
					wc.getAdminLoginlink().click();
					break;
			} catch(Exception e) {
				driver.navigate().to("http://49.249.28.218:8081/AppServer/Online_Shopping_Alphaware/admin/admin_index.php");
				break;
			}
		}
		usernametxtfield.sendKeys(username);
		passwordtxtfield.sendKeys(adminpassword);
		enterbtn.click();
	}

}
