package com.api.design.Application.RetrievePolicy.Request;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.api.design.Mediator.Request;


//class CreateContactRequest extends the Request interface of MediatR
public class CreateRetrievePolicyRequest implements Request<Integer> {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "jsonb")
    private Map<String, Object> retrievePolicyJson;
    
    public CreateRetrievePolicyRequest() {
        // Default constructor
    }
	

	public CreateRetrievePolicyRequest(UUID id, Map<String, Object> retrievePolicyJson) {
		this.id = id;
		this.retrievePolicyJson = retrievePolicyJson;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public Map<String, Object> getRetrievePolicyJson() {
		return retrievePolicyJson;
	}
	
	public void setRetrievePolicyJson(Map<String, Object> retrievePolicyJson) {
		this.retrievePolicyJson = retrievePolicyJson;
	}
	
	
	
}



