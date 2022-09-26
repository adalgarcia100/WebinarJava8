package com.accenture.webinarJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class DateTimeCreacion {
	
	public static void main(String args[]) {
		
		//Ejemplo 1 - now
		System.out.println("Ejemplo 1----------------");
		System.out.println(LocalDate.now());		// Fecha actual
		System.out.println(LocalTime.now());		// Hora actual
		System.out.println(LocalDateTime.now());	// Fecha y hora actual.
		
		
		
		//Ejemplo 2 - LocalDate of
		System.out.println("Ejemplo 2----------------");
		LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);	//Utilizando el enum Month
		LocalDate date2 = LocalDate.of(2015, 1, 20);				//Utilizando un int (1 - 12)
		//LocalDate date3 = LocalDate.of(2015, 0, 20);				//DateTimeException (RuntimeException)
		
		
		
		//Ejemplo 3 - LocalTime of
		System.out.println("Ejemplo 3----------------");
		LocalTime time1 = LocalTime.of(6, 15); 				// hour and minute
		LocalTime time2 = LocalTime.of(6, 15, 30); 			// hour, minute and seconds
		LocalTime time3 = LocalTime.of(6, 15, 30, 200);		// hour, minute, seconds and nanoseconds
		//LocalTime time4 = LocalTime.of(25, 15, 30, 200);	// DateTimeException
		
		
		
		//Ejemplo 4 - LocalDateTime of
		System.out.println("Ejemplo 4----------------");
		LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);	//Existen varias sobrecargas con distintas combinaciones.
		LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);						//Es posible crearlo a partir de un LocalDate y un LocalTime.
		
		
		
		//Ejemplo 5
		//LocalDate d = new LocalDate(); // No compila, el constructor de las clases Date/Time es privado. Solo se pueden construir utilizando los metodos estaticos.
	}
	
}
