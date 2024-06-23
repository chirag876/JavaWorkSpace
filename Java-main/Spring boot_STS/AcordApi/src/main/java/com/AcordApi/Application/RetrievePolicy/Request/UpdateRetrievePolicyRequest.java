package com.AcordApi.Application.RetrievePolicy.Request;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.AcordApi.Mediator.Request;

public class UpdateRetrievePolicyRequest implements Request<Integer>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID RetrievePolicyId;

    @Column(columnDefinition = "jsonb")
    private Map<String, Object> RetrievePolicyJson;

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
