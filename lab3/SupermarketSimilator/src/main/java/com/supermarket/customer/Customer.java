package com.supermarket.customer;

import com.supermarket.paymentMethod.PaymentMethod;
import com.supermarket.product.*;
import java.util.List;
import java.util.Random;

public class Customer implements ICustomer {
    private final String name;
    private final CustomerType type;
    private final List<IProduct> products;
    private int customerId;

    public Customer(String name, CustomerType type, List<IProduct> products) {
        this.name = name;
        this.type = type;
        this.products = products;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CustomerType getCustomerType() {
        return this.type;
    }

    @Override
    public void addProduct(IProduct product) {
        this.products.add(product);
    }

    @Override
    public List<IProduct> getProducts() {
        return this.products;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        PaymentMethod[] pm = PaymentMethod.values();
        return pm[new Random().nextInt(pm.length - 1)];
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public boolean isBasketEmpty() {
        return products.size() == 0;
    }
}
