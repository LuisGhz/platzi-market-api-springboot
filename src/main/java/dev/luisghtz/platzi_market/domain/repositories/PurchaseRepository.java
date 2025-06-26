package dev.luisghtz.platzi_market.domain.repositories;

import java.util.List;
import java.util.Optional;

import dev.luisghtz.platzi_market.domain.Purchase;

public interface PurchaseRepository {
  List<Purchase> getAll();

  Optional<List<Purchase>> getByClientId(String clientId);

  Purchase save(Purchase purchase);
}
