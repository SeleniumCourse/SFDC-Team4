package com.selenium.course.common;

import com.selenium.course.framework.Environment;

public class Globals {

    public static final Integer TIMEOUT_MIN = Environment.getInstance().getTimeOut();
    public static final int TIMEOUT_NORMAL = Environment.getInstance().getTimeOut() + 10;
    public static final int TIMEOUT_MAX = Environment.getInstance().getTimeOut() + 30;
    public static final String BASE_URL = "https://login.salesforce.com/";
    public static final String PRIMARY_ACCOUNT = Environment.getInstance().getPrimaryUserName();
    public static final String PRIMARY_PWD = Environment.getInstance().getPrimaryUserPassword();
    public static final String BROWSER = Environment.getInstance().getBrowser();
    public static final String PRIMARY_USERNAME_DISPLAYED = Environment.getInstance().getPrimaryUsernameDisplayed();
    public static final String MODE = Environment.getInstance().getMode();
    public static final String SAUCE_USER = Environment.getInstance().getPrimarySauceUser();
    public static final String SAUCE_USER_ACCESS_KEY = Environment.getInstance().getPrimarySauceAccessKey();
    public static final String PATH_CONTACT = "/contact.csv";
    public static final String PATH_EDIT_CONTACT = "/editcontact.csv";
}
