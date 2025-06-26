package dev.luisghtz.platzi_market.percistence;

import java.util.List;
import java.util.Optional;

import dev.luisghtz.platzi_market.domain.Purchase;
import dev.luisghtz.platzi_market.domain.repositories.PurchaseRepository;
import dev.luisghtz.platzi_market.percistence.crud.CompraCrudRepository;
import dev.luisghtz.platzi_market.percistence.entities.Compra;
import dev.luisghtz.platzi_market.percistence.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompraRepository implements PurchaseRepository {
  private final CompraCrudRepository compraCrudRepository;
  private final PurchaseMapper purchaseMapper;

  @Override
  public List<Purchase> getAll() {
    return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClientId(String clientId) {
    return compraCrudRepository.findByIdCliente(clientId)
        .map(compras -> purchaseMapper.toPurchases(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    var compra = purchaseMapper.toCompra(purchase);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));
    return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
  }

}
