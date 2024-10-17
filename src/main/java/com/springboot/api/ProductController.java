package com.springboot.api;


import com.springboot.entity.Product;
import com.springboot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
   private ProductServiceImpl productService;
    @PostMapping("/addproduct")
    public ResponseEntity<Product>  addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return new ResponseEntity<> (createdProduct, HttpStatus.CREATED);
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProduct = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
    }
    @GetMapping("/getproduct")
    public ResponseEntity<Product> getProductById(int id) {
        Product productById = productService.getProductById(id);
        return new ResponseEntity<>(productById, HttpStatus.OK);

    }
    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id ,@RequestBody Product product ) {
        Product updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
