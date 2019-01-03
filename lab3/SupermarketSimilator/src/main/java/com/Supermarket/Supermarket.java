package com.supermarket;

import com.supermarket.bill.*;
import com.supermarket.cashDesk.*;
import com.supermarket.customer.*;
import com.supermarket.product.*;

import java.util.*;

public class Supermarket {
    private enum State {
        Opened,
        Closed,
    }

    private final SupermarketWatcher watcher;
    private final SupermarketReport report;
    private final CashDesk cashDesk;
    private final ProductProvider productProvider;

    private List<IProduct> products;
    private List<ICustomer> customers;
    private Queue<ICustomer> cashDeskQueue;
    private State state;

    public Supermarket(SupermarketWatcher watcher) {
        this.watcher = watcher;
        this.report = new SupermarketReport();
        this.cashDesk = new CashDesk();
        this.productProvider = new ProductProvider();
        this.products = this.productProvider.getProducts();
        this.customers = new ArrayList<>();
        this.cashDeskQueue = new LinkedList<>();
        this.state = State.Closed;
    }

    void open() {
        if (this.state != State.Closed) {
            throw new RuntimeException("State should be closed before supermarket open");
        }

        this.state = State.Opened;
        this.watcher.handleOpened();
    }

    void close() {
        if (state != State.Opened) {
            throw new RuntimeException("State should be opened before supermarket closed");
        }

        state = State.Closed;
        report.addUnrealizedProducts(products);
        watcher.handleClosed();
        watcher.handleReport(report);
    }

    public void processCashDesk() {
        ICustomer customer = cashDeskQueue.poll();
        if (customer != null) {
            IBill bill = cashDesk.acceptCustomer(customer);
            report.addBill(bill);
            watcher.handleNewBill(bill);
        }
    }

    void addCustomer(ICustomer customer) {
        customer.setCustomerId(this.customers.size());
        this.customers.add(customer);
    }

    ICustomer getRandomCustomer() {
        return this.customers.get(new Random().nextInt(this.customers.size()));
    }

    boolean hasCustomers() {
        return this.customers.size() != 0;
    }

    boolean hasCustomersOnCashDesk() {
        return this.cashDeskQueue.size() != 0;
    }

    boolean hasProducts() {
        return this.products.size() != 0;
    }

    void moveCustomerToCashDesk(int customerId) {
        ICustomer customer = this.customers.get(customerId);
        this.customers.remove(customerId);
        this.cashDeskQueue.add(customer);
        watcher.handleCustomerGoToCashDesk(customer);
    }

    void doCustomerTookProduct(ICustomer customer) {
        int countOfProduct = this.products.size();
        int productId = new Random().nextInt(countOfProduct - 1);
        IProduct product = this.products.get(productId);
        int quantity = 1 + new Random().nextInt(product.getQuantity());
        IProduct unit = product.split(quantity);

        if (product.isEmpty()) {
            products.remove(productId);
        }

        customer.addProduct(unit);
        watcher.handleCustomerPickedProduct(customer, unit);
    }
}
