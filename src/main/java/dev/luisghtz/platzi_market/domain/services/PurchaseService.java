package dev.luisghtz.platzi_market.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.luisghtz.platzi_market.domain.Purchase;
import dev.luisghtz.platzi_market.percistence.CompraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseService {
  private final CompraRepository compraRepository;

  public List<Purchase> getAll() {
    return compraRepository.getAll();
  }

  public Optional<List<Purchase>> getByClientId(String clientId) {
    return compraRepository.getByClientId(clientId);
  }

  public Purchase save(Purchase purchase) {
    return compraRepository.save(purchase);
  }
}
