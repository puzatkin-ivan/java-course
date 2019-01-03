package com.supermarket;

import com.supermarket.customer.*;

import java.util.*;

public class SupermarketSimulator {
    private final Supermarket supermarket;

    public SupermarketSimulator(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public void work(int iterationsCount) {
        supermarket.open();
        while (--iterationsCount >= 0) {
            doExecute();
            break;
        }
        supermarket.close();
    }

    private void doExecute() {
        this.supermarket.addCustomer(makeCustomer());
        ICustomer customer = this.supermarket.getRandomCustomer();
        this.supermarket.doCustomerTookProduct(customer);
        this.supermarket.moveCustomerToCashDesk(customer.getCustomerId());
        this.supermarket.processCashDesk();
    }

    private ICustomer makeCustomer() {
        String name = getRandomName();
        ICustomer customer = new Customer(name, CustomerType.Retired, new ArrayList<>());
        return customer;
    }

    private String getRandomName() {
        List<String> names = new ArrayList<>();
        names.add("John"); names.add("Jupiter");
        names.add("Leo"); names.add("Thor");
        names.add("Orion"); names.add("Bently");
        names.add("Rosa"); names.add("Matilda");
        names.add("Ada");
        return names.get(new Random().nextInt(names.size() - 1));
    }
}
