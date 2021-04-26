package com.vishal.project.MavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsBasics {
	ExtentReports er;
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\eindex.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("VK DocumentTitle");
		reporter.config().setReportName("Vk ReportName");
		
		er= new ExtentReports();
		er.attachReporter(reporter);
		er.setSystemInfo("Tester", "VK");
	}
	
	
	
	@Test
	public void testMethod()
	{
		ExtentTest test = er.createTest("TEst Method");
		System.setProperty("webdriver.chrome.driver", "C:\\Java_Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		System.out.println("Title for this web page is : "+driver.getTitle());
		
		driver.close();
		//test.fail("Result do not match");
		er.flush();
	}
}
