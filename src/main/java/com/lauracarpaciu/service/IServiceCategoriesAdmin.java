package com.lauracarpaciu.service;


import com.lauracarpaciu.entities.catalog.Category;
import com.lauracarpaciu.entities.user.Role;
import com.lauracarpaciu.entities.user.User;

public interface IServiceCategoriesAdmin extends IServiceProductsAdmin {
    Category addCategory(Category c);

    void deleteCategory(Long idcat);

    void changeCategory(Category c);

    void addUser(User u);

    void addRole(Role r, Long userID);
    User getUserByUsername(String username);


}
