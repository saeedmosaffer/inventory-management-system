package edu.birzeit.saeedmosaffer.inventory_management_system.controllers;

import edu.birzeit.saeedmosaffer.inventory_management_system.models.Products;
import edu.birzeit.saeedmosaffer.inventory_management_system.services.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsRestController {
    private final ProductsService productsService;

    public ProductsRestController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public ResponseEntity<List<Products>> getProducts(){
        List<Products> products = productsService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable String id){
        Products product = productsService.getProductById(id);
        if(product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products product){
        Products createdProduct = productsService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable String id, @RequestBody Products product) throws ProductsService.ProductNotFoundException {
        Products updatedProduct = productsService.updateProduct(id, product);
        if(updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id){
        boolean deleted = productsService.deleteProduct(id);
        if(deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
