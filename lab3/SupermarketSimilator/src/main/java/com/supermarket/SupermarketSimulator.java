package com.supermarket;

import com.supermarket.customer.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SupermarketSimulator {
    private enum Action {
        TakeProduct,
        AcceptCustomer,
        GoToCashDesk,
        ProcessCashDesk
    }
    private static final Action[] availableActions = Action.values();
    private final Supermarket supermarket;

    public SupermarketSimulator(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public void work(int iterationsCount) {
        supermarket.open();

        while (--iterationsCount >= 0) {
            doExecute();
        }
        while (this.supermarket.hasCustomers()) {
            ICustomer customer = this.supermarket.getRandomCustomer();
            this.supermarket.moveCustomerToCashDesk(customer.getCustomerId());
            this.supermarket.processCashDesk();
        }
        supermarket.close();
    }

    private void doExecute() {
        Action randomAction = availableActions[new Random().nextInt(availableActions.length - 1)];
        if (randomAction == Action.AcceptCustomer || !supermarket.hasCustomers()) {
            supermarket.addCustomer(makeCustomer());
        } else {
            ICustomer customer = this.supermarket.getRandomCustomer();
            if (randomAction == Action.GoToCashDesk && !customer.isBasketEmpty() || !supermarket.hasProducts()) {
                supermarket.moveCustomerToCashDesk(customer.getCustomerId());
            } else if (randomAction == Action.TakeProduct) {
                this.supermarket.doCustomerTookProduct(customer);
            }
        }
    }

    private ICustomer makeCustomer() {
        CustomerType[] types = CustomerType.values();
        int typeId = ThreadLocalRandom.current().nextInt(0, types.length - 1);
        CustomerType customerType = types[typeId];
        String name = getRandomName();
        return new Customer(name, customerType, new ArrayList<>());
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
