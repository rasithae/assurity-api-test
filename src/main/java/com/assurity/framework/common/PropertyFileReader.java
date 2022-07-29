package com.assurity.framework.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author RasithaE
 *
 */
public class PropertyFileReader {

	private String dataFolder;
	private String dataFile;
	private Properties properties;

	public PropertyFileReader(String dataFolder, String dataFile) {
		this.dataFolder = dataFolder;
		this.dataFile = dataFile;
		setPropertyFile();
	}
	
	/**
	 * Get the data folder path
	 * @return data folder path
	 */
	public String getDataFolder() {
		return dataFolder;
	}
	
	/**
	 * Get data file name
	 * @return data file name
	 */
	public String getDataFile() {
		return dataFile;
	}
	
	/**
	 * Searches for the property with the specified key in this property list.
	 * 
	 * @param key
	 *            the property key.
	 * @return the value in this property list with the specified key value.
	 */
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	/**
	 * Set given property file 
	 */
	private void setPropertyFile() {
		try {
			properties = new Properties();
			String dataFilePath =  getDataFolder() + "/" + getDataFile();
			properties.load(new FileInputStream(dataFilePath));
		} catch (IOException e) {
			e.printStackTrace();
			//Log.error("Error reading property file.");
		}
	}
}
