package com.assurity.framework.reports;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;

import com.assurity.framework.common.Constants;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports	.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class handles the html test report generation code using Extent reports library
 * @author RasithaE
 *
 */
public class ExtentReport {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static String reportFolderPath;

	/**
	 * Starts the Extent Report by generating the required prerequisites like
	 * report folders, unique report file Run before all the tests
	 * 
	 * @param reportName Report file name
	 */
	public static void startReport(String reportFoldeName) {

		// Create a report file
		String reportFolderPath = Constants.Path.REPORT_PATH + reportFoldeName;
		String reportPath = reportFolderPath + "\\"+ Constants.Path.REPORT_NAME ;
		
		// Create folder if not exist
		File file = new File(reportPath);
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Start Extent Reporter
		htmlReporter = new ExtentHtmlReporter(reportPath);// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "Test Environment");
		extent.setSystemInfo("User Name", "Assurity New Zealand");
		htmlReporter.config().setDocumentTitle("Assurity Test Automation Report"); // Title of the report																					
		htmlReporter.config().setReportName("Assurity Test Automation Report"); // Name of the report	
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	/**
	 * Starts the Extent Report by generating the required prerequisites like
	 * report folders, unique report file Run before all the tests
	 */
	public static void startReport() {
		String reportName = getTestReportId();
		setReportFolderPath(Constants.Path.REPORT_PATH + reportName);
		startReport(reportName);
	}

	/**
	 * Log the test name to report
	 * @param testName Test Name
	 */
	public static void logTestCase(String testName) {
		extentTest.set(extent.createTest(testName).createNode(testName));
	}

	/**
	 * Log the test result to the report
	 * @param result ITestResult instance containing the test information
	 */
	public static void logResult(ITestResult result) {

		// If the test result is FAILURE, mark the test status as FAIL
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.get().log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case FAILED", ExtentColor.RED));
			extentTest.get().fail(result.getThrowable());

			StringWriter errors = new StringWriter();
			result.getThrowable().printStackTrace(new PrintWriter(errors));
		}

		// If the test result is SKIP, mark the test status as SKIP
		else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.get().log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case SKIPPED", ExtentColor.ORANGE));
			extentTest.get().skip(result.getThrowable());
		}

		// If the test result is SUCCESS, mark the test status as PASS
		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.get().log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	/**
	 * End report and flush Extent report instance
	 */
	public static void endReport() {
		extent.flush();
	}

	/**
	 * Generate a unique test report ID based on the test execution time
	 * @return generated report id
	 */
	private static String getTestReportId() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date = new Date();
		return "ASSURITY_Test_Report_" + dateFormat.format(date).toString();
	}

	/**
	 * Set report folder path
	 * @param folderPath report folder path
	 */
	private static void setReportFolderPath(String folderPath) {
		reportFolderPath = folderPath;
	}

	/**
	 * Get report folder path
	 * @return report folder path
	 */
	public static String getReportFolderPath() {
		return reportFolderPath;
	}

	/**
	 * Log a message to Extent report
	 * @param message message to log
	 */
	public static void log(String message) {
		extentTest.get().pass(message);
	}

}
