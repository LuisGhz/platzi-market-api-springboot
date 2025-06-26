package dev.luisghtz.platzi_market.percistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dev.luisghtz.platzi_market.percistence.entities.Compra;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
  Optional<List<Compra>> findByIdCliente(String idCliente);
}
