package com.goibibo.PageObjects;
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
		//  ParentClass pc = new ParentClass();
	   // public Properties prop = null;
	    public Goibibo_Price(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	       // wait = new WebDriverWait(driver, 30);
	       // prop = ParentClass.envProperties();
	    }
	    @FindBy(how = How.XPATH, using = "//input[@type='text'][@id='gosuggest_inputSrc']")
	     WebElement fromflight;
	    @FindBy(how = How.XPATH, using = "//input[@id='gosuggest_inputDest']")
	     WebElement toflight;
	    @FindBy(how = How.XPATH, using = "//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	     WebElement nextmonth;
	    public WebElement fromflight() {
	        return fromflight;
	    }
	    public WebElement toflight() {
	        return toflight;
	    }
	    public WebElement nextmontht() {
	        return nextmonth;
	    }
}
