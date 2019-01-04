package com.supermarket;

import com.supermarket.bill.IBill;
import com.supermarket.customer.ICustomer;
import com.supermarket.product.IProduct;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

public class SupermarketWatcher {
    private final PrintStream stream;

    public SupermarketWatcher(PrintStream stream) {
        this.stream = stream;
    }

    void handleOpened() {
        this.stream.println(prepareTimeLog() + " supermarket opened.");
    }

    void handleClosed() {
        this.stream.println(prepareTimeLog() + " supermarket closed.");
    }

    void handleReport(SupermarketReport report) {
        this.stream.println(prepareTimeLog() + " " + report.toString());
    }

    void handleNewProducts(List<IProduct> products) {
        String timeLog = prepareTimeLog();
        this.stream.println(timeLog + " Products have been formed:");
        for (IProduct product : products) {
            this.stream.printf("%" + timeLog.length() + "s%n", "- " + product.getName() + ", price: " + product.getPrice() + ", quantity: " + product.getQuantity());
        }
    }

    void handleNewCustomer(ICustomer customer) {
        this.stream.println(prepareTimeLog() + " New Customer with name: " + customer.getName() + " and type: " + customer.getCustomerType().toString());
    }

    void handleCustomerPickedProduct(ICustomer customer, IProduct product) {
        this.stream.println(prepareTimeLog() + " Customer " + customer.getName() + " picked " + product.getQuantity() + " units of product " + product.getName());
    }

    void handleCustomerGoToCashDesk(ICustomer customer) {
        this.stream.println(prepareTimeLog() + " Customer " + customer.getName() + " go to CashDesk");
    }

    void handleNewBill(IBill bill) {
        this.stream.println(prepareTimeLog() + " Customer " + bill.getCustomerName() + " pay the bill with amount " + bill.getAmount() + " and payment method " + bill.getPaymentMethod().toString());
    }


    private String prepareTimeLog() {
        return "[" + LocalDateTime.now() + "]";
    }
}
