package com.api.rootLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TakeListner implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("*** running test method" + result.getMethod().getMethodName() + "****");

		ExtentTestManager.startTest(result.getMethod().getMethodName() + "***");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed" + result.getMethod().getMethodName() + "****");

		ExtentTestManager.getTest().log(Status.PASS, "testPassed");

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("*** TestExecuted" + result.getMethod().getMethodName() + "Failed****");

		ExtentTestManager.getTest().log(Status.FAIL, "TestFailed");
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("***Test" + result.getMethod().getMethodName() + "**** Skipped");

		ExtentTestManager.getTest().log(Status.SKIP, "TestSkip");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("***TestFailedButWithinpersentage " + result.getMethod().getMethodName() + "****");

	}

	public void onStart(ITestContext context) {
		System.out.println("***Test Suite" + context.getName() + "Started***");
	}

	public void onFinish(ITestContext context) {
		System.out.println("***Test Suite" + context.getName() + "ended***");

		ExtentTestManager.endTest();
		EXtentManager.getInstance().flush();

	}

}
