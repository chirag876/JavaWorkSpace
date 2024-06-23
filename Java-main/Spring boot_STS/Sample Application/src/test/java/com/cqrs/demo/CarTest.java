package com.cqrs.demo;

import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import com.cqrs.demo.Events.CarCreatedEvent;
import com.cqrs.demoCommand.CreateCarCommand;

import com.cqrs.demo.Aggregate.CarAggregate;


public class CarTest {

	private static final int Id = 1;
	private static final String Name = "Swift";
	private static final String Model = "Dezire";
	

	    private FixtureConfiguration<CarAggregate> fixture;
	

	 

	    @Test
	    public void should_dispatch_carcreated_event_when_createdcar_command() {
	        fixture.givenNoPriorActivity()
	                .when(new CreateCarCommand(
	                        Id,
	                        Name,
	                        Model)
	                )
	                .expectEvents(new CarCreatedEvent(
	                        Id,
	                        Name,
	                        Model)
	                );
	    }

}
