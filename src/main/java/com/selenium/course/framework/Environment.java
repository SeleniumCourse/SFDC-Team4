package com.selenium.course.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Environment {
	/* Create a instance over this class*/
	private static Environment instance;
	/* Read properties*/
	private Properties properties;
	
	private Environment()
	{
		File file = new File("gradle.properties");

		try {
			FileReader fileReader = new FileReader(file);
			properties = new Properties();
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Environment getInstance()
	{
		if (instance == null) {
			instance = new Environment();
		}
		return instance;
	}
	
	public String getEnv(String property)
	{
		String systemProperty = System.getProperty(property);
		if (systemProperty == null) {
			systemProperty = properties.getProperty(property);
		}
		return systemProperty;
	}
	
	public String getPrimaryUserName()
	{
		return Environment.getInstance()
				.getEnv("primaryUserName");
	}
	
	public String getPrimaryUserPassword()
	{
		return Environment.getInstance()
				.getEnv("primaryUserPassword");
	}

	public String getMode()
	{
		return Environment.getInstance()
				.getEnv("mode");
	}
	
	public Integer getTimeOut()
	{
		return Integer.parseInt(Environment.getInstance()
				.getEnv("timeout"));
	}

	public String getBrowser()
	{
		return Environment.getInstance()
				.getEnv("browser");
	}


	public String getPrimarySauceUser()
	{
		return Environment.getInstance()
				.getEnv("sauceUser");
	}

	public String getPrimarySauceAccessKey()
	{
		return Environment.getInstance()
				.getEnv("sauceAccessKey");
	}
	public String getPrimaryUsernameDisplayed()
	{
		return Environment.getInstance()
				.getEnv("primaryUsernameDisplayed");
	}
}
