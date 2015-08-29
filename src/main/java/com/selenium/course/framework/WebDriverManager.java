package com.selenium.course.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;




public class WebDriverManager {

    private static WebDriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    private final String baseUrl = "https://login.salesforce.com/";
    private final int timeout_normal = Environment.getInstance().getTimeOut();
    private final String browser = Environment.getInstance().getBrowser();
    private final String mode = Environment.getInstance().getMode();
    private final String sauceUser = "carledriss";
    private final String sauceAccessKey = "82f05dc5-b331-46b0-8781-06dd0483088e";

    private WebDriverManager() {
        initializeDriver();
    }

    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    private void initializeDriver() {
        if (mode.equalsIgnoreCase("Local")) {
            if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                desiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
                System.setProperty("webdriver.ie.driver",
                        "drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver(desiredCapabilities);
            } else if (browser.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
            } else if (browser.equalsIgnoreCase("PhantomJS")) {
                System.setProperty("phantomjs.binary.path",
                        "drivers/phantomjs.exe");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability("takesScreenshot", true);
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        "drivers/phantomjs.exe"
                );
                driver = new PhantomJSDriver(caps);
            }
        } else if (mode.equals("Remote")) {
            // Choose the browser, version, and platform to test
            DesiredCapabilities caps = DesiredCapabilities.iphone();
            caps.setCapability("platform", "OS X 10.10");
            caps.setCapability("version", "9.0");
            caps.setCapability("deviceName","iPad Simulator");
            caps.setCapability("deviceOrientation", "portrait");
            // Create the connection to Sauce Labs to run the tests
            try {
                this.driver = new RemoteWebDriver(
                        new URL("http://" + sauceUser + ":" + sauceAccessKey + "@ondemand.saucelabs.com:80/wd/hub"),
                        caps);
            } catch (MalformedURLException e) {
                // implement
            }

        }

        driver.manage().timeouts().implicitlyWait(timeout_normal, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, timeout_normal);
        driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quit() {
        driver.quit();
    }
}
