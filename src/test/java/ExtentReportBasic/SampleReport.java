package ExtentReportBasic;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
@Test
public void Sample() {
	//create the extent spark reporter
	ExtentSparkReporter spark=new ExtentSparkReporter(".\\Extent_report\\sampleReport.html");
	//configure extent spark reporter
	spark.config().setDocumentTitle("functional testing");
	spark.config().setReportName("Manikandan");
	spark.config().setTheme(Theme.DARK);
	//create the extent report
	ExtentReports report=new ExtentReports();
	report.setSystemInfo("os", "window-11");
	report.setSystemInfo("browser", "chrome-101");
	//attach the spark report to the extent report
	report.attachReporter(spark);
	//create the testScript
	ExtentTest test = report.createTest("Sample");
	report.flush();
	
}
}
