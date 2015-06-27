package com.selenium.course.common;
import com.selenium.course.framework.Browser;
import com.selenium.course.framework.EnvironmentSetting;

public class Globals {

	public static final Integer TIMEOUT_MIN = EnvironmentSetting.getInstance().getTimeOut();
	public static final int TIMEOUT_NORMAL = 15;
	public static final int TIMEOUT_MAX = 50;
	
	public static final String PRIMARY_ACCOUNT = EnvironmentSetting.getInstance().getPrimaryUser();
	public static final String PRIMARY_PSWD = EnvironmentSetting.getInstance().getPrimaryPassword();
	
	public static final Browser BROWSER    = new Browser(EnvironmentSetting.getInstance().getBrowser());
}
