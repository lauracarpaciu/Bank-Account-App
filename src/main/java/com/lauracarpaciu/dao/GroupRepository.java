package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.bankAccount.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GroupRepository extends JpaRepository<Group,Long>{
}
