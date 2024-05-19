package com.api.design.Application.RetrievePolicy.Request;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.api.design.Mediator.Request;

public class DeleteRetrievePolicyRequest implements Request<UUID> {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

   

	public DeleteRetrievePolicyRequest(UUID id) {
		this.id = id;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	

}
