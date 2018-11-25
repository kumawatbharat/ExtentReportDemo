package com.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	protected static WebDriver driver;
	protected static ExtentReports report;
	protected static ExtentTest test;

	@BeforeMethod
	@Parameters("browserName")
	public void initBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}  else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}  else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(options); 
		}
			driver.manage().window().maximize();
			driver.get("https://www.google.com");
			System.out.println("Base configuration is done!");
	}
	
	@AfterMethod
	public void finishUp() {
		driver.quit();
	}
}
