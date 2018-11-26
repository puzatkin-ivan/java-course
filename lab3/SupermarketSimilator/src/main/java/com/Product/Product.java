package com.Product;

import java.util.ArrayList;
import java.util.List;

public class Product {
  private String name;
  private double price;
  private List<Integer> types;

  Product(String name, double price, List<Integer> types)
  {
    this.name = name;
    this.price = price;
    this.types = types;
  }

  Product(String name, double price)
  {
    this.name = name;
    this.price = price;
    this.types = new ArrayList<Integer>(ProductType.All);
  }

  String getName() {
    return this.name;
  }

  double getPrice() {
    return this.price;
  }

  List<Integer> getTypes() {
    return this.types;
  }
}
