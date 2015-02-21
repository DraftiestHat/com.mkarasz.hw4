package com.mkarasz.hw4.currentDateTime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;


public class PrintDateTime {

	public static void main(String[] args) {
		String curTime = new SimpleDateFormat("MM/dd/yy hh:mm a").format(Calendar.getInstance().getTime());
		Calendar cal = new GregorianCalendar();
		
		System.out.println(curTime);
		
		switch(cal.get(Calendar.DAY_OF_WEEK)){
		case 1:
			System.out.print("Sunday, ");
			break;
		case 2:
			System.out.print("Monday, ");
			break;
		case 3:
			System.out.print("Tuesday, ");
			break;
		case 4:
			System.out.print("Wednesday, ");
			break;
		case 5:
			System.out.print("Thursday, ");
			break;
		case 6:
			System.out.print("Friday, ");
			break;
		case 7:
			System.out.print("Saturday, ");
			break;
		}
		
		
		System.out.print("" + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.YEAR) + " ");
		System.out.print("" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
		
		switch(cal.get(Calendar.AM)){
		case 1:
			System.out.println(" AM");
			break;
		default:
			System.out.println(" PM");
		}
		
		System.out.print("Which is the " + cal.get(Calendar.DAY_OF_YEAR));
		
		switch(cal.get(Calendar.DAY_OF_YEAR) % 10){
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.print("th");
			break;
		case 1:
			System.out.print("st");
			break;
		case 2:
			System.out.print("nd");
			break;
		case 3:
			System.out.print("rd");
			break;
		}
		
		System.out.println(" day of the year.");
	
	}

}
