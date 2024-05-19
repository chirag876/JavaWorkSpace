package com.SampleProject.CQRS.ToDo.Controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SampleProject.CQRS.ToDo.DTO.ToDoDTO;
import com.SampleProject.CQRS.ToDo.Entity.ToDo;
import com.SampleProject.CQRS.ToDo.Service.ToDoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "javainuseapi")
@RestController
@RequestMapping("/Todo")
public class ToDoController {
	
	private final ToDoService services;

	public ToDoController(ToDoService todoCommandServies) {
		
		this.services = todoCommandServies;
	}
	
	@PostMapping
	@ResponseStatus(value = CREATED)
    public CompletableFuture<ToDo> createAccount(@RequestBody ToDoDTO creationDTO) {
        return this.services.createAccount(creationDTO);
    }
}
