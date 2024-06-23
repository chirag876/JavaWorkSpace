package com.api.design.Application.Common.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.api.design.Domain.Entities.Car;

@Repository
@EnableJpaRepositories
public interface CarDAO extends JpaRepository<Car, Integer>{
	
}