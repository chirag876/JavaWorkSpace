package com.AcordApi.Application.Common.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.AcordApi.Application.Domain.Entity.Quote;

@Repository
@EnableJpaRepositories
public interface QuoteDAO extends JpaRepository<Quote, UUID>{

}
