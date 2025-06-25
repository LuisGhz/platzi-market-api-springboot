package dev.luisghtz.platzi_market.percistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.luisghtz.platzi_market.percistence.entities.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
  List<Producto> findByIdCategoria(Integer idCategoria);

  Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
