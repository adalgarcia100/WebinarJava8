package com.accenture.webinarJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTimeFormato {
	
	public static void main(String args[]) {
		
		//Change Locale to ES MX
		//Locale.setDefault(new Locale("es","MX"));
		
		//Ejemplo 1
		System.out.println("Ejemplo 1----------------");
		LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
		System.out.println(date.getDayOfWeek()); 	// MONDAY
		System.out.println(date.getMonth()); 		// JANUARY
		System.out.println(date.getYear()); 		// 2020
		System.out.println(date.getDayOfYear()); 	// 20
		
		
		
		//Ejemplo 2
		System.out.println("Ejemplo 2----------------");
		LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time1 = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);
		
		System.out.println(date1.format(DateTimeFormatter.ISO_LOCAL_DATE));				// 2020-01-20
		System.out.println(time1.format(DateTimeFormatter.ISO_LOCAL_TIME));				// 11:12:34
		System.out.println(dateTime1.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));	// 2020-01-20T11:12:34
		
		
		
		//Ejemplo 3
		System.out.println("Ejemplo 3----------------");
		DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(shortDateTime.format(dateTime1)); 	// 20/01/20
		System.out.println(shortDateTime.format(date1));	 	// 20/01/20
		//System.out.println(shortDateTime.format(time1)); 		// UnsupportedTemporalTypeException
		
		System.out.println(dateTime1.format(shortDateTime));	// 20/01/20
		System.out.println(date1.format(shortDateTime));		// 20/01/20
		//System.out.println(time1.format(shortDateTime));		// UnsupportedTemporalTypeException
		
		
		
		//Ejemplo 4
		System.out.println("Ejemplo 4----------------");
		LocalDate date2 = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time2 = LocalTime.of(11, 12, 34);
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
		DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		DateTimeFormatter mediumFTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		DateTimeFormatter mediumFDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(shortF.format(dateTime2)); 		//  20/01/20 11:12 AM
		System.out.println(mediumF.format(dateTime2)); 		//  20/01/2020 11:12:34 AM
		System.out.println(mediumFDate.format(dateTime2)); 	// 	20/01/2020
		System.out.println(mediumFTime.format(time2)); 		//	11:12 AM
		
		
		
		//Ejemplo 5
		System.out.println("Ejemplo 5----------------");
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm").withLocale(new Locale("es","MX"));
		System.out.println(dateTime2.format(f)); 			// enero 20, 2020, 11:12
		
		
		
		//Ejemplo 6
		System.out.println("Ejemplo 6----------------");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:mm");
		System.out.println(f2.format(dateTime2));	//11:12
		//System.out.println(f2.format(date2));		//UnsupportedTemporalTypeException
		System.out.println(f2.format(time2));		//11:12
		
		
		
		//Ejemplo 7 - Parseo de String a Date/Time
		System.out.println("Ejemplo 7----------------");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate date3 = LocalDate.parse("01 02 2015", f3);
		LocalTime time3 = LocalTime.parse("11:22");
		System.out.println(date3); // 2015-01-02
		System.out.println(time3); // 11:22
	}
	
}
