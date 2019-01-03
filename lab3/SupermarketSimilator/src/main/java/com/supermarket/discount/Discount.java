package com.supermarket.discount;

import java.math.BigDecimal;

public class Discount {
    private int size;

    public Discount(int discountSize) {
        if (discountSize < 0 || 99 < discountSize) {
            throw new IllegalArgumentException("Invalid discount size");
        }

        size = discountSize;
    }

    public BigDecimal accept(BigDecimal amount) {
        if (this.size == 0) {
            return amount;
        }
        BigDecimal discount = new BigDecimal((double) size / 100);
        return amount.subtract(amount.multiply(discount)).setScale(2, 2);
    }
}
