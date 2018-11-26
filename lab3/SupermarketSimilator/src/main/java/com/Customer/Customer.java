package com.Customer;

import com.Product.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private int type;
  private List<Product> shoppingCart;

  Customer(String name) {
    this.name = name;
    this.type = CustomerType.Adult;
    this.shoppingCart = new ArrayList<Product>();
  }

  Customer(String name, int type) throws Exception {
    this.name = name;
    if (!CustomerType.isType(type))
    {
      throw new IOException("Invalid customer type");
    }
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public int getType() {
    return this.type;
  }

  List<Product> getShoppingCart() {
    return this.shoppingCart;
  }

  public boolean isShoppingCartEmpty() {
    return this.shoppingCart.isEmpty();
  }

  public void addProduct(Product product) {
    this.shoppingCart.add(product);
  }
}
