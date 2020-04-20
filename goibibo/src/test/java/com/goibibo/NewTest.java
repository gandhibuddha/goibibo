package com.goibibo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
 System.setProperty("webdriver.chrome.driver","D:\\ws.automation\\goibibo\\src\\main\\java\\resources\\drive\\chromedriver.exe");
 WebDriver driver = new ChromeDriver();
 driver.get("https://www.goibibo.com/");
 driver.manage().window().maximize();
 WebElement w =driver.findElement(By.xpath("//input[@type='text'][@id='gosuggest_inputSrc']"));
 w.sendKeys("delhi");
 Thread.sleep(2000);
 w.sendKeys(Keys.ARROW_DOWN);
 w.sendKeys(Keys.ENTER);
 WebElement w1 =driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
 w1.sendKeys("mumbai");
 Thread.sleep(2000);
 w1.sendKeys(Keys.ARROW_DOWN);
 w1.sendKeys(Keys.ENTER);
WebElement dep = driver.findElement(By.xpath("//input[@type='text'][@id='departureCalendar']"));

  }
 
}
