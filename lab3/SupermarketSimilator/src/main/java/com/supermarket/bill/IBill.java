package com.supermarket.bill;

import com.supermarket.paymentMethod.PaymentMethod;
import java.math.BigDecimal;

public interface IBill {
    BigDecimal getAmount();

    String getCustomerName();
    void setCustomerName(String customerName);

    PaymentMethod getPaymentMethod();
    void setPaymentMethod(PaymentMethod pm);

    void setPrice(BigDecimal price);
}
