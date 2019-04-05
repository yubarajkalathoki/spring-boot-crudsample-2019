package com.imaginology.crudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginology.crudexample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
