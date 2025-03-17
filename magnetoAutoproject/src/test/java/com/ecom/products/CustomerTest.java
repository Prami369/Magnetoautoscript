package com.ecom.products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ecom.basetestutility.Basetest;
import com.ecom.generic.webdriverUtility.UtilityclassObject;
import com.ecom.objectrepository.Accountpage;
import com.ecom.objectrepository.AdminHomepage;
import com.ecom.objectrepository.AdminLoginpage;
import com.ecom.objectrepository.Customerpage;
import com.ecom.objectrepository.Homepage;
import com.ecom.objectrepository.Signuppage;
import com.ecom.objectrepository.Userloginpage;
import com.ecom.objectrepository.Welcomepage;

public class CustomerTest extends Basetest{
	
	@Test(groups="smoke")
	public void tocheckNavigationToProductspagepageTest() throws InterruptedException {
		
		Welcomepage wc = new Welcomepage(driver);
		wc.getAdminLoginlink().click();	
		AdminLoginpage lpp = new AdminLoginpage(driver);
		lpp.adminlogin(username, pwd);		
		AdminHomepage adhome = new AdminHomepage(driver);
		adhome.getCustomerlink().click();
		Assert.assertEquals(driver.getCurrentUrl().contains("customer"), true);			
	}
	
	@Test 
	public void toverifyCustomerpageTest() throws EncryptedDocumentException, IOException, InterruptedException {
	String firstname = eutil.getDtaFromExcel("Sheet3", 5, 0);
	String lastname = eutil.getDtaFromExcel("Sheet3", 5, 1);
	String midname = eutil.getDtaFromExcel("Sheet3", 5, 2);
	String mobnum = eutil.getDtaFromExcel("Sheet3", 5, 3);
	String address = eutil.getDtaFromExcel("Sheet3", 5, 4);
	String provi = eutil.getDtaFromExcel("Sheet3", 5, 5);
	String email = eutil.getDtaFromExcel("Sheet3", 5, 6);
	String zipcode = eutil.getDtaFromExcel("Sheet3", 5, 7);
	String password = eutil.getDtaFromExcel("Sheet3", 5, 8);
		
	Welcomepage wc = new Welcomepage(driver);
	wc.getSignUplink().click();
	Signuppage sp = new Signuppage(driver);
	Thread.sleep(2000);
//	wutil.WaitforElementToBePresent(driver, sp.getFirstname(), 2);
	sp.getFirstname().sendKeys(firstname);
	sp.getLastname().sendKeys(lastname);
	sp.getMnametxtfield().sendKeys(midname);
	Thread.sleep(1000);
	sp.getProvinancetxtfield().sendKeys(provi);
	sp.getZipcodetxtfield().sendKeys(zipcode);
	sp.getMobiletxtfield().sendKeys(mobnum);
	sp.getAddresstxtfield().sendKeys(address);
	sp.getPasswordtxtfield().sendKeys(password);
	sp.getEmailtxtfield().sendKeys(email);
	sp.getSignupBtn().click();
	Thread.sleep(1000);
	wutil.WaitforElementToBePresent(driver, wc.getAdminLoginlink(), 1);
	wc.getAdminLoginlink().click();
	

	AdminLoginpage lpp = new AdminLoginpage(driver);
	lpp.adminlogin(username, pwd);
	
	AdminHomepage adhome = new AdminHomepage(driver);
	adhome.getCustomerlink().click();
	Customerpage cp = new Customerpage(driver);
	System.out.println(cp.getlistOf_usermobnum().contains(mobnum));
	Assert.assertEquals(cp.getlistOf_useremail().contains(email), true);	
	adhome.adminlogout();
}
	
	@Test
	public void TocheckupdatedCustomerInfoTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String altmobnum = eutil.getDtaFromExcel("Sheet3", 1, 9);		
		String email = eutil.getDtaFromExcel("Sheet3", 1, 6);
		String password = eutil.getDtaFromExcel("Sheet3", 1, 8);
		
		Welcomepage wc = new Welcomepage(driver);
		wc.getUserloginlink().click();
		Userloginpage lg = new Userloginpage(driver);
		lg.userLogintoAppliaction(email, password);
		Homepage hm = new Homepage(driver);
		hm.getAccname().click();           
		Accountpage accpg = new Accountpage(driver);
		Thread.sleep(1000);
		accpg.getEditBtn().click();
		accpg.getMobiletxtfield().clear();
		accpg.getMobiletxtfield().sendKeys(altmobnum);
		accpg.getSavechangesBtn().click();
		Thread.sleep(1000);
		hm.getLogoutlink().click();
		wc.getAdminLoginlink().click();

		AdminLoginpage lpp = new AdminLoginpage(driver);
		lpp.adminlogin(username, pwd);
		AdminHomepage adhome = new AdminHomepage(driver);
		adhome.getCustomerlink().click();
		Customerpage cp = new Customerpage(driver);
		System.out.println(cp.getlistOf_usermobnum().contains(altmobnum));
		Assert.assertTrue(cp.getlistOf_usermobnum().contains(altmobnum));
		adhome.adminlogout();
	}
	
	@Test
	public void endToend_toverifyCustomerInfoTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String firstname = eutil.getDtaFromExcel("Sheet3", 4, 0);
		String lastname = eutil.getDtaFromExcel("Sheet3", 4, 1);
		String midname = eutil.getDtaFromExcel("Sheet3", 4, 2);
		String mobnum = eutil.getDtaFromExcel("Sheet3", 4, 3);
		String address = eutil.getDtaFromExcel("Sheet3", 4, 4);
		String provi = eutil.getDtaFromExcel("Sheet3", 4, 5);
		String email = eutil.getDtaFromExcel("Sheet3", 4, 6);
		String zipcode = eutil.getDtaFromExcel("Sheet3", 4, 7);
		String password = eutil.getDtaFromExcel("Sheet3", 4, 8);	
		String altmobnum = eutil.getDtaFromExcel("Sheet3", 4, 9);		
	
		
		Userloginpage lg = new Userloginpage(driver);				
		Welcomepage wc = new Welcomepage(driver);
		wc.getSignUplink().click();
		Signuppage sp = new Signuppage(driver);
		wutil.WaitforElementToBePresent(driver, sp.getFirstname(), 2);
		sp.getFirstname().sendKeys(firstname);
		sp.getLastname().sendKeys(lastname);
		sp.getMnametxtfield().sendKeys(midname);
		wutil.WaitforElementToBePresent(driver, sp.getProvinancetxtfield(), 2);		
		sp.getProvinancetxtfield().sendKeys(provi);
		sp.getZipcodetxtfield().sendKeys(zipcode);
		sp.getMobiletxtfield().sendKeys(mobnum);
		sp.getAddresstxtfield().sendKeys(address);
		sp.getPasswordtxtfield().sendKeys(password);
		sp.getEmailtxtfield().sendKeys(email);
		sp.getSignupBtn().click();
		wc.getAdminLoginlink().click();
		AdminLoginpage lpp = new AdminLoginpage(driver);
		lpp.adminlogin(username, pwd);	
		AdminHomepage adhome = new AdminHomepage(driver);
		adhome.getCustomerlink().click();
		Customerpage cp = new Customerpage(driver);
		Assert.assertEquals(cp.getlistOf_useremail().contains(email), true);
		adhome.adminlogout();
		Homepage hm = new Homepage(driver);
		while(true) {
			try {					
				hm.getProductlink().click();
				break;
			}catch(Throwable e) {
				driver.navigate().back();
			}	
			}
		
		
		Thread.sleep(1000);	
		wc.getUserloginlink().click();
		Thread.sleep(1000);
		lg.userLogintoAppliaction(email, password);	
		hm.getAccname().click();           
		Accountpage accpg = new Accountpage(driver);
		Thread.sleep(1000);
		accpg.getEditBtn().click();
		accpg.getMobiletxtfield().clear();
		accpg.getMobiletxtfield().sendKeys(altmobnum);
		accpg.getSavechangesBtn().click();
		hm.getLogoutlink().click();
		wc.getAdminLoginlink().click();

		lpp.adminlogin(username, pwd);
		adhome.getCustomerlink().click();
		System.out.println(cp.getlistOf_usermobnum().contains(altmobnum));
		Assert.assertTrue(cp.getlistOf_usermobnum().contains(altmobnum));
		adhome.adminlogout();
	}
}