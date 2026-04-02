package RelatedProducts.model.mapper;

import RelatedProducts.model.dto.ProductDto;
import RelatedProducts.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
}
