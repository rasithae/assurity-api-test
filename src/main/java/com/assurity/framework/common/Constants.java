package com.assurity.framework.common;

/**
 * This class contains all the constants used within this project
 * @author RasithaE
 *
 */
public class Constants {

	public static class Path {
		public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/com/assurity/config";
		public static final String CONFIG_FILE_NAME = "config.properties";
		public static final String REPORT_PATH = System.getProperty("user.dir") + "/reports/";
		public static final String REPORT_NAME = "ASSURITY_Test_Execution_Summary.html";
	}
	
	public static class Properties {
		public static final String API_REQUEST_URL = "apiRequestURL";
		public static final String REQUEST_TYPE = "requestType";
		public static final String RESPONSE_TYPE = "responseType";
	}

	public static class JsonPaths{
		public static final String NAME_PATH = "Name";
		public static final String CAN_RELIST_PATH = "CanRelist";
		public static final String PROMOTIONS_PATH = "Promotions.findAll{it.Name == 'Gallery'}.Description[0]";
	}
}