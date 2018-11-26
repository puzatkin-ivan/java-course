package com.Customer;

import java.util.Arrays;

class CustomerType {
  public final static int Child = 0;
  public final static int Adult = 1;
  public final static int Retired = 2;

  public static boolean isType(int type) {
    return Arrays.binarySearch(new int[]{Child, Adult, Retired}, type) >= 0;
  }
}
