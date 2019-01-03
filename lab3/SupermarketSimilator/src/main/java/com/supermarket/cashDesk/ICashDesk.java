package com.supermarket.cashDesk;

import com.supermarket.bill.IBill;
import com.supermarket.customer.ICustomer;

public interface ICashDesk {
    public IBill acceptCustomer(ICustomer customer);
}
