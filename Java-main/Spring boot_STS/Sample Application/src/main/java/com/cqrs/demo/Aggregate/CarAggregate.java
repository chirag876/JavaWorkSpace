package com.cqrs.demo.Aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.cqrs.demo.Events.CarCreatedEvent;
import com.cqrs.demoCommand.CreateCarCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class CarAggregate {

	@AggregateIdentifier
	private int Id;
	private String Name;
	private String Model;
	
	@CommandHandler
    public CarAggregate(CreateCarCommand command) {

        AggregateLifecycle.apply(
                new CarCreatedEvent(
                        command.getId(),
                        command.getName(),
                        command.getModel()
                )
        );
    }

    @EventSourcingHandler
    public void on(CarCreatedEvent event) {
        this.Id = event.getId();
        this.Name = event.getName();
        this.Model = event.getModel();
    }
}
