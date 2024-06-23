package com.api.design.Infrastructure.DataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.api.design.Domain.Entities.Car;

import com.api.design.Application.Common.DAO.CarDAO;
import com.api.design.Application.Common.Interface.ICarDataAccess;
import com.api.design.Application.Common.Interface.IDomainEventService;

@Service
public class CarDataAccess implements ICarDataAccess {
	@Autowired
	private CarDAO carDao;
	@Autowired
	private IDomainEventService domainEventService;

	Logger LOGGER = LoggerFactory.getLogger(CarDataAccess.class);

	@Override
	public Car AddCar(Car car) {

		try {
			LOGGER.trace("CarDataAccess.AddCar - In process");

			carDao.save(car);
		} catch (Exception ex) {
			LOGGER.error("CarDataAccess.AddCar" + ex.getMessage());

		}
		DispatchEvents(car);
		return car;
	}

	@Override
	public List<Car> GetList() {

		return carDao.findAll();

	}

	@Override
	public Car get(int id) {
		return carDao.getById(id);
	}

	@Override
	public Car UpdateCar(Car car) {
		try {
			LOGGER.trace("CarDataAccess.AddCar - In process");
			Car entity = carDao.getById(car.getId());
			if (entity == null) {
				return null;
			} else {
				// entity.setId(car.getId()); // Set the ID to the original car's ID
				entity.setName(car.getName()); // Set the new value for the name property
				entity.setModel(car.getModel()); // Set the color to the original car's model
				carDao.save(entity); // Save the updated car object to the data store

				// carDao.save(car);
			}
		} catch (Exception ex) {
			LOGGER.error("CarDataAccess.AddCar" + ex.getMessage());

		}

		DispatchEvents(car);
		return car;
	}

	public int delete(int id) {
		try {
			carDao.deleteById(id);
			return 1;
		} catch (EmptyResultDataAccessException e) {
			throw new CarNotFoundException("Could not find car with id " + id);
		}
	}

	public class CarNotFoundException extends RuntimeException {
		public CarNotFoundException(String message) {
			super(message);
		}
	}

	public void DispatchEvents(Car entity) {
		domainEventService.Publish(entity.domainEvents());
	}

}
