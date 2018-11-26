package com;

import com.Simulator.SupermarketSimulator;
import com.Supermarket.Logger.*;
import com.Supermarket.*;
import com.Supermarket.Watcher.*;

public class Main {
  public static void main(String[] args) {
    ISupermarketLogger logger = new SupermarketLogger(System.out);
    ISupermarketWatcher watcher = new SupermarketWatcher(logger);
    Supermarket supermarket = new Supermarket(watcher);
    SupermarketSimulator simulator = new SupermarketSimulator(supermarket);
    simulator.doExecute();
  }
}
