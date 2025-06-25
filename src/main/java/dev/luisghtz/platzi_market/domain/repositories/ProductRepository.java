package dev.luisghtz.platzi_market.domain.repositories;

import java.util.List;
import java.util.Optional;

import dev.luisghtz.platzi_market.domain.Product;

public interface ProductRepository {
  List<Product> getAll();

  Optional<List<Product>> getByCategory(int categoryId);

  Optional<List<Product>> getScarseProducts(int quantity);

  Optional<Product> getById(int productId);

  Product save(Product product);

  void delete(int id);
}
