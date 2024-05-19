package com.SampleProject.CQRS.ToDo.Service;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SampleProject.CQRS.ToDo.DTO.ToDoDTO;
import com.SampleProject.CQRS.ToDo.Entity.ToDo;
import com.SampleProject.CQRS.ToDo.command.CreateToDoCommand;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ToDoService {
	
	 private  CommandGateway commandGateway;
	 
	 @Autowired
	 public ToDoService(CommandGateway commandGateway) {
			
			this.commandGateway = commandGateway;
		}
	 

		public CompletableFuture<ToDo> createAccount(ToDoDTO creationDTO) {
	        return this.commandGateway.send(new CreateToDoCommand(	                
	                creationDTO.getTaskId(),
	                creationDTO.getTaskName(),
	                creationDTO.getStatus()
	        ));
	    }

}
