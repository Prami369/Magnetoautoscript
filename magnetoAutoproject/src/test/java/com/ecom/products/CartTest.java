package com.ecom.products;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ecom.basetestutility.Basetest;
import com.ecom.generic.webdriverUtility.UtilityclassObject;
import com.ecom.objectrepository.CartPage;
import com.ecom.objectrepository.Homepage;
import com.ecom.objectrepository.ProdInfopage;
import com.ecom.objectrepository.Productpage;
import com.ecom.objectrepository.Userloginpage;
import com.ecom.objectrepository.Welcomepage;
@Listeners(com.ecom.generic.listenerutility.ListenerImpclass.class)
public class CartTest extends Basetest {

	Userloginpage lg;
	Homepage hm;
	Productpage pd;
	ProdInfopage proIf;
	CartPage cartp ;
	
	@Test (groups ="regression")
	public void toverifycartItemsTest() throws InterruptedException, EncryptedDocumentException, IOException {
		String email = eutil.getDtaFromExcel("Sheet2", 1, 0);
		String password = eutil.getDtaFromExcel("Sheet2", 1, 1);
		String prodname1 =eutil.getDtaFromExcel("sheet4", 1, 0);
		String prodname2 =eutil.getDtaFromExcel("sheet4", 2, 0);
		List<String> neededprodlist = new ArrayList<>( Arrays.asList(prodname1, prodname2));
		
		
		Welcomepage wc = new Welcomepage(driver);
		wc.getUserloginlink().click();
		Thread.sleep(2000);
		System.out.println(UtilityclassObject.getTest());
		UtilityclassObject.getTest().log(Status.PASS, "clicked on user login link");
		lg = new Userloginpage(driver);
		lg.userLogintoAppliaction(email, password);
		UtilityclassObject.getTest().log(Status.PASS, "logged in to user account");
		hm = new Homepage(driver);
		Thread.sleep(1000);
		hm.getProductlink().click();
		UtilityclassObject.getTest().log(Status.PASS, "navigated to product page");
		pd = new Productpage(driver);
		pd.getFootballink().click();
		UtilityclassObject.getTest().log(Status.PASS, "naviagted to football section");
		driver.findElement(By.xpath("//*[contains(text(),'"+prodname1+"')]//img")).click();
		wutil.scrollToelement(driver);
		proIf = new ProdInfopage(driver);
		proIf.getaddtoCartBtn().click();
		UtilityclassObject.getTest().log(Status.PASS, "added "+prodname1+" product to cart");
		hm.getProductlink().click();	
		pd.getFootballink().click();
		driver.findElement(By.xpath("//*[contains(text(),'"+prodname2+"')]//img")).click();
		wutil.scrollToelement(driver);
		proIf.getaddtoCartBtn().click();
		UtilityclassObject.getTest().log(Status.PASS, "added "+prodname2+" product to cart");
		cartp = new CartPage(driver);
		Assert.assertTrue(cartp.getcartItemnamelist().size()==neededprodlist.size());
		Assert.assertTrue(cartp.getcartItemnamelist().equals(neededprodlist));
		UtilityclassObject.getTest().log(Status.PASS, "verified added product list");
		hm.getLogoutlink().click();
		UtilityclassObject.getTest().log(Status.PASS, "logged out from the application");
		
		
	}	
	
		

}
