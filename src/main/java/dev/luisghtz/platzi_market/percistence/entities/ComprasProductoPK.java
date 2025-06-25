package dev.luisghtz.platzi_market.percistence.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ComprasProductoPK implements Serializable {

  @Column(name = "id_compra")
  private Integer idCompra;
  @Column(name = "id_producto")
  private Integer idProducto;
}
