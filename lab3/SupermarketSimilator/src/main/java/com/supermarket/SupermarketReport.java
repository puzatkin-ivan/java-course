package com.supermarket;

import com.supermarket.bill.*;
import com.supermarket.product.*;

import java.math.BigDecimal;
import java.util.*;

public class SupermarketReport {
    private final List<IBill> bills;
    private List<IProduct> unrealizedProducts;

    public SupermarketReport() {
        this.bills = new ArrayList<>();
        this.unrealizedProducts = new ArrayList<>();
    }

    public void addUnrealizedProducts(List<IProduct> products) {
        this.unrealizedProducts.addAll(products);
    }

    public void addBill(IBill bill) {
        this.bills.add(bill);
    }

    public String toString() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append("\nReport:\n");
        strBuild.append("Total amount: " + getFullAmount().toString() + "\n");
        strBuild.append("Unrealized products:\n");
        for (IProduct product : this.unrealizedProducts) {
            strBuild.append(" - ").append(product.getName()).append(" Quantity: ").append(product.getQuantity()).append("\n");
        }
        return strBuild.toString();
    }

    public BigDecimal getFullAmount() {
        BigDecimal result = new BigDecimal(0);
        for (IBill bill : this.bills) {
            result = result.add(bill.getAmount());
        }
        return result;
    }
}
