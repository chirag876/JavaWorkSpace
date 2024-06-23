package com.AcordApi.Application.RetrievePolicy.Request;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.AcordApi.Mediator.Request;
import com.fasterxml.jackson.annotation.JsonProperty;

//class CreateContactRequest extends the Request interface of MediatR
public class CreateRetrievePolicyRequest implements Request<Integer>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID RetrievePolicyId;

	
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> RetrievePolicyJson;
    
    public CreateRetrievePolicyRequest() {}
    
	public CreateRetrievePolicyRequest(UUID id, UUID retrievePolicyId, Map<String, Object> retrievePolicyJson) {
		super();
		Id = id;
		RetrievePolicyId = retrievePolicyId;
		RetrievePolicyJson = retrievePolicyJson;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public UUID getRetrievePolicyId() {
		return RetrievePolicyId;
	}

	public void setRetrievePolicyId(UUID retrievePolicyId) {
		RetrievePolicyId = retrievePolicyId;
	}

	public Map<String, Object> getRetrievePolicyJson() {
		return RetrievePolicyJson;
	}

	public void setRetrievePolicyJson(Map<String, Object> retrievePolicyJson) {
		RetrievePolicyJson = retrievePolicyJson;
	}

}
