package com.AcordApi.Application.Policy.Request;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.AcordApi.Mediator.Request;

public class DeletePolicyRequest implements Request<Integer>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

	public DeletePolicyRequest(UUID id) {
		super();
		Id = id;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

}
