package com.assurity.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assurity.framework.common.Constants;
import com.assurity.framework.common.Constants.JsonPaths;
import com.assurity.framework.common.Constants.Path;
import com.assurity.framework.common.PropertyFileReader;
import com.assurity.framework.reports.ExtentReport;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This is the Test class which contains the automated tests to test the given API
 * @author RasithaE
 *
 */
public class APITest extends BaseTest {

	String apiRequestURL;

	@BeforeClass
	public void beforeClass() {
		
		// Read the config.properties file and get API request URL details
		PropertyFileReader propertyFile = new PropertyFileReader(Path.CONFIG_FILE_PATH, Path.CONFIG_FILE_NAME);
		apiRequestURL = propertyFile.getProperty(Constants.Properties.API_REQUEST_URL);
	}
	
	@Test
	public void AssurityAPITest() {

		// Send the API request using RestAssured and get the response
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		Response response = request.get(apiRequestURL);

		// Log API response to report
		ExtentReport.log(response.getBody().asPrettyString()); 

		// Extract required values from JSON response using JsonPaths
		JsonPath json = response.jsonPath();
		String returnedName = json.getString(JsonPaths.NAME_PATH);
		boolean returnedCanRelist = json.getBoolean(JsonPaths.CAN_RELIST_PATH);
		String returnedPromotionDesc = json.get(JsonPaths.PROMOTIONS_PATH);

		
		// Verify Acceptance criteria 1 - Verify Name = "Carbon credits"
		Assert.assertEquals(returnedName, "Carbon credits");
		ExtentReport.log("Verified Name = 'Carbon credits'");

		// Verify Acceptance criteria 2 -  Verify CanRelist = true
		Assert.assertTrue(returnedCanRelist);
		ExtentReport.log("Verified CanRelist = true");

		// Verify Acceptance criteria 3 - Verify The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"
		Assert.assertEquals(returnedPromotionDesc, "Good position in category");
		ExtentReport.log("Verified Gallary Description = Good position in category");

	}

}
