package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.base.Base;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends Base{

	@Test(description = "Test case to verify google page title.")
	public void getPageTitle() {
		String getTitle = driver.getTitle();
		test.log(LogStatus.INFO, "Title is - "+getTitle);
		Assert.assertTrue(getTitle.equalsIgnoreCase("Google"), "Page of title does not match");
	}
	
	@Test(description = "Test case to verify google page URL.")
	public void getUrl() {
		String getURL = driver.getCurrentUrl();
		test.log(LogStatus.INFO, "URL is - "+getURL);
		Assert.assertTrue(getURL.equalsIgnoreCase("https://www.google.com/"), "Page URL does not match");
	}
}
