package com.accenture.webinarJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeManipulacion {
	
	public static void main(String args[]) {
		
		//Ejemplo 1
		System.out.println("Ejemplo 1----------------");
		LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
		System.out.println(date); 	// 2014-01-20
		
		date = date.plusDays(2);	// +2 dias
		System.out.println(date); 	// 2014-01-22
		
		date = date.plusWeeks(1);	// +1 semana (Igual a +7 dias)
		System.out.println(date); 	// 2014-01-29
		
		date = date.plusMonths(1);	// +1 mes
		System.out.println(date); 	// 2014-02-28
		
		date = date.plusYears(5);	// +5 anios
		System.out.println(date); 	// 2019-02-28
		
		
		
		//Ejemplo 2
		System.out.println("Ejemplo 2----------------");
		LocalDate dateA = LocalDate.of(2020, Month.JANUARY, 31);
		System.out.println(dateA); 	// 2020-01-31
		
		LocalDate dateB = dateA.plusMonths(1);	// +1 mes
		System.out.println(dateB); 				// 2020-02-29
		
		
		//Ejemplo 3
		System.out.println("Ejemplo 3----------------");
		LocalDate dateD = LocalDate.of(2020, Month.JANUARY, 31);
		System.out.println(dateD); 	// 2020-01-31
		dateD.plusMonths(1);		// Si no reasignamos la referencia devuelta la fecha original no es modificada.
		System.out.println(dateD); 	// 2020-01-31 - Imprime la misma fecha.
		
		
		
		//Ejemplo 4
		System.out.println("Ejemplo 4----------------");
		LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time1 = LocalTime.of(5, 15);
		LocalDateTime dateTime = LocalDateTime.of(date1, time1);
		System.out.println(dateTime); 			// 2020-01-20T05:15
		dateTime = dateTime.minusDays(1);
		System.out.println(dateTime); 			// 2020-01-19T05:15
		dateTime = dateTime.minusHours(10);
		System.out.println(dateTime); 			// 2020-01-18T19:15	-> Si los segundos y/o nanosegundos son "0" no se muestran.
		dateTime = dateTime.minusSeconds(30);
		System.out.println(dateTime); 			// 2020-01-18T19:14:30	
		
		
		
		//Ejemplo 5
		System.out.println("Ejemplo 5----------------");
		LocalDate date2 = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time2 = LocalTime.of(5, 15);
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2).minusDays(1).minusHours(10).minusSeconds(30); //Es posible encadenar la llamada a los metodos.
		System.out.println(dateTime2); 	// 2020-01-18T19:14:30
		
		
		//Ejemplo 6 -- isAfer, isBefore, isEqual
		System.out.println("\n\nEjemplo 6----------------");
		LocalDate startDate1 = LocalDate.of(2022, Month.JANUARY, 1); 
		LocalDate endDate1 = LocalDate.of(2022, Month.JANUARY, 31);
		boolean isBeforeDate = startDate1.isBefore(endDate1);
		System.out.println(startDate1 + " es antes de " + endDate1 + " : " + isBeforeDate);
		
		LocalDate startDate2 = LocalDate.of(2022, Month.APRIL, 30);
		LocalDate endDate2 = LocalDate.of(2022, Month.MARCH, 1);
		boolean isAfterDate = startDate2.isAfter(endDate2);
		System.out.println(startDate2 + " es despues de " + endDate2 + " : " + isAfterDate);
		
		//isAfter e isBefore daran un resultado de false si ambas fechas son iguales, 
		//solo regresaria true si se utiliza el metodo isEqual
		
		LocalDate startDate3 = LocalDate.of(2022, Month.JANUARY, 1);
		LocalDate endDate3 = LocalDate.of(2022, Month.JANUARY, 1);
		boolean isEqual = startDate3.isEqual(endDate3);
		System.out.println(startDate3 + " es igual a " + endDate3 + " : " + isEqual);
	}
}
