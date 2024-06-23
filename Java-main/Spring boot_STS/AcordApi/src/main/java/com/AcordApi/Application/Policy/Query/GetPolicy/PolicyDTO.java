package com.AcordApi.Application.Policy.Query.GetPolicy;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.AcordApi.Application.Domain.Entity.Policy;

public class PolicyDTO {
	
	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private Policy policy;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID PolicyId;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID QuoteId;

    @Column(columnDefinition = "jsonb")
    private String PolicyJson;

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public UUID getPolicyId() {
		return PolicyId;
	}

	public void setPolicyId(UUID policyId) {
		PolicyId = policyId;
	}

	public UUID getQuoteId() {
		return QuoteId;
	}

	public void setQuoteId(UUID quoteId) {
		QuoteId = quoteId;
	}

	public String getPolicyJson() {
		return PolicyJson;
	}

	public void setPolicyJson(String policyJson) {
		PolicyJson = policyJson;
	}
    
    

}
