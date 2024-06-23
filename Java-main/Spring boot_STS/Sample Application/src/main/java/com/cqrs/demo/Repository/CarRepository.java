package com.cqrs.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cqrs.demo.Entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

}
