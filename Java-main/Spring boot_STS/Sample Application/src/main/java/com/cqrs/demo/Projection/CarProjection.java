package com.cqrs.demo.Projection;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import com.cqrs.demo.Entity.Car;
import com.cqrs.demo.Events.CarCreatedEvent;
import com.cqrs.demo.Repository.CarRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data

@Slf4j
@RequiredArgsConstructor
@Component
public class CarProjection {
	private CarRepository repository;
	@EventHandler
    public void on(CarCreatedEvent event) {
       
        Car car = new Car(
                event.getId(),
                event.getName(),
                event.getModel()
        );
        this.repository.save(car);
    }
}
