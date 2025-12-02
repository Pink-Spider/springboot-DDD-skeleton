package io.pinkspider.dddskeleton.infrastructure.product;

import io.pinkspider.dddskeleton.domain.product.Product;
import io.pinkspider.dddskeleton.domain.product.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProductRepository implements ProductRepository {
    @Override
    public Product findById(Long id) {
        return new Product(id, "Sample");
    }

    @Override
    public void save(Product product) {
        System.out.println("Saved product: " + product.getName());
    }
}
