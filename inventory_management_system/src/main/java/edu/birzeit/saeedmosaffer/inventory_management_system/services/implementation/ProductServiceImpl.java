package edu.birzeit.saeedmosaffer.inventory_management_system.services.implementation;


import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Product;
import edu.birzeit.saeedmosaffer.inventory_management_system.repository.ProductRepository;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optionalExistingProduct = productRepository.findById(product.getProductId());
        if (optionalExistingProduct.isPresent()) {
            Product existingProduct = optionalExistingProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setSupplierId(product.getSupplierId());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

