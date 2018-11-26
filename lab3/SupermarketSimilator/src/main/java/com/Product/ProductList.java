package com.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductList {
  private String productName;
  private List<Product> list;

  public ProductList(String productName) {
    this.list = new ArrayList<Product>();
    this.productName = productName;
  }

  public ProductList(String productName, List<Product> list) throws IOException {
    this.productName = productName;
    for (Product item : list) {
      this.add(item);
    }
  }

  public void add(Product product) throws IOException {
    String productName = product.getName();
    if (!productName.equals(this.productName))
    {
      throw new IOException("Добавление неправильного продукта");
    }
    this.list.add(product);
  }
}
