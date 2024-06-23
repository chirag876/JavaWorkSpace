package com.cqrs.demo.Controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cqrs.demo.DTO.CarCreationDTO;
import com.cqrs.demo.Entity.Car;
import com.cqrs.demo.Service.CarCommandService;


import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/Car")
@AllArgsConstructor
public class CarCommandController {
	
	
	 private final CarCommandService carCommandService;
	    
	 
	    public CarCommandController(CarCommandService carCommandService) {
			this.carCommandService = carCommandService;
		}

		@PostMapping
	    @ResponseStatus(value = CREATED)
	    public CompletableFuture<Car> createCar(@RequestBody CarCreationDTO creationDTO) {
	        return this.carCommandService.createCar(creationDTO);
	    }

}
