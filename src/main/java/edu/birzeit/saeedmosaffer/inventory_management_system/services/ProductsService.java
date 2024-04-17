package edu.birzeit.saeedmosaffer.inventory_management_system.services;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Products;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class ProductsService {

    private final Map<String, Products> products = new HashMap<>();
    private static final AtomicLong idCounter = new AtomicLong();


    public List<Products> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Products getProductById(String id) {
        return products.get(id);
    }

    public Products createProduct(Products product) {
        String id = generateUniqueId();
        product.setProductID(Integer.parseInt(id));
        products.put(id, product);
        return product;
    }

    public Products updateProduct(String id, Products product) throws ProductNotFoundException {
        if (products.containsKey(id)) {
            product.setProductID(Integer.parseInt(id));
            products.put(id, (Products) products);
            return product;
        }
        else {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }    }

    public boolean deleteProduct(String id) {
        return products.remove(id) != null;
    }

    public String generateUniqueId() {
        long timestamp = System.currentTimeMillis();
        long randomNumber = idCounter.incrementAndGet();
        return timestamp + "-" + randomNumber;
    }

    public class ProductNotFoundException extends Throwable {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }
}
