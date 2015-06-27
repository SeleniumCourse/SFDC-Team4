package com.selenium.course.framework;

public class Browser 
{	
	/* Browser Name*/
	private final String browserName;
	

	public Browser(String browserName)
	{
		this.browserName = browserName;
	}
	
	public String getBrowserName()
	{
		return browserName;
	}
	
	public boolean isFirefox()
	{
		return browserName.equalsIgnoreCase("firefox");
	}
	
	public boolean isChrome()
	{
		return browserName.equalsIgnoreCase("chrome");
	}

	public boolean isInternetExplorer()
	{
		return browserName.equalsIgnoreCase("ie");
	}
	
	public boolean isSafari()
	{
		return browserName.equalsIgnoreCase("safari");
	}
}
