package com.springrest.springrest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.Entity.policy;

@Repository
@EnableJpaRepositories
public interface PolicyDAO  extends JpaRepository<policy, Integer>{

}

