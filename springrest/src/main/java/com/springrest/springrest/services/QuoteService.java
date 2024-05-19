package com.springrest.springrest.services;

import org.springframework.stereotype.Repository;

import com.springrest.springrest.Entity.Quote;
@Repository
public interface QuoteService {
	
	public Quote AddQuote(Quote quote1);
}
