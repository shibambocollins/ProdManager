package za.ac.cput.itemsmanager.controller;

import za.ac.cput.itemsmanager.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.itemsmanager.service.ProductService;

import java.util.List;


    @RestController
    @RequestMapping("/api/products")
    @RequiredArgsConstructor
    @CrossOrigin(origins = "http://localhost:3000")
    public class ProductController {

        private final ProductService productService;

        @GetMapping
        public List<Product> getAllProducts() {
            return productService.getAllProducts();
        }

        @GetMapping("/{id}")
        public Product getProductById(@PathVariable Long id) {
            return productService.getProductById(id);
        }

        @PostMapping
        public Product createProduct(@RequestBody Product product) {
            return productService.createProduct(product);
        }

        @PutMapping("/{id}")
        public Product updateProduct(
                @PathVariable Long id,
                @RequestBody Product product) {
            return productService.updateProduct(id, product);
        }

        @DeleteMapping("/{id}")
        public void deleteProduct(@PathVariable Long id) {
            productService.deleteProduct(id);
        }
    }
}
