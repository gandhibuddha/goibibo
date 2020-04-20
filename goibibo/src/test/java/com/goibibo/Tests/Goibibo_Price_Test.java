package com.goibibo.Tests;
import com.goibibo.PageObjects.Goibibo_Price;

import org.testng.annotations.Test;

import com.goibibo.ParentClass;
public class Goibibo_Price_Test extends ParentClass {
 @Test 
  public void f() throws Exception {
	  Goibibo_Price gp = new Goibibo_Price(getDriver());
	  ParentClass pc = new ParentClass();
	  pc.browserSetup("Remote-Chrome");
	  
	  
  }
}
