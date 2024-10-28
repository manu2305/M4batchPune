package com.crm.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DwsBase {
	public static WebDriver driver;
@BeforeClass
public void precondition() {
	//open the browser
	    driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//waiting condition
		driver.manage().window().maximize();
		//enter into dws
		driver.get("https://demowebshop.tricentis.com/");
}
@BeforeMethod
public void login() {
	Reporter.log("login",true);
	}
@AfterMethod
public void logOut() {
	Reporter.log("logOut",true);
	}
@AfterClass
public void postCondition() {
	driver.quit();
	}
}
