package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.Entity.Quote;
import com.springrest.springrest.Entity.policy;
import com.springrest.springrest.services.PolicyQuoteService;
import com.springrest.springrest.services.QuoteService;


@RestController
public class PolicyQuoteController {
	
	@Autowired
	private PolicyQuoteService policyquoteService;
	
	@Autowired
	private QuoteService quoteservice;
	
	@PostMapping("/AddPolicy")
	public policy AddCourse(@RequestBody policy policy) {
		return this.policyquoteService.AddPolicy(policy);
	}
	
	@PostMapping("/AddQuote")
	public Quote AddCourse(@RequestBody Quote quote) {
		return this.quoteservice.AddQuote(quote);
	}
	
	
}
