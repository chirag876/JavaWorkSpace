package com.api.design.Application.Car.Queries.GetCar;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.design.Application.Common.Interface.ICarDataAccess;

import com.api.design.Mediator.RequestHandler;

@Component
public class GetCarQueryHandler implements RequestHandler<GetCarQuery, CarVm> {

	Logger LOGGER = LoggerFactory.getLogger(GetCarQueryHandler.class);
	ModelMapper mapper = new ModelMapper();
	@Autowired
	private ICarDataAccess _dataAcces;

	@Override
	public CarVm handle(GetCarQuery request) {
		CarVm ContactVm = new CarVm();
		ContactVm.setLists(mapper.map(_dataAcces.GetList(), new TypeToken<List<CarDTO>>() {
		}.getType()));
		return ContactVm;
	}
}