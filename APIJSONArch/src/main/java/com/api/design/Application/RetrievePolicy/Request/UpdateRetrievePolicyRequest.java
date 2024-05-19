package com.api.design.Application.RetrievePolicy.Request;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.api.design.Mediator.Request;

public class UpdateRetrievePolicyRequest implements Request<Integer> {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(columnDefinition = "jsonb")
    private Map<String, Object> retrievePolicyJson;
	

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
