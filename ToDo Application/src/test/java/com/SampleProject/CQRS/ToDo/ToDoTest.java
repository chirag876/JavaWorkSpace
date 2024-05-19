package com.SampleProject.CQRS.ToDo;

import java.math.BigDecimal;

import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.Test;

import com.SampleProject.CQRS.ToDo.aggregate.ToDoAggregate;
import com.SampleProject.CQRS.ToDo.command.CreateToDoCommand;
import com.SampleProject.CQRS.ToDo.event.CreateToDoEvent;



public class ToDoTest {
	
	 private static final String TaskName = "Meeting At 3pm";
	 private static final String Status = "Completed";
	 private static final int taskId = 1007;

	    private FixtureConfiguration<ToDoAggregate> fixture;
	    
	    @Test
	    public void should_dispatch_accountcreated_event_when_createaccount_command() {
	        fixture.givenNoPriorActivity()
	                .when(new CreateToDoCommand(
	                		taskId,
	                		TaskName,
	                		Status)
	                )
	                .expectEvents(new CreateToDoEvent(
	                        
	                        taskId,
	                		TaskName,
	                		Status)
	                );
	    }

}
