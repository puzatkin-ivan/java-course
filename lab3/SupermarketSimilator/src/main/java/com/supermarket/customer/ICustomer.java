package com.supermarket.customer;

import com.supermarket.paymentMethod.PaymentMethod;
import com.supermarket.product.*;
import java.util.List;

public interface ICustomer {
    String getName();
    CustomerType getCustomerType();
    void addProduct(IProduct product);
    List<IProduct> getProducts();
    PaymentMethod getPaymentMethod();

    void setCustomerId(int customerId);
    int getCustomerId();
    boolean isBasketEmpty();
}
