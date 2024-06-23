package com.AcordApi.API.Controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AcordApi.Application.Policy.Query.GetPolicy.GetPolicyQuery;
import com.AcordApi.Application.Policy.Query.GetPolicy.PolicyVm;
import com.AcordApi.Application.Policy.Request.CreatePolicyRequest;
import com.AcordApi.Application.Policy.Request.DeletePolicyRequest;
import com.AcordApi.Application.Policy.Request.UpdatePolicyRequest;
import com.AcordApi.Mediator.Mediator;

@RestController
public class PolicyController {

	// Mediator instance to handle requests
	private Mediator _mediator;

	// Constructor to inject Mediator
	public PolicyController(Mediator _mediator) {
		this._mediator = _mediator;
	}

	// POST request to create a new RetrievePolicy
	@PostMapping("/Policy/Create")
	public UUID Create(@RequestBody CreatePolicyRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

	// GET request to retrieve all RetrievePolicy
	@GetMapping("/Policy/Get")
	public PolicyVm GetList() {
		// Send the query to the Mediator
		return _mediator.send(new GetPolicyQuery());
	}

	// DELETE request to delete a RetrievePolicy by UUID
	@DeleteMapping("/Policy/{uuid}")
	public UUID deleteContact(@PathVariable UUID uuid) {
		// Send the request to the Mediator
		return _mediator.usend(new DeletePolicyRequest(uuid));
		// Return a response with status code 200 (OK)
		// return ResponseEntity.ok().build();
	}

	// PUT request to update an existing RetrievePolicy
	@PutMapping("/Policy/Update")
	public UUID Update(@RequestBody UpdatePolicyRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

}
