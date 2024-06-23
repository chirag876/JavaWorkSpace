package com.AcordApi.API.Controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AcordApi.Application.Quote.Query.GetQuote.GetQuoteQuery;
import com.AcordApi.Application.Quote.Query.GetQuote.QuoteVm;
import com.AcordApi.Application.Quote.Request.CreateQuoteRequest;
import com.AcordApi.Application.Quote.Request.DeleteQuoteRequest;
import com.AcordApi.Application.Quote.Request.UpdateQuoteRequest;
import com.AcordApi.Mediator.Mediator;

@RestController
public class QuoteController {

	// Mediator instance to handle requests
	private Mediator _mediator;

	// Constructor to inject Mediator
	public QuoteController(Mediator _mediator) {
		this._mediator = _mediator;
	}

	// POST request to create a new RetrievePolicy
	@PostMapping("/Quote/Create")
	public UUID Create(@RequestBody CreateQuoteRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

	// GET request to retrieve all RetrievePolicy
	@GetMapping("/Quote/Get")
	public QuoteVm GetList() {
		// Send the query to the Mediator
		return _mediator.send(new GetQuoteQuery());
	}

	// DELETE request to delete a RetrievePolicy by UUID
	@DeleteMapping("/Quote/{uuid}")
	public UUID deleteContact(@PathVariable UUID uuid) {
		// Send the request to the Mediator
		return _mediator.usend(new DeleteQuoteRequest(uuid));
		// Return a response with status code 200 (OK)
		// return ResponseEntity.ok().build();
	}

	// PUT request to update an existing RetrievePolicy
	@PutMapping("/Quote/Update")
	public UUID Update(@RequestBody UpdateQuoteRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

}
