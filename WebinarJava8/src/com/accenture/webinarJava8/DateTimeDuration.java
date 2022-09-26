package com.accenture.webinarJava8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateTimeDuration {

	public static void main(String args[]) {

		//Ejemplo 1
		System.out.println("Ejemplo 1----------------");
		Instant start = Instant.parse("2017-10-03T10:15:30.00Z"); //La z indica que esta en la zona horaria UTC. 
		Instant end = Instant.parse("2017-10-03T10:16:30.00Z");
		        
		Duration duration = Duration.between(start, end);
		System.out.println("Diferencia tiempo:" + duration);
		System.out.println("Instant now:" + Instant.now());
		
		
		//Ejemplo 2
		System.out.println();
		System.out.println("Ejemplo 2----------------");
		LocalTime localTimeStart = LocalTime.of(10, 25);
		LocalTime localTimeEnd = LocalTime.of(11, 25);
		Duration difference = Duration.between(localTimeStart, localTimeEnd);
		System.out.println("Diferencia Inicio y Fin:" + difference);
		
		//Ejemplo 3
		System.out.println();
		System.out.println("Ejemplo 3----------------");
		LocalDate dateFromPast = LocalDate.of(2022, Month.SEPTEMBER, 5);
		LocalDate today = LocalDate.now();
		long daysBetween = ChronoUnit.DAYS.between(dateFromPast, today);
		System.out.println(daysBetween);
		
	}

}
