package dev.luisghtz.platzi_market.percistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.luisghtz.platzi_market.domain.Product;
import dev.luisghtz.platzi_market.domain.repositories.ProductRepository;
import dev.luisghtz.platzi_market.percistence.crud.ProductoCrudRepository;
import dev.luisghtz.platzi_market.percistence.entities.Producto;
import dev.luisghtz.platzi_market.percistence.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductoRepository implements ProductRepository {
  private final ProductoCrudRepository productoCrudRepository;
  private final ProductMapper productMapper;

  @Override
  public List<Product> getAll() {
    var productos = (List<Producto>) productoCrudRepository.findAll();
    return productMapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    var productos = (List<Producto>) productoCrudRepository.findByIdCategoria(categoryId);
    return Optional.of(productMapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getScarseProducts(int quantity) {
    var productos = (Optional<List<Producto>>) productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,
        false);
    return productos.map(prods -> productMapper.toProducts(prods));
  }

  @Override
  public Optional<Product> getById(int productId) {
    var producto = productoCrudRepository.findById(productId);
    return producto.map(prod -> productMapper.toProduct(prod));
  }

  @Override
  public Product save(Product product) {
    Producto producto = productMapper.toProducto(product);
    return productMapper.toProduct(productoCrudRepository.save(producto));
  }

  public void delete(int idProducto) {
    productoCrudRepository.deleteById(idProducto);
  }
}
