package com.lauracarpaciu.dao;
import com.lauracarpaciu.entities.catalog.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
}
