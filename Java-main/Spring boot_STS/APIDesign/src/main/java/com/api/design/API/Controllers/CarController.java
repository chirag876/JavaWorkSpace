package com.api.design.API.Controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.design.Application.Car.Queries.GetCar.CarVm;
import com.api.design.Application.Car.Request.CreateCar.CreateCarRequest;
import com.api.design.Application.Car.Request.DeleteCar.DeleteCarRequest;
import com.api.design.Application.Car.Request.UpdateCar.UpdateCarRequest;
import com.api.design.Mediator.Mediator;
import com.api.design.Application.Car.Queries.GetCar.GetCarQuery;

@RestController
public class CarController {
	private final Mediator mediator;

	public CarController(Mediator mediator) {
		this.mediator = mediator;
	}

	@PostMapping("/createcar")
	public Integer create(@Valid @RequestBody CreateCarRequest request) {
		return mediator.send(request);

	}

	@GetMapping("/Get")
	public CarVm getAll() {
		return mediator.send(new GetCarQuery());
	}

	@PutMapping("/Update")
	public Integer Update(@RequestBody UpdateCarRequest request) {
		return mediator.send(request);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id) {
		mediator.send(new DeleteCarRequest(id));
		return ResponseEntity.ok().build();
	}

}
