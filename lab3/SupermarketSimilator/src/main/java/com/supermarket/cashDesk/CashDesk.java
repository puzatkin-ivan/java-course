package com.supermarket.cashDesk;

import com.supermarket.bill.*;
import com.supermarket.customer.*;
import com.supermarket.discount.*;
import com.supermarket.product.*;

import java.math.BigDecimal;
import java.util.Random;

public class CashDesk implements ICashDesk {
    private static final int MAX_SIZE_DISCOUNT = 55;

    @Override
    public IBill acceptCustomer(ICustomer customer) {
        Discount discount = new Discount(0);
        if (customer.getCustomerType() == CustomerType.Retired) {
            discount = new Discount(new Random().nextInt(MAX_SIZE_DISCOUNT));
        }
        IBill bill = new Bill(customer.getName(), discount);
        bill.setPaymentMethod(customer.getPaymentMethod());
        bill.setPrice(getCustomerAmount(customer));
        return bill;
    }

    private BigDecimal getCustomerAmount(ICustomer customer) {
        BigDecimal amount = new BigDecimal(0);
        for (IProduct product : customer.getProducts()) {
            amount = amount.add(product.getPrice());
        }
        return amount;
    }
}
