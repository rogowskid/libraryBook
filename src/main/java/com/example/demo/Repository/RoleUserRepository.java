package com.example.demo.Repository;

import com.example.demo.Entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository extends JpaRepository <RoleUser, Integer> {


    public RoleUser findBynameRole (String rolename);


}
