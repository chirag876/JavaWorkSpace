package com.ApiDesign.Arch.Application.RetrievePolicy.Query.GetRetrivePolicy;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyDTO {
	
	@Autowired
	private  RetrievePolicy retrievePolicy;
	
	
	@javax.persistence.Id
	@Column(name = "ID")
	private UUID Id;

	@Type(type = "jsonb")
	@Column(name = "RETRIEVE_POLICY_JSON", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private Map<String, Object> RetrievePolicyJsonB;

	public RetrievePolicy getRetrievePolicy() {
		return retrievePolicy;
	}

	public void setRetrievePolicy(RetrievePolicy retrievePolicy) {
		this.retrievePolicy = retrievePolicy;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public Map<String, Object> getRetrievePolicyJsonB() {
		return RetrievePolicyJsonB;
	}

	public void setRetrievePolicyJsonB(Map<String, Object> retrievePolicyJsonB) {
		RetrievePolicyJsonB = retrievePolicyJsonB;
	}
	
	
	

}
