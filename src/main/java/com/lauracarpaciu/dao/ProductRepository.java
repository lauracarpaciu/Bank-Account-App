package com.lauracarpaciu.dao;


import com.lauracarpaciu.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{
}
