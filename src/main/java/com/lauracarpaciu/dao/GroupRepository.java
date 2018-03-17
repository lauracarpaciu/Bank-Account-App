package com.lauracarpaciu.dao;

import com.lauracarpaciu.entities.bankAccount.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long>{
}
