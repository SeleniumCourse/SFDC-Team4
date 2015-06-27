package com.selenium.course.framework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentSetting {
	/* Create a instance over this class*/
	private static EnvironmentSetting instance;
	/* Read properties*/
	private Properties properties;
	
	private EnvironmentSetting() 
	{
		properties = new Properties();
		try {
			properties.load(new FileReader(new File(System.getProperty("user.dir")+ File.separator + "gradle.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static EnvironmentSetting getInstance() 
	{
		if (instance == null) {
			instance = new EnvironmentSetting();
		}
		return instance;
	}
	
	public String getEnvironmentSet(String property) 
	{
		String systemProperty = System.getProperty(property);
		if (systemProperty == null) {
			systemProperty = properties.getProperty(property);
		}
		return systemProperty;
	}
	
	public String getPrimaryUser()
	{
		return getEnvironmentSet("primaryUserName");
	}
	
	public String getPrimaryPassword()
	{
		return getEnvironmentSet("primaryUserPassword");
	}
	
	public Integer getImplicitWait()
	{
		return Integer.parseInt(getEnvironmentSet("implicitlyWait"));
	}	
	
	public Integer getWebDriverWait()
	{
		return Integer.parseInt(getEnvironmentSet("webdriverWait"));
	}
	
	public Integer getTimeOut()
	{
		return Integer.parseInt(getEnvironmentSet("timeout"));
	}
	
	public String getGroups()
	{
		return getEnvironmentSet("groups");
	}
	
	public String getSuites()
	{
		return getEnvironmentSet("suites");
	}
	
	public String getBrowser()
	{
		return getEnvironmentSet("browser");
	}
}
