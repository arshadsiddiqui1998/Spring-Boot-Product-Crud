package com.springboot.repository;

import com.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
 // this is repo
List<Product> findByName(String name);
List<Product> findByPriceBetween(double minPrice, double maxPrice);
List<Product> getProductsByNameAndPrice(String name,Double price);
List<Product> getProductByNameOrQuantity(String name,int price);
List<Product> findByIdInOrderByIdDesc(List<Integer> ids);
}
