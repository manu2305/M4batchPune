package ExtentReportBasic;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.DwsBase;

public class Testing2 extends DwsBase{
@Test
public void main2() {
	Reporter.log("iam the main2",true);
	assertEquals("thor","Thar");
}
}
