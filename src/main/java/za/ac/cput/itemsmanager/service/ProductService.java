package za.ac.cput.itemsmanager.service;

import za.ac.cput.itemsmanager.entity.Product;
import za.ac.cput.itemsmanager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
    public class ProductService {

        private final ProductRepository productRepository;

        public List<Product> getAllProducts() {

            return productRepository.findAll();
        }

        public Product getProductById(Long id) {

            return productRepository.findById(id).orElse(null);
        }

        public Product createProduct(Product product) {

            return productRepository.save(product);
        }

        public Product updateProduct(Long id, Product product) {
            return productRepository.findById(id).map(existing -> {
                existing.setName(product.getName());
                existing.setPrice(product.getPrice());
                existing.setDescription(product.getDescription());
                return productRepository.save(existing);
            }).orElse(null);
        }

        public boolean deleteProduct(Long id) {
            if (!productRepository.existsById(id)) {
                return false;
            }
            productRepository.deleteById(id);
            return true;
        }
    }

