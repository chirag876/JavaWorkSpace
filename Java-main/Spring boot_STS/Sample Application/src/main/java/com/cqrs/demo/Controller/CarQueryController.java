package com.cqrs.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqrs.demo.Entity.Car;
import com.cqrs.demo.Service.CarQueryService;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@SecurityRequirement(name = "javainuseapi")
@RestController
@RequestMapping("/Car")
@AllArgsConstructor
public class CarQueryController {

	private final CarQueryService carQueryService;
    
	 
    public CarQueryController(CarQueryService carQueryService) {
		this.carQueryService = carQueryService;
	}
    
	@GetMapping("/{Id}")
    public ResponseEntity<List<Car>> getCarById(@PathVariable String Id) {
        List<Car> car = carQueryService.findbyid(Id);
        if (car == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }
    
//
//    @GetMapping("/{Id}/events")
//    public List<Object> listEventsForCar(@PathVariable(value = "Id") String Id) {
//        return this.carQueryService.listEventsForCar(Id);
//    }
}
