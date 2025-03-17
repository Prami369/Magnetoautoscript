package com.ecom.products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.basetestutility.Basetest;
import com.ecom.objectrepository.Addproductpage;
import com.ecom.objectrepository.AdminHomepage;
import com.ecom.objectrepository.AdminLoginpage;
import com.ecom.objectrepository.Homepage;
import com.ecom.objectrepository.ProdStockpage;
import com.ecom.objectrepository.Productpage;
import com.ecom.objectrepository.Welcomepage;

public class ProductstockTest extends Basetest{
	Welcomepage wc;
	Homepage hm;
	Productpage pd;
	AdminLoginpage lp;
	AdminHomepage adhome;
	ProdStockpage prodstockpage;
	Addproductpage addprodpage;

	@Test(groups="smoke")
	public void tocheckNavigationToProductspagepageTest() throws InterruptedException {
		wc = new Welcomepage(driver);

		AdminLoginpage lpp = new AdminLoginpage(driver);
		lpp.adminlogin(username, pwd);		
		AdminHomepage adhome = new AdminHomepage(driver);
		wutil.moveToElement(driver, adhome.getProductslink());
		adhome.getFeaturelink().click();
		Assert.assertEquals(driver.getCurrentUrl().contains("feature"), true);	
		adhome.adminlogout();
	}
	
	@Test
	public void tocheckAddingProdtoStockTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String prodname =eutil.getDtaFromExcel("sheet1", 2, 0);
		String prodprice =eutil.getDtaFromExcel("sheet1", 2, 1);
		String prodbrand =eutil.getDtaFromExcel("sheet1", 2, 2);
		String prodsize =eutil.getDtaFromExcel("sheet1", 2, 3);		
		String prodQty =eutil.getDtaFromExcel("sheet1", 2, 4);
		String prodimglink =eutil.getDtaFromExcel("sheet1", 2, 5);
		
		wc = new Welcomepage(driver);
		wc.getAdminLoginlink().click();
		lp = new AdminLoginpage(driver);
		lp.adminlogin(username, pwd);
		adhome = new AdminHomepage(driver);
		wutil.moveToElement(driver, adhome.getProductslink());
		adhome.getRunninglink().click();
		prodstockpage = new ProdStockpage(driver);
		prodstockpage.getProductAddBtn().click();
		addprodpage = new Addproductpage(driver);
		addprodpage.getProdNametxtfield().sendKeys(prodname);
		addprodpage.getprodPriceField().sendKeys(prodprice);
		addprodpage.getProdbrandtxtfield().sendKeys(prodbrand);
		addprodpage.getProdSizetxtfield().sendKeys(prodsize);
		addprodpage.getProdQtytxtfield().sendKeys(prodQty);
		addprodpage.getProdImgFileuploadField().sendKeys(prodimglink);
		addprodpage.getAddBtn().click();
		
		wutil.WaitforElementToBePresent(driver,prodstockpage.getProductAddBtn(), 2);
		adhome.adminlogout();
		hm = new Homepage(driver);
		
		while(true) {
		try {					
			hm.getProductlink().click();
			break;
		}catch(Throwable e) {
			driver.navigate().back();
		}	
		}
		
		pd = new Productpage(driver);
		pd.getRunninglink().click();	
		Thread.sleep(1000);
		Assert.assertEquals(pd.getprodnamelist_fromUserAcc().contains(prodname), true);
	}
	
	@Test
	public void tocheckAddingProdtoBasketballCategoryTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String prodname =eutil.getDtaFromExcel("sheet1", 3, 0);
		String prodprice =eutil.getDtaFromExcel("sheet1", 3, 1);
		String prodbrand =eutil.getDtaFromExcel("sheet1", 3, 2);
		String prodsize =eutil.getDtaFromExcel("sheet1", 3, 3);		
		String prodQty =eutil.getDtaFromExcel("sheet1", 3, 4);
		String prodimglink =eutil.getDtaFromExcel("sheet1", 3, 5);
		
		wc = new Welcomepage(driver);
		wc.getAdminLoginlink().click();
		lp = new AdminLoginpage(driver);
		lp.adminlogin(username, pwd);
		adhome = new AdminHomepage(driver);
		wutil.moveToElement(driver, adhome.getProductslink());
		adhome.getBasketballlink().click();
		prodstockpage = new ProdStockpage(driver);
		prodstockpage.getProductAddBtn().click();
		addprodpage = new Addproductpage(driver);
		addprodpage.getProdNametxtfield().sendKeys(prodname);
		addprodpage.getprodPriceField().sendKeys(prodprice);
		addprodpage.getProdbrandtxtfield().sendKeys(prodbrand);
		addprodpage.getProdSizetxtfield().sendKeys(prodsize);
		addprodpage.getProdQtytxtfield().sendKeys(prodQty);
		addprodpage.getProdImgFileuploadField().sendKeys(prodimglink);
		addprodpage.getAddBtn().click();
		Thread.sleep(2000);
		Assert.assertEquals(prodstockpage.getprodnameList_FromadminAcc().contains(prodname), true);
		
		}
	

	
}
