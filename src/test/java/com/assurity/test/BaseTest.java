package com.assurity.test;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.assurity.framework.reports.ExtentReport;

/**
 * This is the Base test class which contains setup, loading configuration and other reusable methods
 * @author RasithaE
 *
 */
public class BaseTest {
  
  @BeforeMethod
  public void beforeMethod(Method method, ITestContext context) {
	  
	  // Log test method name to Extent report
	  ExtentReport.logTestCase(method.getName());
  }
  @AfterMethod
  public void afterMethod(ITestResult testResult) {
	  
	  // Log test result to Extent report
	  ExtentReport.logResult(testResult);
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  // Initialize Extent report
	  ExtentReport.startReport();
  }
	
  @AfterSuite
  public void afterSuite() {
	  
	  // End the Extent report after test suite completion
	  ExtentReport.endReport();
  }

}
