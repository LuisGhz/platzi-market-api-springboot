package dev.luisghtz.platzi_market.domain;

import lombok.Data;

@Data
public class Product {
  private Integer productId;
  private String name;
  private Integer categoryId;
  private double price;
  private int stock;
  private boolean active;
  private Category category;
}
