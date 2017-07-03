package com.practice.yourLogo.Tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGEventListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test start details are: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success details are: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
