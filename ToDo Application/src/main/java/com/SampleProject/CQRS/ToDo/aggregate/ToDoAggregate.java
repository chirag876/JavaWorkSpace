package com.SampleProject.CQRS.ToDo.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.SampleProject.CQRS.ToDo.command.CreateToDoCommand;
import com.SampleProject.CQRS.ToDo.event.CreateToDoEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class ToDoAggregate {
	@AggregateIdentifier
	private int taskId;
	private String TaskName;
	private String Status;
	
	@CommandHandler
    public ToDoAggregate(CreateToDoCommand command) {

        AggregateLifecycle.apply(
                new CreateToDoEvent(
                        command.getTaskId(),
                        command.getTaskName(),
                        command.getStatus()
                )
        );
    }

}
