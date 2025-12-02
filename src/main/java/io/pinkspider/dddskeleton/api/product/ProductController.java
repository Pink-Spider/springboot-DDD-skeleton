package io.pinkspider.dddskeleton.api.product;

import io.pinkspider.dddskeleton.application.product.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void create(@RequestParam Long id, @RequestParam String name) {
        productService.handle(id, name);
    }
}
