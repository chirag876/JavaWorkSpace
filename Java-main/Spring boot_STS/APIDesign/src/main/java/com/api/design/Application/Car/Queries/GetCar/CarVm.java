package com.api.design.Application.Car.Queries.GetCar;

import java.util.List;

public class CarVm {

	public List<CarDTO> Lists;

	public CarVm(List<CarDTO> lists) {
		Lists = lists;
	}

	public CarVm() {
	}

	public List<CarDTO> getLists() {
		return Lists;
	}

	public void setLists(List<CarDTO> lists) {
		Lists = lists;
	}
	
}
