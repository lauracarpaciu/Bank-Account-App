package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findUserByuserName(@Param("user_name") String userName);
}
