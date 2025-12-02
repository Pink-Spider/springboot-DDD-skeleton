package io.pinkspider.dddskeleton.application.product;

import io.pinkspider.dddskeleton.domain.product.Product;
import io.pinkspider.dddskeleton.domain.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void handle(Long id, String name) {
        Product product = new Product(id, name);
        productRepository.save(product);
    }
}
