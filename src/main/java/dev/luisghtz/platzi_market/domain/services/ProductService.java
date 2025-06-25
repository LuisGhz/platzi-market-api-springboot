package dev.luisghtz.platzi_market.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.luisghtz.platzi_market.domain.Product;
import dev.luisghtz.platzi_market.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> getAll() {
    return productRepository.getAll();
  }

  public Optional<List<Product>> getByCategory(int categoryId) {
    return productRepository.getByCategory(categoryId);
  }

  public Optional<List<Product>> getScarseProducts(int quantity) {
    return productRepository.getScarseProducts(quantity);
  }

  public Optional<Product> getById(int productId) {
    return productRepository.getById(productId);
  }

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public boolean delete(int id) {
    if (getById(id).isPresent()) {
      productRepository.delete(id);
      return true;
    }
    return false;
  }
}
