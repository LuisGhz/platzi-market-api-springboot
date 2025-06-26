package dev.luisghtz.platzi_market.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.luisghtz.platzi_market.domain.Purchase;
import dev.luisghtz.platzi_market.domain.services.PurchaseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("purchase")
@RequiredArgsConstructor
public class PurchaseController {
  private final PurchaseService purchaseService;

  @GetMapping
  public ResponseEntity<List<Purchase>> getAll() {
    return ResponseEntity.ok(purchaseService.getAll());
  }

  @GetMapping("/client/{clientId}")
  public ResponseEntity<List<Purchase>> getByClientId(@PathVariable String clientId) {
    Optional<List<Purchase>> purchases = purchaseService.getByClientId(clientId);
    return purchases.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
  }
}
