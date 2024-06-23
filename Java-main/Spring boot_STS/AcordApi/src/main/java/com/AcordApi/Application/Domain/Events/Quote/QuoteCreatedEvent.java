package com.AcordApi.Application.Domain.Events.Quote;

import com.AcordApi.Application.Domain.Common.DomainEvent;
import com.AcordApi.Application.Domain.Entity.Quote;

public class QuoteCreatedEvent extends DomainEvent{
	
	private Quote quote;

	public QuoteCreatedEvent(Quote quote) {
		this.quote = quote;		
	}
	public Quote getContact() {
		return quote;
	}

}
