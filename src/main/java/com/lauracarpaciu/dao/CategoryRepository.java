package com.lauracarpaciu.dao;
import com.lauracarpaciu.entity.catalog.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
}
