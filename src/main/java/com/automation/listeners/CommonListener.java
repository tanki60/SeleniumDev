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

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + result.getName(), true);

	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Completed executing test " + result.getName(), true);

	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("Completed executing test " + result.getName(), true);

	}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Reporter.log("Completed executing test " + result.getName(), true);
		// TODO Auto-generated method stub

	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + context.getName(), true);

	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + context.getName(), true);

	}


	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + suite.getName(), true);

	}


	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + suite.getName(), true);

	}


	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String textMsg = "About to begin executing following method : " + returnMethodName(method.getTestMethod());

		Reporter.log(textMsg, true);

	}


	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String textMsg = "Completed executing following method : " + returnMethodName(method.getTestMethod());

		Reporter.log(textMsg, true);

	}

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

}