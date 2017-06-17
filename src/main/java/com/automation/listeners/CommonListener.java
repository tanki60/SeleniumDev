package com.automation.listeners;

import org.testng.IInvokedMethod;

import org.testng.IInvokedMethodListener;

import org.testng.ISuite;

import org.testng.ISuiteListener;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestNGMethod;

import org.testng.ITestResult;

import org.testng.Reporter;

public class CommonListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

	// This belongs to ISuiteListener and will execute before the Suite start

	public void onStart(ISuite context) {

		Reporter.log(
				"ISuite onStart==> " + " Suite Name: " + context.getName() + " ==> Suite START TIME: " + System.currentTimeMillis()
						/ 1000, true);
	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished
	public void onFinish(ISuite context) {

		Reporter.log(
				"ISuite onFinish==> " + " Suite Name: " + context.getName() + " ==> Suite END TIME: " + System.currentTimeMillis()
						/ 1000, true);
	}

	// This belongs to ITestListener and will execute before starting of Test
	// set/batch

	public void onStart(ITestContext context) {

		Reporter.log("ITestContext onStart==> About to begin executing Test " + context.getName(), true);

	}

	// This belongs to ITestListener and will execute, once the Test set/batch
	// is finished

	public void onFinish(ITestContext context) {

		Reporter.log("ITestContext onFinish==> Completed executing test " + context.getName(), true);

	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult context) {

		// This is calling the printTestResults method
		Reporter.log("ITestResult onTestSuccess==> "+" Test Name: " + context.getName() + " END TIME: " + System.currentTimeMillis()/1000);

	}

	// This belongs to ITestListener and will execute only on the event of fail
	// test

	public void onTestFailure(ITestResult context) {

		// This is calling the printTestResults method
		Reporter.log("ITestResult onTestFailure==> "+" Test Name: " + context.getName() + " END TIME: " + System.currentTimeMillis()/1000);
	}

	// This belongs to ITestListener and will execute before the main test start
	// (@Test)

	public void onTestStart(ITestResult context) {

		Reporter.log("ITestResult onTestStart==> "+" Test Name: " + context.getName() + " START TIME: " + System.currentTimeMillis()/1000);

	}

	// This belongs to ITestListener and will execute only if any of the main
	// test(@Test) get skipped

	public void onTestSkipped(ITestResult context) {

		Reporter.log("ITestResult onTestSkipped==> "+" Test Name: " + context.getName());

	}


	// This belongs to IInvokedMethodListener and will execute before every
	// method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod context, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(context.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This belongs to IInvokedMethodListener and will execute after every
	// method including @Before @After @Test

	public void afterInvocation(IInvokedMethod context, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(context.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		//Not needed for now
		
	}

}