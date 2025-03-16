package com.ecom.basetestutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.ecom.generic.databaseUtility.DatabaseUtility;
import com.ecom.generic.fileUtility.ExcelUtility;
import com.ecom.generic.fileUtility.PropFileutility;
import com.ecom.generic.webdriverUtility.JavaUtility;
import com.ecom.generic.webdriverUtility.UtilityclassObject;
import com.ecom.generic.webdriverUtility.WebdriverUtility;
import com.ecom.objectrepository.AdminLoginpage;
import com.ecom.objectrepository.Welcomepage;



public class Basetest {
	public WebDriver driver = null;
	public static WebDriver sdriver;
	public ExcelUtility eutil = new ExcelUtility();
	public JavaUtility jutil = new JavaUtility();
	public PropFileutility putil = new PropFileutility();
	public WebdriverUtility wutil = new WebdriverUtility();
	public DatabaseUtility dutil = new DatabaseUtility();
//	public static ExtentReports report;

public String username;
public String pwd;

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		String url = putil.getDataFromPropertyfile("url");
		username = putil.getDataFromPropertyfile("username");
		pwd = putil.getDataFromPropertyfile("password");
		Welcomepage wc = new Welcomepage(driver);
		wc.launchApplication(url);

	}

//	@AfterMethod 
//	public void configAM() {
//		
//	}
	
	@Parameters("browser")
	@BeforeClass (alwaysRun = true)
	public void configBC(@Optional("chrome") String browser) throws IOException {
//		String Browsername = putil.getDataFromPropertyfile("browser");
		String Browsername =browser;
		if(Browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(Browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(Browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}	
		
		sdriver=driver;
		UtilityclassObject.setDriver(driver);
		driver.manage().window().maximize();	

	}

	@AfterClass (alwaysRun = true)
	public void configAC() {
		driver.quit();
	}

	@BeforeSuite (alwaysRun = true)
	public void configAS() throws SQLException {
//		dutil.getconnectionToDB();
		System.out.println("DB connection done");
	
	}
	
	@AfterSuite (alwaysRun = true)
	public void configBS() throws SQLException {
//		dutil.closeDBConnection();
		System.out.println("DB connection closed");
//		report.flush();
	}

	
}
