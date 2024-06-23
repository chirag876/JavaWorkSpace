package com.AcordApi.Application.Quote.Request;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.AcordApi.Mediator.Request;

//class CreateContactRequest extends the Request interface of MediatR
public class CreateQuoteRequest implements Request<Integer>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID QuoteId;

    @Column(columnDefinition = "jsonb")
    private Map<String, Object> QuoteJson;
    
    public CreateQuoteRequest() {}

	public CreateQuoteRequest(UUID id, UUID quoteId, Map<String, Object> quoteJson) {
		super();
		Id = id;
		QuoteId = quoteId;
		QuoteJson = quoteJson;
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

	public Map<String, Object> getQuoteJson() {
		return QuoteJson;
	}

	public void setQuoteJson(Map<String, Object> quoteJson) {
		QuoteJson = quoteJson;
	}

}
