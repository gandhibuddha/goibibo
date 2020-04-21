package com.goibibo.Tests;
import com.goibibo.PageObjects.Goibibo_Price;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.goibibo.ParentClass;
public class Goibibo_Price_Test extends ParentClass {
 @Test 
  public void f() throws Exception {
	  Goibibo_Price gp = new Goibibo_Price(driver);
	 // ParentClass pc = new ParentClass();
	 // System.setProperty("webdriver.chrome.driver",
		//		"D:\\ws.automation\\goibibo\\src\\main\\java\\resources\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(envProperties().getProperty("url"));
		driver.manage().window().maximize();
		gp.getfromflight().sendKeys("del");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gp.getfromflight().sendKeys(Keys.ARROW_DOWN);
		gp.getfromflight().sendKeys(Keys.ENTER);
		gp.gettoflight().sendKeys("mumbai");
		Thread.sleep(2000);
		gp.gettoflight().sendKeys(Keys.ARROW_DOWN);
		gp.gettoflight().sendKeys(Keys.ENTER);
		gp.getnextmontht().click();
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
		driver.findElement(By.cssSelector("j"));
	}

	  }

