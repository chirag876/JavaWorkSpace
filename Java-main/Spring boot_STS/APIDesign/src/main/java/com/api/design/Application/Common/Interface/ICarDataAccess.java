package com.api.design.Application.Common.Interface;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.api.design.Domain.Entities.Car;

@Repository
@Transactional
public interface ICarDataAccess {

	public Car AddCar(Car car);

	public List<Car> GetList();

	public Car get(int id);

	public Car UpdateCar(Car Car);
	
	int delete(int id);

}
