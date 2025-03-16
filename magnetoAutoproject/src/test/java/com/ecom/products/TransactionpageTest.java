package com.ecom.products;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.basetestutility.Basetest;
import com.ecom.objectrepository.AdminHomepage;
import com.ecom.objectrepository.AdminLoginpage;
import com.ecom.objectrepository.Welcomepage;

public class TransactionpageTest extends Basetest{

	@Test(groups="smoke")
	public void tocheckNavigationToTransactionpageTest() {
		Welcomepage wc = new Welcomepage(driver);
		wc.getAdminLoginlink().click();
		AdminLoginpage lpp = new AdminLoginpage(driver);
		lpp.adminlogin(username, pwd);		
		AdminHomepage adhome = new AdminHomepage(driver);
		adhome.getTransactionlink().click();
		Assert.assertEquals(driver.getCurrentUrl().contains("transaction"), true);
	}
}
