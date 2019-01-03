package com.supermarket.product;

import java.math.BigDecimal;

public interface IProduct {
    String getName();
    ProductCategory getCategory();
    BigDecimal getPrice();
    Integer getQuantity();

    IProduct split(int quantity);
    boolean isEmpty();
}
