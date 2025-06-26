package dev.luisghtz.platzi_market.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.luisghtz.platzi_market.domain.Purchase;
import dev.luisghtz.platzi_market.domain.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseService {
  private final PurchaseRepository purchaseRepository;

  public List<Purchase> getAll() {
    return purchaseRepository.getAll();
  }

  public Optional<List<Purchase>> getByClientId(String clientId) {
    return purchaseRepository.getByClientId(clientId);
  }

  public Purchase save(Purchase purchase) {
    return purchaseRepository.save(purchase);
  }
}
