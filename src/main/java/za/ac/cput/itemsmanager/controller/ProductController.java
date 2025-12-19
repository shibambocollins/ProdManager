package za.ac.cput.itemsmanager.controller;

import org.springframework.http.ResponseEntity;
import za.ac.cput.itemsmanager.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.itemsmanager.service.ProductService;

import java.util.List;


    @RestController
    @RequestMapping("/api/products")
    @RequiredArgsConstructor
    public class ProductController {

        private final ProductService productService;

        @GetMapping
        public ResponseEntity <List<Product>> getAllProducts() {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        }

        @GetMapping("/{id}")
        public ResponseEntity <Product> getProductById(@PathVariable Long id) {
            Product product = productService.getProductById(id);

            if(product == null) {
                return ResponseEntity.notFound().build();
            }

           return ResponseEntity.ok(product);
        }

        @PostMapping
        public ResponseEntity <Product> createProduct(@RequestBody Product product) {
            Product created = productService.createProduct(product);
            return ResponseEntity.status(201).body(created);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
            Product updated = productService.updateProduct(id, product);

            if(updated == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updated);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity <Void> deleteProduct(@PathVariable Long id) {

            boolean deleted = productService.deleteProduct(id);

            if(!deleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        }
    }

