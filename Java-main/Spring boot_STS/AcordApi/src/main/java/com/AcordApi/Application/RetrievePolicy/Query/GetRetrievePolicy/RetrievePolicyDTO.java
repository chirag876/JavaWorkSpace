package com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.AcordApi.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyDTO {
	
	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private RetrievePolicy retrievepolicy;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID RetrievePolicyId;

    @Column(columnDefinition = "jsonb")
    private String RetrievePolicyJson;

	

	public RetrievePolicy getRetrievepolicy() {
		return retrievepolicy;
	}

	public void setRetrievepolicy(RetrievePolicy retrievepolicy) {
		this.retrievepolicy = retrievepolicy;
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

	public String getRetrievePolicyJson() {
		return RetrievePolicyJson;
	}

	public void setRetrievePolicyJson(String retrievePolicyJson) {
		RetrievePolicyJson = retrievePolicyJson;
	}
	

}
