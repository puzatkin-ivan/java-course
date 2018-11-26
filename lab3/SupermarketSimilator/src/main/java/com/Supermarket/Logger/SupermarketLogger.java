package com.Supermarket.Logger;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SupermarketLogger implements ISupermarketLogger {
  private PrintStream logStream;
  private Calendar calendar;
  private SimpleDateFormat sdf;

  public SupermarketLogger(PrintStream logStream) {
    this.calendar = Calendar.getInstance();
    this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    this.logStream = logStream;
  }

  public void log(String message) {
    logStream.println(prepareTimeMessage() + " " + message);
  }

  private String prepareTimeMessage() {
    return "[" + this.sdf.format(this.calendar.getTime()) + "]";
  }
}
