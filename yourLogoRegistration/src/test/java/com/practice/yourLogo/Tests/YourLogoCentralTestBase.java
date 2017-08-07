package com.practice.yourLogo.Tests;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.IBeforeMethod;

import com.practice.yourLogo.Pages.YourLogoCommOps;
import com.practice.yourLogo.Pages.YourLogoRegistrationPage;
import com.practice.yourLogo.Pages.YourLogoSignInPage;
import com.practice.yourLogo.reportFactory.ExtentReportCore;
import com.practice.yourLogo.reportFactory.ExtentTestReport;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class YourLogoCentralTestBase extends YourLogoTestBase {

	
	public YourLogoCommOps ylCommOps;
	public YourLogoSignInPage ylSignInPg;
	public YourLogoRegistrationPage ylRegPg;
		
	@BeforeClass
	@Parameters({"idCol"})
	public void instantiatePageObjects(String idCol){
			
			ylCommOps = new YourLogoCommOps(idCol);
			ylSignInPg = new YourLogoSignInPage(driver);
			ylRegPg = new YourLogoRegistrationPage(driver);
	}
	
	@BeforeMethod
	public void initExtentRptMthdDtls(ITestContext testDtls){
			
			String suiteName = testDtls.getCurrentXmlTest().getSuite().getName();
			String testName = "Test Report " + testDtls.getCurrentXmlTest().getName();
			ExtentTestReport.setReporter(suiteName, testName);
			
	}

	@AfterMethod
	public void afterExtentRptMthdDtls(ITestResult result){
		
			if(result.getStatus()==ITestResult.SUCCESS)
			{
//					ExtentTestReport.extRpts.get(Thread.currentThread().getId()).log(LogStatus.PASS, result.getTestContext().getCurrentXmlTest().getName(), "Pass");
//					ExtentTestReport.getReporter().log(LogStatus.INFO, "Successfully navigated to login screen");
					ExtentTestReport.getReporter().log(LogStatus.PASS, result.getTestContext().getCurrentXmlTest().getName(), "pASS");
			}
			else if(result.getStatus()==ITestResult.FAILURE)
			{
//					ExtentTestReport.extRpts.get(Thread.currentThread().getId()).log(LogStatus.FAIL, result.getTestContext().getCurrentXmlTest().getName(), "Fail");
					ExtentTestReport.getReporter().log(LogStatus.FAIL, result.getTestContext().getCurrentXmlTest().getName(), "fAIL");
			}
					
//					ExtentReportCore.getReporter("").endTest(ExtentTestReport.extRpts.get(Thread.currentThread().getId()));
					ExtentReportCore.getReporter("").endTest(ExtentTestReport.getReporter());	
					
					ExtentReportCore.getReporter("").flush();
				
	}

}
