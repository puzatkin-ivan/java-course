package com.supermarket.product;

import java.math.BigDecimal;
import java.util.*;

public class ProductProvider {
    public List<IProduct> getProducts() {
        List<IProduct> products = new ArrayList<>();

        products.add(new Product("Potato", BigDecimal.valueOf(20), 50, ProductCategory.All));
        products.add(new Product("Ham", BigDecimal.valueOf(100), 26, ProductCategory.All));
        products.add(new Product("Butter", BigDecimal.valueOf(200), 19, ProductCategory.All));
        products.add(new Product("Tin", BigDecimal.valueOf(30), 76, ProductCategory.All));
        products.add(new Product("Candy", BigDecimal.valueOf(50), 43, ProductCategory.All));
        products.add(new Product("Pastry", BigDecimal.valueOf(210), 12, ProductCategory.All));
        products.add(new Product("Yogurt", BigDecimal.valueOf(25), 56, ProductCategory.All));
        products.add(new Product("Loaf", BigDecimal.valueOf(24.4), 32, ProductCategory.All));
        products.add(new Product("Banana", BigDecimal.valueOf(29.9), 10, ProductCategory.All));
        return products;
    }
}
