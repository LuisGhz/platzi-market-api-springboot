package dev.luisghtz.platzi_market.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.luisghtz.platzi_market.domain.Product;
import dev.luisghtz.platzi_market.domain.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @GetMapping
  @Operation(description = "Get all supermarket products")
  @ApiResponse(responseCode = "200")
  public ResponseEntity<List<Product>> getAll() {
    return ResponseEntity.ok(productService.getAll());
  }

  @GetMapping("/category/{categoryId}")
  @Operation(description = "Get by category")
  @ApiResponses({
      @ApiResponse(responseCode = "200"),
      @ApiResponse(responseCode = "404")
  })
  public ResponseEntity<List<Product>> getByCategory(
      @Parameter(description = "Category's id", required = true) @PathVariable int categoryId) {
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
  public ResponseEntity<Product> save(@RequestBody Product product) {
    return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    return productService.delete(id)
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build();
  }
}
