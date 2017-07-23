package reportFactory;

import java.io.File;

import org.testng.ITestContext;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportCore {
		
		static ExtentReports extent;
		static String reportPath = System.getProperty("user.dir") + "/src/test/reports/";
		
		public  synchronized static ExtentReports getReporter(String suiteName){
				if (extent == null){
					extent = new ExtentReports(reportPath + suiteName +".html", true);
					extent.addSystemInfo("UserName", "Pawan K Dola");
					extent.addSystemInfo("Platform", "Windows 10");
					extent.loadConfig(new File(reportPath+"ExtentConfig.xml"));
				}
				return extent;
		}

}
