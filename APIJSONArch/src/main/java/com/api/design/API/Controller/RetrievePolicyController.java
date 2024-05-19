package com.api.design.API.Controller;

import java.util.UUID;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy.GetRetrievePolicyQuery;
import com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyVm;
import com.api.design.Application.RetrievePolicy.Request.CreateRetrievePolicyRequest;
import com.api.design.Application.RetrievePolicy.Request.DeleteRetrievePolicyRequest;
import com.api.design.Application.RetrievePolicy.Request.UpdateRetrievePolicyRequest;
import com.api.design.Mediator.Mediator;

@RestController
public class RetrievePolicyController {

	// Mediator instance to handle requests
	private Mediator _mediator;

	// Constructor to inject Mediator
	public RetrievePolicyController(Mediator _mediator) {
		this._mediator = _mediator;
	}

	// POST request to create a new RetrievePolicy
	@PostMapping("/Create")
	public UUID Create(@RequestBody CreateRetrievePolicyRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

	// GET request to retrieve all RetrievePolicy
	@GetMapping("/Get")
	public RetrievePolicyVm GetList() {
		// Send the query to the Mediator
		return _mediator.send(new GetRetrievePolicyQuery());
	}

	// DELETE request to delete a RetrievePolicy by UUID
	@DeleteMapping("/{uuid}")
	public UUID deleteContact(@PathVariable UUID uuid) {
		// Send the request to the Mediator
		
		// Return a response with status code 200 (OK)
		return _mediator.send(new DeleteRetrievePolicyRequest(uuid));
	}

	// PUT request to update an existing RetrievePolicy
	@PutMapping("/Update")
	public UUID Update(@RequestBody UpdateRetrievePolicyRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}
}
