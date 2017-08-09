package com.practice.yourLogo.reportFactory;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportCore {
		
		static ExtentReports extent;
		static String reportPath = System.getProperty("user.dir") + "/src/main/java/com/practice/yourLogo/reportFactory/";
//		static String reportPath = System.getProperty("user.dir") + "/src/test/reports/reportFactory/";
		
		public  synchronized static ExtentReports getReporter(String suiteName){
				if (extent == null){
					extent = new ExtentReports(reportPath + suiteName +".html", true);
//					extent.addSystemInfo("UserName", "Pawan K Dola");
//					extent.addSystemInfo("Platform", "Windows 10");
					extent.loadConfig(new File(reportPath+"ExtentConfig.xml"));
				}
				return extent;
		}

}
