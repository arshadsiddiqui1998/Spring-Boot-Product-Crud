package com.springboot.api;


import com.springboot.entity.Product;
import com.springboot.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    //this is add api
    @PostMapping("/addproduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

    @GetMapping("/getproduct")
    public ResponseEntity<Product> getProductById(int id) {
        Product productById = productService.getProductById(id);
        return new ResponseEntity<>(productById, HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) {

        List<Product> productByName = productService.getProductByName(name);
        return new ResponseEntity<>(productByName, HttpStatus.OK);
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @GetMapping("/get_price")
    public ResponseEntity<List<Product>> getProductsInRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Product> findByPrice = productService.findByPriceBetween(minPrice, maxPrice);
        return new ResponseEntity<>(findByPrice, HttpStatus.OK);
    }
    @GetMapping("/find")
public ResponseEntity<List<Product>> getProductsByNameAndPrice(@RequestParam (required = false)String name, @RequestParam(required = false) Double price) {
        return new ResponseEntity<>(productService.getProductByNameAndPrice(name, price), HttpStatus.OK);
}
@GetMapping("/name-or-quantity")
public ResponseEntity<List<Product>> getProductByNameOrQuantity(@RequestParam String name, @RequestParam Integer quantity) {
        return new ResponseEntity<>(productService.getProductByNameOrQuantity(name, quantity), HttpStatus.OK);
}
@GetMapping("/by-ids")
public ResponseEntity <List<Product>> getProductsById(@RequestParam List<Integer> id) {
        return new ResponseEntity<>(productService.getProductsByIds(id), HttpStatus.OK);
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
