package com.goibibo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class ParentClass {
public static String driverPath = System.setProperty("webdriver.chrome.driver",
			"D:\\ws.automation\\goibibo\\src\\main\\java\\resources\\drive\\chromedriver.exe");
public static String propfilepath = "C:\\Users\\Gandhi Buddha.GANDHIB-1LL\\git\\goibibo\\goibibo\\src\\main\\java\\resources\\TestData\\goibibo.properties";
 static Properties prop=null;
public WebDriver driver;

       
public static Properties envProperties() {
         prop = new Properties();
        try {
    		FileInputStream fis = new FileInputStream("C:\\Users\\Gandhi Buddha.GANDHIB-1LL\\git\\goibibo\\goibibo\\src\\main\\java\\resources\\TestData\\goibibo.properties");
        	prop.load(fis);
        	} catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
       
 public void closeBrowser(String BrowserType) {
       driver.close();
       driver.quit();
    }
}
