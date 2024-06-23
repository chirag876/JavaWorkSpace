package com.AcordApi.Application.Quote.Query.GetQuote;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.AcordApi.Application.Domain.Entity.Quote;

public class QuoteDTO {
	
	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private Quote quote;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID QuoteId;

    @Column(columnDefinition = "jsonb")
    private String QuoteJson;



	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
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

	public String getQuoteJson() {
		return QuoteJson;
	}

	public void setQuoteJson(String quoteJson) {
		QuoteJson = quoteJson;
	}

}
