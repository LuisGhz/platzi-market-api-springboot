package dev.luisghtz.platzi_market.percistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import dev.luisghtz.platzi_market.domain.PurchaseItem;
import dev.luisghtz.platzi_market.percistence.entities.ComprasProducto;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {
  @Mappings({
      @Mapping(source = "id.idProducto", target = "productId"),
      @Mapping(source = "cantidad", target = "quantity"),
      @Mapping(source = "total", target = "total"),
      @Mapping(source = "estado", target = "active"),
  })
  PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);

  @InheritInverseConfiguration
  @Mappings({
      @Mapping(target = "compra", ignore = true),
      @Mapping(target = "producto", ignore = true),
      @Mapping(target = "id.idCompra", ignore = true)
  })
  ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
