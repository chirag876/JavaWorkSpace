package com.ApiDesign.Arch.Application.Domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.ApiDesign.Arch.Application.Common.Interface.IHasDomainEvent;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;

@Entity
@Table(name = "RETRIEVE_POLICY")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class RetrievePolicy {

	@javax.persistence.Id
	@Column(name = "ID")
	private UUID Id;

	@Type(type = "jsonb")
	@Column(name = "RETRIEVE_POLICY_JSON", columnDefinition = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	private Map<String, Object> RetrievePolicyJsonB;
	
	
	

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

	
	public List<DomainEvent> domainEvents() {
		List<DomainEvent> domainEvent = new ArrayList<>();
		return domainEvent;
	}
	
	

	
	
}
