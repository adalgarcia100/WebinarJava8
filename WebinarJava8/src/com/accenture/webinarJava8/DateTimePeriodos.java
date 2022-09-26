package com.accenture.webinarJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

public class DateTimePeriodos {

	public static void main(String args[]) {

		//Ejemplo 1 - 
		System.out.println("Ejemplo 1----------------");
		long date1 = LocalDate.of(2015, Month.JANUARY, 1).toEpochDay(); 	// Numero de dias desde 1970. Fecha que Unix tomo como estandard para las fechas.
		
		
		// Ejemplo 2
		System.out.println("Ejemplo 2----------------");
		Period annually = Period.ofYears(1); 			// every 1 year
		Period quarterly = Period.ofMonths(3); 			// every 3 months
		Period everyThreeWeeks = Period.ofWeeks(3); 	// every 3 weeks
		Period everyOtherDay = Period.ofDays(2); 		// every 2 days
		Period everyYearAndAWeek = Period.of(1, 0, 7); 	// every year and 7 days
	
		LocalDate date = LocalDate.of(2015, Month.JANUARY, 1);
		date = date.plus(annually); 					// Suma 1 año a la fecha utilizando un Period.
		System.out.println(date);						// 2016-01-01
		
		
		// Ejemplo 3
		System.out.println("Ejemplo 3----------------");
		Period wrong = Period.ofYears(1).ofWeeks(1);	
		//Los metodos de Period son estaticos. No operan sobre una instancia, por lo que no es posible encadenarlos como en LocalDate/Time.
		//En este caso solo el ultimo valor sera tomado en cuenta ("ofWeeks").
		
		
		
		// Ejemplo 4
		System.out.println("Ejemplo 4----------------");
		LocalDate date2 = LocalDate.of(2015, 1, 20);
		LocalTime time2 = LocalTime.of(6, 15);
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
		Period period = Period.ofMonths(1);
		System.out.println(date2.plus(period)); 		// 2015-02-20
		System.out.println(dateTime2.plus(period)); 	// 2015-02-20T06:15
		System.out.println(time2.plus(period)); 		// UnsupportedTemporalTypeException
	}

}
