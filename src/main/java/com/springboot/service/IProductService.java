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
        List<Product> getProductByName(String name);
        List<Product> findByPriceBetween(double minPrice, double maxPrice);
        List<Product> getProductByNameAndPrice(String name, Double maxPrice);
        List<Product> getProductByNameOrQuantity(String name, int quantity);
        List<Product> getProductsByIds(List<Integer> id);
}
