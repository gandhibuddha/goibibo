package com.goibibo.Tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dummy {
public static void main(String [] args) {
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
			//Displaying the new Date after addition of Days
			System.out.println("Date after Addition: "+newDate);
		  
	  }
   }
}
