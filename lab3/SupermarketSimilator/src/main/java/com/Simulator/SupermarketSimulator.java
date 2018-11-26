package com.Simulator;

import com.Supermarket.*;

public class SupermarketSimulator {
  private Supermarket supermarket;

  public SupermarketSimulator(Supermarket supermarket) {
    this.supermarket = supermarket;
  }

  public void doExecute() {
    this.supermarket.open();
    this.supermarket.close();
  }
}
