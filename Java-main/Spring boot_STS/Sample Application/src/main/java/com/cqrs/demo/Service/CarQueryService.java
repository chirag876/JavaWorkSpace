package com.cqrs.demo.Service;


import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqrs.demo.Entity.Car;
import com.cqrs.demo.Repository.CarRepository;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarQueryService {

	@Autowired
	private final CarRepository carRepository;
    private final QueryGateway queryGateway;
    private final EventStore eventStore;
	public CarQueryService(CarRepository carRepository, QueryGateway queryGateway, EventStore eventStore) {
		this.carRepository = carRepository;
		this.queryGateway = queryGateway;
		this.eventStore = eventStore;
	}
    
    public List<Object> listEventsForAccount(String Id) {
        return this.eventStore
                .readEvents((Id).toString())
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }

public List<Car> findbyid(String Id)
{
	return carRepository.findAll();
}
}
