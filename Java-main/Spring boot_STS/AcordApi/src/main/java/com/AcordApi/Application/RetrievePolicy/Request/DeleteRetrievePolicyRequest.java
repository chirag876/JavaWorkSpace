package com.AcordApi.Application.RetrievePolicy.Request;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.AcordApi.Mediator.Request;

public class DeleteRetrievePolicyRequest implements Request<Integer>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

	public DeleteRetrievePolicyRequest(UUID id) {
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
