package com.demo.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.base.Base;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		test.log(LogStatus.INFO, result.getMethod().getMethodName() + " test is started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " test is passed");
	}

	public void onTestFailure(ITestResult result) {
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		test.log(LogStatus.FAIL, result.getMethod().getMethodName(), test.addBase64ScreenShot(base64Screenshot));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " test is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReportResults.html", true);
	}

	public void onFinish(ITestContext context) {
		report.endTest(test);
		report.flush();
	}

}
