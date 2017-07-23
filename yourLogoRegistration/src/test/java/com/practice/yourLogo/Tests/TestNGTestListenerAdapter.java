package com.practice.yourLogo.Tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class TestNGTestListenerAdapter extends TestListenerAdapter{
		
		private Logger logger = Logger.getLogger("TestNGTestListenerAdapter");
		
		public TestNGTestListenerAdapter() {
				PropertyConfigurator.configure("src/test/resources/Log4j.Properties");
		}
		
		@Override
		public void onTestStart(ITestResult rt){
				logger.info("Started the test " + rt.getTestContext().getCurrentXmlTest().getName());
		}
		
		@Override
		public void onTestFailure(ITestResult rt){
				logger.info("Test failed " + rt.getTestContext().getCurrentXmlTest().getName());
		}
		
		@Override
		public void onTestSuccess(ITestResult rt){
				logger.info("Successfully finished the test " + rt.getTestContext().getCurrentXmlTest().getName());
				logger.info("Test Case " + rt.getTestContext().getCurrentXmlTest().getName() + " - Passed");
		}
}
