package com.manish.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Manish
 *
 */
public class DayOfDate {
	enum Day {
		
	}
	
	public static void main(String[] args) {
		/*LocalDate localDate = LocalDate.of(2018, 11, 16);
		LocalDateTime atStartOfDay = localDate.atStartOfDay();
		System.out.println(atStartOfDay.getDayOfWeek().name());*/
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 11, 16);
		Date time = cal.getTime();
		String string = time.toString();
		String substring = string.substring(0, 3);
		System.out.println(substring);

	}

}
