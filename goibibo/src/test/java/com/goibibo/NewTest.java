package com.goibibo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest extends ParentClass{
	@Test
	public void f() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\ws.automation\\goibibo\\src\\main\\java\\resources\\drive\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		Properties p = new Properties();
//		FileInputStream fis = new FileInputStream("C:\\Users\\Gandhi Buddha.GANDHIB-1LL\\git\\goibibo\\goibibo\\src\\main\\java\\resources\\TestData\\goibibo.properties");
//    	p.load(fis);
//		driver.get(p.getProperty("url"));
		driver.get(envProperties().getProperty("url"));
		driver.manage().window().maximize();
		WebElement w = driver.findElement(By.xpath("//input[@type='text'][@id='gosuggest_inputSrc']"));
		w.sendKeys("delhi");
		//Thread.sleep(2000);
		w.sendKeys(Keys.ARROW_DOWN);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		w.sendKeys(Keys.ENTER);
		WebElement w1 = driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
		w1.sendKeys("mumbai");
		Thread.sleep(2000);
		w1.sendKeys(Keys.ARROW_DOWN);
		w1.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		ArrayList<String> list = new ArrayList<String>();
		list.add("span[id='price_20200504']");
		list.add("span[id='price_20200505']");
		list.add("span[id='price_20200506']");
		list.add("span[id='price_20200507']");
		list.add("span[id='price_20200508']");
		list.add("span[id='price_20200509']");
		list.add("span[id='price_20200510']");
		String temp = "";
		int temp1 = 0;
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (String s : list) {
			WebElement web = driver.findElement(By.cssSelector(s));
			temp = web.getText();
			temp1 = Integer.parseInt(temp);
			list2.add(temp1);
			System.out.println(temp);
		}
		System.out.println(list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3 = list2;
		Collections.sort(list3);
		System.out.println(list3);
		int find = list3.get(0);
		int j = 0;
		for (int i = 0; i < list3.size(); i++) {
			if (list3.get(i).equals(find)) {
				j = i;
				break;
			}
		}
		System.out.println(list.get(j));
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement w2 = driver.findElement(By.cssSelector("j"));
		wait.until(ExpectedConditions.elementToBeClickable(w2)).click();
		driver.findElement(By.xpath("//button[text()='SEARCH']")).click();
	}

}