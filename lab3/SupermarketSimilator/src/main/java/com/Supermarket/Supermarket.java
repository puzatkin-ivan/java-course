package com.Supermarket;

import com.Supermarket.Watcher.ISupermarketWatcher;

public class Supermarket {
  private enum State {
    Opened,
    Closed
  }

  private ISupermarketWatcher watcher;
  private State state;

  public Supermarket(ISupermarketWatcher watcher) {
    this.watcher = watcher;
    this.state = State.Closed;
  }

  public void open() {
    if (this.state != State.Closed) {
      throw new RuntimeException("State should be closed before supermarket open");
    }

    this.state = State.Opened;
    this.watcher.handleOpened();
  }

  public void close() {
    if (state != State.Opened) {
      throw new RuntimeException("State should be opened before supermarket closed");
    }

    state = State.Closed;
    watcher.handleClosed();
  }
}
