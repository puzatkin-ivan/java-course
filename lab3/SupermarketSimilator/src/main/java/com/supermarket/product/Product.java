package com.supermarket.product;

import java.math.BigDecimal;

public class Product implements IProduct {
    private final String name;
    private final BigDecimal price;
    private Integer quantity;
    private final ProductCategory category;

    public Product(String productName, BigDecimal productPrice, Integer productQuantity, ProductCategory productCategory) {
        name = productName;
        price = productPrice;
        quantity = productQuantity;
        category = productCategory;
    }

    public Product(String productName, BigDecimal productPrice, int productQuantity) {
        this(productName, productPrice, productQuantity, ProductCategory.All);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ProductCategory getCategory() {
        return this.category;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean isEmpty() {
        return quantity == 0;
    }

    @Override
    public IProduct split(int partQuantity) throws IllegalArgumentException {
        if (partQuantity <= 0) {
            throw new IllegalArgumentException("part quantity " + partQuantity + " can't be less than 1");
        }
        if (partQuantity > quantity) {
            throw new IllegalArgumentException("part quantity " + partQuantity + " can't be greater than product quantity " + quantity);
        }

        this.quantity -= partQuantity;
        return new Product(name, price, partQuantity, this.category);
    }
}
