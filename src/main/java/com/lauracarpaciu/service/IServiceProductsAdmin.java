package com.lauracarpaciu.service;


import com.lauracarpaciu.entities.product.Product;

public interface IServiceProductsAdmin extends ServiceInternet {

    Product addProduct(Product p);

    void deleteProduct(Long idP);

    void changeProduct(Product p);
}
