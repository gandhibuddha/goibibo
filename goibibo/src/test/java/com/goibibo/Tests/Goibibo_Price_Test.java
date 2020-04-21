package com.goibibo.Tests;
import com.goibibo.PageObjects.Goibibo_Price;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		driver = new ChromeDriver();
	 Goibibo_Price gp = new Goibibo_Price(driver);
		driver.get(envProperties().getProperty("url"));
		driver.manage().window().maximize();
		gp.fromflight().sendKeys("Delhi (DEL)");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gp.fromflight().sendKeys(Keys.ARROW_DOWN);
		gp.fromflight().sendKeys(Keys.ENTER);
		gp.toflight().sendKeys("mumbai");
		Thread.sleep(2000);
		gp.toflight().sendKeys(Keys.ARROW_DOWN);
		gp.toflight().sendKeys(Keys.ENTER);
		gp.nextmontht().click();
		ArrayList<String> list = new ArrayList<String>();
		String oldDate = "2020-05-04";  
		System.out.println("Date before Addition: "+oldDate);
		//Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try{
		   //Setting the date to the given date
		   c.setTime(sdf.parse(oldDate));
		}catch(ParseException e){
			e.printStackTrace();
		 }
		  for(int i=0;i<7;i++) {
				//Number of Days to add
				c.add(Calendar.DAY_OF_MONTH, 1);  
				//Date after adding the days to the given date
				String newDate = sdf.format(c.getTime());  
				newDate = newDate.replace("-","");
				String datexp="span[id='price_"+newDate+"']";
				//Displaying the new Date after addition of Days
				System.out.println("Date after Addition: "+newDate);
				list.add(datexp);
			  
		  }
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
		String s = list.get(j);
		String p = s.substring(s.length()-10);
		p = p.substring(0,8);
		System.out.println(p);
		String newpath = "//*[@id=\"fare_" + p + "\"]";
		System.out.println(newpath);
		driver.findElement(By.xpath(newpath)).click();
		gp.search().click();
		
	}

	  }

