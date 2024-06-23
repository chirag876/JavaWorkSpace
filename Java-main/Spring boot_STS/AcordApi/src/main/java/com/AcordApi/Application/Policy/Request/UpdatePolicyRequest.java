package com.AcordApi.Application.Policy.Request;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.AcordApi.Mediator.Request;

public class UpdatePolicyRequest implements Request<Integer>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID PolicyId;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID QuoteId;

    @Column(columnDefinition = "jsonb")
    private Map<String, Object> PolicyJson;

	public UpdatePolicyRequest(UUID id, UUID policyId, UUID quoteId, Map<String, Object> policyJson) {
		super();
		Id = id;
		PolicyId = policyId;
		QuoteId = quoteId;
		PolicyJson = policyJson;
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

	public Map<String, Object> getPolicyJson() {
		return PolicyJson;
	}

	public void setPolicyJson(Map<String, Object> policyJson) {
		PolicyJson = policyJson;
	}

}
