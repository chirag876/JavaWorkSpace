package com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.design.Application.Domain.Entity.RetrievePolicy;

public class RetrievePolicyDTO {

	ModelMapper mapper = new ModelMapper();

	@Autowired
	private RetrievePolicy retrievepolicy;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(columnDefinition = "jsonb")
	private String retrievePolicyJson;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRetrievePolicyJson() {
		return retrievePolicyJson;
	}

	public void setRetrievePolicyJson(String retrievePolicyJson) {
		this.retrievePolicyJson = retrievePolicyJson;
	}

}
