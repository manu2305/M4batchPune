package ExtentReportBasic;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;

public class Testing1 extends DwsBase{
@Test
public void main1() {
//	driver.get("https://www.redbus.in/");
//	driver.navigate().back();
	Reporter.log("iam the main1",true);
	assertEquals("mobile","mobil");
	
}
}
