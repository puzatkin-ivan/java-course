package com.Discount;

import java.io.IOException;

public class Discount {
  private int value;

  Discount(int value) throws IOException
  {
    if (value < 1 || value >= 100)
    {
      throw new IOException("Недопустимое значение скидки");
    }
    this.value = value;
  }
}
