package com.springrest.springrest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springrest.springrest.Entity.Quote;

@Repository
@EnableJpaRepositories
public interface QuoteDAO  extends JpaRepository<Quote, Integer>{

}


