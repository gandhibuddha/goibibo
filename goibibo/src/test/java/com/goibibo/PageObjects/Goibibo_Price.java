package com.goibibo.PageObjects;
import com.goibibo.ParentClass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Goibibo_Price {
	 WebDriver driver;
	    WebDriverWait wait;
	    public Properties prop = null;
	    public Goibibo_Price(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        wait = new WebDriverWait(driver, 30);
	        prop = ParentClass.envProperties();
	        driver.get(prop.getProperty("url"));
	    }
	    @FindBy(how = How.XPATH, using = "//select[@name='Product Type']")
	    private WebElement productType;
	    public WebElement getProductType() {
	        return productType;
	    }
}
