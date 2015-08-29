package com.selenium.course.common;
import com.selenium.course.framework.Browser;
import com.selenium.course.framework.Environment;

public class Globals {

	public static final Integer TIMEOUT_MIN = Environment.getInstance().getTimeOut();
	public static final int TIMEOUT_NORMAL = 15;
	public static final int TIMEOUT_MAX = 50;
	
	public static final String PRIMARY_ACCOUNT = Environment.getInstance().getPrimaryUserName();
	public static final String PRIMARY_PSWD = Environment.getInstance().getPrimaryUserPassword();
	
	public static final Browser BROWSER    = new Browser(Environment.getInstance().getBrowser());
}
