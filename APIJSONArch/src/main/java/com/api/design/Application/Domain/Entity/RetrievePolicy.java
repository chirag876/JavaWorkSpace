package com.api.design.Application.Domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import com.api.design.Application.Domain.Common.DomainEvent;

@Entity
@Table(name = "RETRIEVE_POLICY")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class RetrievePolicy {

	// Defining the primary key field for the Entity
	@javax.persistence.Id
	@Column(name = "ID")
	private UUID Id;

	// Mapping the JSON data type using hibernate TypeDef
	@Type(type = "jsonb")
	@Column(name = "RETRIEVE_POLICY_JSON", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private Map<String, Object> RetrievePolicyJsonB;

	// Getter method for retrieving Id
	public UUID getId() {
		return Id;
	}

	// Setter method for setting Id
	public void setId(UUID id) {
		Id = id;
	}

	// Getter method for retrieving RetrievePolicyJsonB
	public Map<String, Object> getRetrievePolicyJsonB() {
		return RetrievePolicyJsonB;
	}

	// Setter method for setting RetrievePolicyJsonB
	public void setRetrievePolicyJsonB(Map<String, Object> retrievePolicyJsonB) {
		RetrievePolicyJsonB = retrievePolicyJsonB;
	}

	// Returns an empty list of DomainEvent objects
	public List<DomainEvent> domainEvents() {
		List<DomainEvent> domainEvent = new ArrayList<DomainEvent>();
		return domainEvent;
	}

}
