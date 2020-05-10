package edu.ufp.inf.projeto;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {

  private int day;

  private int month;

  private int year;

  private int hour;

  private int minute;

  private int dias_semana;

  public Date(int hour, int minute, int dias_semana) {
    this.hour = hour;
    this.minute = minute;
    this.dias_semana = dias_semana;
  }

  public Date(int month, int year) {
    this.month = month;
    this.year = year;
  }

  public Date(int day, int month, int year, int hour, int minute) {
    this.day = day;
    this.month = month;
    this.year = year;
    this.hour = hour;
    this.minute = minute;
  }

  public Date() {
    GregorianCalendar gregCalendar = new GregorianCalendar();
    this.day = gregCalendar.get(Calendar.DAY_OF_MONTH);
    this.month = gregCalendar.get(Calendar.MONTH) + 1;
    this.year = gregCalendar.get(Calendar.YEAR);
    this.hour = gregCalendar.get(Calendar.HOUR_OF_DAY);
    this.minute = gregCalendar.get(Calendar.MINUTE);
  }

  public boolean isAfter(Date that) {
    return compareTo(that) > 0;
  }

  public boolean isBefore(Date that) {
    return compareTo(that) < 0;
  }

  public boolean isEqual(Date that) {
    return compareTo(that) == 0;
  }

  public boolean isBetween(Date lo, Date hi){
    return this.isAfter(lo) && this.isBefore(hi);
  }

  public int compareTo(Date d) {
    if (this.year == d.year && this.month == d.month && this.day == d.day && this.hour == d.hour && this.minute == d.minute) {
      return 0;
    } else if (this.year == d.year) {
      if (this.month == d.month) {
        if (this.day == d.day) {
          if (this.hour == d.hour) {
            return this.minute < d.minute ? -1 : 1;
          }
          return this.hour < d.hour ? -1 : 1;
        }
        return this.day < d.day ? -1 : 1;
      } else {
        return this.month < d.month ? -1 : 1;
      }
    } else {
      return this.year < d.year ? -1 : 1;
    }
  }


  @Override
  public String toString() {
    return this.day + "/" + this.month + "/" + this.year + " " + this.hour + ":" + this.minute + ":";
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int getDias_semana() {
    return dias_semana;
  }

  public void setDias_semana(int dias_semana) {
    this.dias_semana = dias_semana;
  }
}