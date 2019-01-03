package com.supermarket.bill;

import com.supermarket.discount.Discount;
import com.supermarket.paymentMethod.PaymentMethod;

import java.math.BigDecimal;

public class Bill implements IBill {
    private String customerName;
    private BigDecimal price;
    private Discount discount;
    private PaymentMethod paymentMethod;

    public Bill(String customerName, Discount discount) {
        this.customerName = customerName;
        this.discount = discount;
    }

    public Bill(String customerName) {
        this.customerName = customerName;
        this.discount = new Discount(0);
    }

    @Override
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public BigDecimal getAmount() {
        return this.discount.accept(this.price);
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    @Override
    public void setPaymentMethod(PaymentMethod pm) {
        this.paymentMethod = pm;
    }

    @Override
    public String getCustomerName() {
        return this.customerName;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
