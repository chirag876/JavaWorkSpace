package com.SampleProject.CQRS.ToDo.projection;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.SampleProject.CQRS.ToDo.Entity.ToDo;
import com.SampleProject.CQRS.ToDo.Repository.TodoRepository;
import com.SampleProject.CQRS.ToDo.event.CreateToDoEvent;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data

@Slf4j
@RequiredArgsConstructor
@Component
public class ToDoProjection {

	private TodoRepository repository;
	@EventHandler
    public void on(CreateToDoEvent event) {
       
        ToDo todo = new ToDo(
                event.getTaskId(),
                event.getTaskName(),
                event.getStatus()
        );
        this.repository.save(todo);
    }
}
