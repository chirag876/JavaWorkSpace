package com.springrest.springrest.Entity;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@Table(name = "POLICY")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class policy {

	// Defining the primary key field for the Entity
	@javax.persistence.Id
	@Column(name = "ID")
	private UUID Id = UUID.randomUUID();

	@Column(name = "POLICY_ID")
	private UUID PolicyId = UUID.randomUUID();

	@Column(name = "QUOTE_ID")
	private UUID QuoteId = UUID.randomUUID();

	// Mapping the JSON data type using hibernate TypeDef
	@Type(type = "jsonb")
	@Column(name = "POLICY_JSON", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private JsonNode PolicyJsonB;

	public policy() {

	}

	public policy(UUID id, UUID policyId, UUID quoteId, JsonNode policyJsonB) {
		super();
		Id = id;
		PolicyId = policyId;
		QuoteId = quoteId;
		PolicyJsonB = policyJsonB;
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

	public JsonNode getPolicyJsonB() {
		return PolicyJsonB;
	}

	public void setPolicyJsonB(JsonNode policyJsonB) {
		PolicyJsonB = policyJsonB;
	}

	// Returns an empty list of DomainEvent objects

}
