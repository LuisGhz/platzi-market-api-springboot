package dev.luisghtz.platzi_market.percistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import dev.luisghtz.platzi_market.domain.Category;
import dev.luisghtz.platzi_market.percistence.entities.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
      @Mapping(source = "categoriaId", target = "categoryId"),
      @Mapping(source = "descripcion", target = "category"),
      @Mapping(source = "estado", target = "active"),
  })
  Category toCategory(Categoria categoria);

  @InheritInverseConfiguration
  @Mapping(target = "productos", ignore = true)
  Categoria toCategoria(Category category);
}
