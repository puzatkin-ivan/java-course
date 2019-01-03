package com.supermarket;


public class Main {
    private static final int ITERATIONS_COUNT  = 30;

    public static void main(String[] args) {
        try {
            SupermarketWatcher watcher = new SupermarketWatcher(System.out);
            Supermarket supermarket = new Supermarket(watcher);
            SupermarketSimulator simulator = new SupermarketSimulator(supermarket);
            simulator.work(ITERATIONS_COUNT);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
