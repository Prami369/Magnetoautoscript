package com.ecom.products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.basetestutility.Basetest;
import com.ecom.objectrepository.AdminHomepage;
import com.ecom.objectrepository.AdminLoginpage;
import com.ecom.objectrepository.Contactpage;
import com.ecom.objectrepository.Homepage;
import com.ecom.objectrepository.Messagespage;
import com.ecom.objectrepository.Userloginpage;
import com.ecom.objectrepository.Welcomepage;

public class MessagesTest extends Basetest{
	
	@Test (groups ="regression")
	public void toverifyMessagesTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String email = eutil.getDtaFromExcel("Sheet2", 1, 0);
		String password = eutil.getDtaFromExcel("Sheet2", 1, 1);
		String msg= eutil.getDtaFromExcel("Sheet2", 1, 2);
		
		Homepage hm = new Homepage(driver);		
		Welcomepage wc = new Welcomepage(driver);
		wc.getUserloginlink().click();
		Userloginpage lg = new Userloginpage(driver);
		lg.userLogintoAppliaction(email, password);
		Thread.sleep(1000);
		hm.getContactuslink().click();	
		Contactpage cp = new Contactpage(driver);
		
		wutil.scrollToelement(driver);	
		cp.getmsgtxtfield().sendKeys(msg);
		cp.getSendBtn().click();
		Thread.sleep(1000);
		hm.getLogoutlink().click();
		wc.getAdminLoginlink().click();
		AdminLoginpage lp = new AdminLoginpage(driver);
		lp.adminlogin(username, pwd);
		AdminHomepage adhome = new AdminHomepage(driver);
		adhome.getMessageslink().click();	
		Messagespage mspage = new Messagespage(driver);
		System.out.println(mspage.gettextmsglist().contains(msg));
		
		Assert.assertEquals(mspage.gettextmsglist().contains(msg), true);	
		adhome.adminlogout();
		
		
	}
}
