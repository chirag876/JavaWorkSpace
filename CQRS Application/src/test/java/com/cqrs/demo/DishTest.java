package com.cqrs.demo;

import java.math.BigDecimal;

import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cqrs.demo.Aggregate.DishAggregate;
import com.cqrs.demo.Command.CreateDishCommand;
import com.cqrs.demo.Event.DishCreatedEvent;



import org.axonframework.test.aggregate.AggregateTestFixture;

import java.util.UUID;


public class DishTest {
	private static final int Id = 1;
	private static final String Name = "Bhature";
	private static final int Price = 67;
	

	    private FixtureConfiguration<DishAggregate> fixture;
	

	 

	    @Test
	    public void should_dispatch_dishcreated_event_when_createdish_command() {
	        fixture.givenNoPriorActivity()
	                .when(new CreateDishCommand(
	                        Id,
	                        Name,
	                        Price)
	                )
	                .expectEvents(new DishCreatedEvent(
	                        Id,
	                        Name,
	                        Price)
	                );
	    }


}
