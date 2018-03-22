package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.*;


import com.lauracarpaciu.entities.cart.ShoppingCart;
import com.lauracarpaciu.entities.catalog.Category;
import com.lauracarpaciu.entities.customer.Customer;
import com.lauracarpaciu.entities.order.Order;
import com.lauracarpaciu.entities.product.Product;
import com.lauracarpaciu.entities.user.Role;
import com.lauracarpaciu.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ServiceWebsiteImpl implements IServiceCategoriesAdmin {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Category addCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(Long idcat) {
        categoryRepository.delete(idcat);

    }

    @Override
    public void changeCategory(Category c) {
        categoryRepository.;

    }

    @Override
    public void addUser(User u) {
        userRepository.save(u);


    }

    @Override
    public void addRole(Role r, Long userID) {
        userRepository.save(r, userID);

    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }


    @Override
    public Product addProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public void deleteProduct(Long idP) {
        productRepository.delete(idP);


    }

    @Override
    public void changeProduct(Product p) {
        productRepository.;

    }

    @Override
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long idCat) {
        return categoryRepository.getOne(idCat);
    }

    @Override
    public List<Product> productslist() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> productsbykeyname(String kn) {
        return dao.productsbykeyname(kn);
    }

    @Override
    public List<Product> productsbyCategory(Long idCat) {
        return dao.productsbyCategory(idCat);
    }

    @Override
    public List<Product> selectedProducts() {
        return dao.selectedProducts();
    }

    @Override
    public Product getProduct(Long idP) {
        return dao.getProduct(idP);
    }

    @Override
    public Order addOrder(ShoppingCart cart, Customer c) {
        return null;
    }

    @Override
    public Order addOrder(Cart cart, Client c) {
        return dao.addOrder(cart, c);
    }
}
