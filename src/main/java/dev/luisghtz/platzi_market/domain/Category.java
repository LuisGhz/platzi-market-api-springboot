package dev.luisghtz.platzi_market.domain;

import lombok.Data;

@Data
public class Category {
  private int categoryId;
  private String category;
  private boolean active;
}
