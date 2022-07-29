package com.assurity.test;

import org.testng.annotations.Test;

import com.assurity.framework.common.Constants;
import com.assurity.framework.common.PropertyFileReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

/**
 * @author RasithaE
 *
 */
public class APITest extends BaseTest {

	String apiRequestURL;

	@BeforeMethod
	public void beforeMethod() {
		// Read the config.properties file
		PropertyFileReader propertyFile = new PropertyFileReader(Constants.Path.CONFIG_PATH, Constants.Path.CONFIG_FILE);
		apiRequestURL = propertyFile.getProperty(Constants.Properties.API_REQUEST_URL);
	}

	@Test
	public void MyTest() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", ContentType.JSON);
		Response response = request.get(apiRequestURL);

		// Store the Response body into tokenResponse variable
		String tokenResponse = response.getBody().asPrettyString();
		System.out.println(tokenResponse);

	}

}
