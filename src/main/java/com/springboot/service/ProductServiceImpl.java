package com.springboot.service;

import com.springboot.entity.Product;
import com.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
     private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> addProducts(List<Product> products) {

        return null;

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public Product updateProduct(Product product, int id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found" +id+" with id"));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found" +id));
    }
    @Override
    public void deleteProduct(int id) {
productRepository.deleteById(id);
    }

}
