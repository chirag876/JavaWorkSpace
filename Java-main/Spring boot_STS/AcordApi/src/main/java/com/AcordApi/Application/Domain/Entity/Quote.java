package com.AcordApi.Application.Domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import com.AcordApi.Application.Domain.Common.DomainEvent;
import org.springframework.data.domain.DomainEvents;

@Entity
@Table(name = "QUOTE")
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class Quote {
	
	// Defining the primary key field for the Entity
    @javax.persistence.Id
	@Column(name = "ID")
	private UUID Id = UUID.randomUUID();
    
	@Column(name = "QUOTE_ID")
	private UUID QuoteId = UUID.randomUUID();

    // Mapping the JSON data type using hibernate TypeDef
    @Type(type = "jsonb")
    @Column(name = "QUOTE_JSON", columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private Map<String, Object> QuoteJsonB;

	@Transient
	public List<DomainEvent> domainEvents = new ArrayList<>();
    
    public Quote() {
    	
    }

	public Quote(UUID id, UUID quoteId, Map<String, Object> quoteJsonB) {
		super();
		Id = id;
		QuoteId = quoteId;
		QuoteJsonB = quoteJsonB;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public UUID getQuoteId() {
		return QuoteId;
	}

	public void setQuoteId(UUID quoteId) {
		QuoteId = quoteId;
	}

	public Map<String, Object> getQuoteJsonB() {
		return QuoteJsonB;
	}

	public void setQuoteJsonB(Map<String, Object> quoteJsonB) {
		QuoteJsonB = quoteJsonB;
	}
	
	// Returns an empty list of DomainEvent objects
//    public List<DomainEvent> domainEvents() {
//        List<DomainEvent> domainEvent = new ArrayList<DomainEvent>();
//        return domainEvent;
//    }

	@DomainEvents
	public List<DomainEvent> domainEvents() {
		return domainEvents;
	}


	public List<DomainEvent> getDomainEvents() {
		return domainEvents;
	}

	public void setDomainEvents(List<DomainEvent> domainEvents) {
		this.domainEvents = domainEvents;
	}

}
