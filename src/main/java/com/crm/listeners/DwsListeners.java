package com.crm.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.DwsBase;

public class DwsListeners extends DwsBase implements ITestListener  {
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test ;

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		 test.log(Status.PASS,"assertion is Success");
		 test.log(Status.INFO,name+"is Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		
		
		test.log(Status.FAIL,"assertion is Failed");
		test.log(Status.INFO,name+"is Failed");
	}

	
	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP,"assertion is Skipped");
		test.log(Status.INFO,name+"is Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		spark=new ExtentSparkReporter(".\\Extent_report\\ExtentReportTrail.html");
		//configure extent spark reporter
		spark.config().setDocumentTitle("functional testing");
		spark.config().setReportName("Manikandan");
		spark.config().setTheme(Theme.DARK);
		//create the extent report
	    report=new ExtentReports();
		report.setSystemInfo("os", "window-11");
		report.setSystemInfo("browser", "chrome-101");
		//attach the spark report to the extent report
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
