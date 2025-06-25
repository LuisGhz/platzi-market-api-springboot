package dev.luisghtz.platzi_market.web.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.luisghtz.platzi_market.domain.Product;
import dev.luisghtz.platzi_market.domain.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping
  public List<Product> getAll() {
    return productService.getAll();
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<Product>> getByCategory(@PathVariable int categoryId) {
    return productService.getByCategory(categoryId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/scarse/{quantity}")
  public ResponseEntity<List<Product>> getScarseProducts(@PathVariable int quantity) {
    return productService.getScarseProducts(quantity)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable int id) {
    return productService.getById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Product save(@RequestBody Product product) {
    return productService.save(product);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    return productService.delete(id)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }
}
