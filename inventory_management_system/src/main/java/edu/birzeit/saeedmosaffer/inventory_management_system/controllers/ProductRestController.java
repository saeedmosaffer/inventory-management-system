package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;


import edu.birzeit.saeedmosaffer.inventory_management_system.entity.Product;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductRestController {

    private ProductService productService;

    // create Product REST API
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // get product by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId){
        Product product = productService.getProductById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // get all products REST API
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // update Product REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,
                                                 @RequestBody Product product){
        product.setProductId(productId);
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete Product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }
}

