package com.lauracarpaciu.service.catalog;

import com.lauracarpaciu.dao.*;
import com.lauracarpaciu.dao.catalog.IDAOWebsite;
import com.lauracarpaciu.entities.*;

import com.lauracarpaciu.entities.catalog.Category;
import com.lauracarpaciu.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ServiceWebsiteImpl implements IServiceCategoriesAdmin {

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
        dao.addUser(u);


    }

    @Override
    public void addRole(Role r, Long userID) {
        dao.addRole(r, userID);

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
    public Order addOrder(Cart cart, Client c) {
        return dao.addOrder(cart, c);
    }
}
