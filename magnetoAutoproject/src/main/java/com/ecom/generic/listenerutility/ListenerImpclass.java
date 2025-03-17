package com.ecom.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.basetestutility.Basetest;
import com.ecom.generic.webdriverUtility.UtilityclassObject;

public class ListenerImpclass  implements ITestListener, ISuiteListener{
	public ExtentReports report;
	public static ExtentTest test;
	String timestamp= new Date().toString().replace(":", "_").replace(" ", "_");

	@Override
	public void onTestStart(ITestResult result) {	
//		UtilityclassObject.setTest(test);
		test =report.createTest(result.getMethod().getMethodName()+"========started");
		System.out.println("tesr:"+test);
		UtilityclassObject.setTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"=======completed");
		
	}
//	@Override
//	public void onStart(ITestContext context) {
//		context.getClass();
//
//	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("report backup");
	}

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter	 spark = new ExtentSparkReporter("./advanceReports/report"+timestamp+".html");
			spark.config().setDocumentTitle("magneto test suit result");
			spark.config().setReportName("magneto report");	
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "window-10");
			report.setSystemInfo("browser", "chrome-10");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname= result.getMethod().getMethodName();		
		TakesScreenshot edriver =  (TakesScreenshot)Basetest.sdriver;
		 String filepath=edriver.getScreenshotAs(OutputType.BASE64);	 
		test.addScreenCaptureFromBase64String(filepath, methodname+timestamp);
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=======failed");		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"========skipped");
		
	}
	
	

}
