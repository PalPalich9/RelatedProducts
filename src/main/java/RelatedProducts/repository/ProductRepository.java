package RelatedProducts.repository;

import RelatedProducts.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByExternalCode(UUID externalCode);
    Optional<Product> findByCharacterCode(String externalCode);
}
