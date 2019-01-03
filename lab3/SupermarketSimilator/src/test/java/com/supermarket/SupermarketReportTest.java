package com.supermarket;


import com.supermarket.bill.*;
import com.supermarket.product.*;
import org.junit.Test;
import org.junit.Assert;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SupermarketReportTest {
    @Test
    public void reportAggregatesAmount() {
        SupermarketReport report = new SupermarketReport();
        IBill bill = new Bill("Valera");
        bill.setPrice(BigDecimal.valueOf(22.5));
        report.addBill(bill);
        Bill anotherBill = new Bill("Another");
        anotherBill.setPrice(BigDecimal.valueOf(10.0));
        report.addBill(anotherBill);
        Assert.assertEquals(BigDecimal.valueOf(32.5).toString(), report.getFullAmount().toString());
    }

    @Test
    public void notSoldProductsExistsInReport() {
        String[] productNames = new String[]{"Milk", "Potato"};

        List<IProduct> unrealizedProducts = new ArrayList<>();
        for (String name : productNames) {
            unrealizedProducts.add(new Product(name, BigDecimal.valueOf(3), 3));
        }

        SupermarketReport report = new SupermarketReport();
        report.addUnrealizedProducts(unrealizedProducts);

        String reportStr = report.toString();
        for (String name : productNames) {
            Assert.assertTrue(reportStr.contains(name));
        }
    }
}