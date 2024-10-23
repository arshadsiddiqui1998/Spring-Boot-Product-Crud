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

    //this service is using for add the product in to db
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
//this service is use for add multiple product
    @Override
    public List<Product> addProducts(List<Product> products) {

        return productRepository.saveAll(products);

    }
//this service is use for get all product
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    //this service is use for update for product
    @Override
    public Product updateProduct(Product product, int id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found" +id+" with id"));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
//this service is using for get the data from id
    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found" +id));
    }

    //this service is using for get the data from name
    public List<Product> getProductByName(String name) {
       return productRepository.findByName(name);
    }
    //this service is use for find by price between maximum and minimum
    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);

    }
//this service is use for get product by name and price
    @Override

        public List<Product> getProductByNameAndPrice(String name, Double price){
        return productRepository.getProductsByNameAndPrice(name,price);
    }
    //this service is use for get by name or quantity
    @Override
    public List<Product> getProductByNameOrQuantity(String name, int quantity) {
        return productRepository.getProductByNameOrQuantity(name,quantity);

    }
//this service is use for get product by id in desc order
    @Override
    public List<Product> getProductsByIds(List<Integer> ids) {
        return productRepository.findByIdInOrderByIdDesc(ids);
    }
//this service is use for deleting the product
    @Override
    public void deleteProduct(int id) {
productRepository.deleteById(id);
    }

}
