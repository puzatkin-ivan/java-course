package com.Supermarket.Watcher;

import com.Supermarket.Logger.ISupermarketLogger;

public class SupermarketWatcher implements ISupermarketWatcher {
  private ISupermarketLogger logger;

  public SupermarketWatcher(ISupermarketLogger logger) {
    this.logger = logger;
  }

  public void handleOpened() {
    logger.log("Supermarket is opened");
  }

  public void handleClosed() {
    logger.log("Supermarket is closed");
  }
}
