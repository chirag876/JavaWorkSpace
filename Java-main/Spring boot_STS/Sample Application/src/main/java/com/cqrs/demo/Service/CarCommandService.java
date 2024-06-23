package com.cqrs.demo.Service;


import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;


import org.springframework.stereotype.Service;

import com.cqrs.demo.DTO.CarCreationDTO;
import com.cqrs.demo.Entity.Car;
import com.cqrs.demoCommand.CreateCarCommand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarCommandService {
	
	private final CommandGateway commandGateway;

	public CarCommandService(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	

	public CompletableFuture<Car> createCar(CarCreationDTO creationDTO) {
        return this.commandGateway.send(new CreateCarCommand(
                creationDTO.getId(),
                creationDTO.getName(),
                creationDTO.getModel()
        ));
    }

}
