package com.supermarket.customer;

import com.supermarket.product.*;
import java.util.List;

public class Customer implements ICustomer {
    private final String name;
    private final CustomerType type;
    private final List<IProduct> products;

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

    boolean isBasketEmpty() {
        return products.size() == 0;
    }
}
