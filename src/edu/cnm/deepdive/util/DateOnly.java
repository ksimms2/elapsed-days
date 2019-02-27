package edu.cnm.deepdive.util;

public class DateOnly {


  public static int elapsedDays(int year, int month, int day) {



    final int STANDARD_DAYS_YEAR = 365;
    int GROUND_ZERO = 1970;
    int yearDays = (year - GROUND_ZERO) * STANDARD_DAYS_YEAR;
    int days = day - 1;
    int tempYear = year;
    int leapDays = 0;


    if(year<GROUND_ZERO){
      GROUND_ZERO = year;
      year = 1970;

    }

    for (int i = GROUND_ZERO; i < year; ++i) {

      if (isLeapYear(i)) {
          leapDays++;

      }

      else if(year == GROUND_ZERO) {
        leapDays--;

      }

    }


    GROUND_ZERO = 1970;
    year=tempYear;


    if(year>=GROUND_ZERO) {
      days += yearDays + leapDays + monthDays(month);
      return days;

    } else {
      days = yearDays - leapDays + days + monthDays(month);
      return days;

    }

  }



  private static int monthDays(int month) {

    int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int daysInMonth = 0;



    if (month == 0) {
      daysInMonth = 0;
      return daysInMonth;

    } else {
      for (int i = 0; i < month; ++i) {
        daysInMonth += monthDays[i];

      }

    }

    return daysInMonth;

  }


  private static boolean isLeapYear(int year) {

    return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));

  }



}



