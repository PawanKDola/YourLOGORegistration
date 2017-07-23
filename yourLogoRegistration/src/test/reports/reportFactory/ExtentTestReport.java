package reportFactory;

import java.util.HashMap;

import org.testng.ITestContext;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestReport {
			
			public static HashMap<Long,ExtentTest> extRpts = new HashMap<Long,ExtentTest>();
			
			public static ExtentReports extentRpt;
			public static ExtentTest extentTst;
			
			public synchronized static void setReporter(String suiteName, String testName){
								
						extentRpt = ExtentReportCore.getReporter(suiteName);
						extentTst = extentRpt.startTest(testName);
						extRpts.put(Thread.currentThread().getId(),extentTst);
				
			}
			
			public synchronized static ExtentTest getReporter(){
						
						return extRpts.get(Thread.currentThread().getId());
						
			}
			
			
}
