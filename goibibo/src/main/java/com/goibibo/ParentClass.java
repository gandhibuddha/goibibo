package com.goibibo;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class ParentClass {
	public static String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Driver" + File.separator;
    public static String propfilepath = "D:\\ws.automation\\goibibo\\src\\main\\java\\resources\\TestData\\goibibo.properties";

    Properties prop;


    public static Properties config;
    public static Properties locateValidate;

    public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
    RemoteWebDriver driver;
    private static ChromeDriverService service;


    public static RemoteWebDriver getDriver() {
        return dr.get();
    }

    public void setWebDriver(RemoteWebDriver driver) {
        dr.set(driver);
    }

    @BeforeTest
    @Parameters("BrowserType")
    public void browserSetup(String BrowserType) throws Exception {
        Properties prop = ParentClass.envProperties();
        if (BrowserType.equalsIgnoreCase("Remote-Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_settings.popups", 0);
            options.setExperimentalOption("prefs", prefs);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new RemoteWebDriver(new URL(prop.getProperty("selenium_grid")), capabilities);
            driver.setFileDetector(new LocalFileDetector());
        } else if (BrowserType.equalsIgnoreCase("Remote-IE")) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            driver = new RemoteWebDriver(new URL(prop.getProperty("selenium_grid")), capabilities);
            driver.setFileDetector(new LocalFileDetector());
        } else if (BrowserType.equalsIgnoreCase("Local-Chrome")) {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverPath + "chromedriver.exe")).usingPort(6588).build();
            service.start();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_settings.popups", 0);
            options.setExperimentalOption("prefs", prefs);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new RemoteWebDriver(new URL("http://localhost:6588/"), capabilities);
            driver.setFileDetector(new LocalFileDetector());
        }
        setWebDriver(driver);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static Properties envProperties() {
        Properties prop = new Properties();
        try {
            prop.load(ParentClass.class.getClassLoader().getResourceAsStream(propfilepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    @AfterTest
    public void tearDown() {
        try {
            if (getDriver() != null) {
                System.out.println("Quitting driver");
                    getDriver().close();
                    getDriver().quit();
            }
            Thread.sleep(2000);  // Let the user actually see something!
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
        }
        Reporter.log("Driver quit successful", true);
    }

    public void closeBrowser(String BrowserType) {
        getDriver().close();
        getDriver().quit();

        if (BrowserType.contains("Local")) {
            service.stop();
        }
    }
}
