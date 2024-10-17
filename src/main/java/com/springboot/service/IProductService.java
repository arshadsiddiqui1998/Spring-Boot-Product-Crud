package com.springboot.service;

import com.springboot.entity.Product;

import java.util.List;

public interface IProductService {
    public Product addProduct(Product product);
    List<Product> addProducts(List<Product> products);
    public Product updateProduct( Product product,int id);
        public Product getProductById(int id);
        public List<Product> getAllProduct();
        public void deleteProduct(int id);
}
