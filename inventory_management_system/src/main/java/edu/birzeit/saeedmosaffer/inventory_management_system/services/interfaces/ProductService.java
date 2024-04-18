package edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces;

import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(Long productId);
}