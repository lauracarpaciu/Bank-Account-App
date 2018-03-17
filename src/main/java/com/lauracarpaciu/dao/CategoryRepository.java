package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.catalog.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByCategoryName(@Param("categoryName") String categoryName);
}
