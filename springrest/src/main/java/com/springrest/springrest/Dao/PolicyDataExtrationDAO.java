package com.springrest.springrest.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.Entity.PolicyDataExtration;

@Repository
@EnableJpaRepositories
public interface PolicyDataExtrationDAO extends JpaRepository<PolicyDataExtration, Integer> {

}