package com.AcordApi.API.Controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy.GetRetrievePolicyQuery;
import com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyVm;
import com.AcordApi.Application.RetrievePolicy.Request.CreateRetrievePolicyRequest;
import com.AcordApi.Application.RetrievePolicy.Request.DeleteRetrievePolicyRequest;
import com.AcordApi.Application.RetrievePolicy.Request.UpdateRetrievePolicyRequest;
import com.AcordApi.Mediator.Mediator;

@RestController
public class RetrievePolicyController {

	// Mediator instance to handle requests
	private Mediator _mediator;

	// Constructor to inject Mediator
	public RetrievePolicyController(Mediator _mediator) {
		this._mediator = _mediator;
	}

	// POST request to create a new RetrievePolicy
	@PostMapping("/RetrievePolicy/Create")
	public UUID Create(@RequestBody CreateRetrievePolicyRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

	// GET request to retrieve all RetrievePolicy
	@GetMapping("/RetrievePolicy/Get")
	public RetrievePolicyVm GetList() {
		// Send the query to the Mediator
		return _mediator.send(new GetRetrievePolicyQuery());
	}

	// DELETE request to delete a RetrievePolicy by UUID
	@DeleteMapping("/RetrievePolicy/{uuid}")
	public ResponseEntity<?> deleteContact(@PathVariable UUID uuid) {
		// Send the request to the Mediator
		_mediator.send(new DeleteRetrievePolicyRequest(uuid));
		// Return a response with status code 200 (OK)
		return ResponseEntity.ok().build();
	}

	// PUT request to update an existing RetrievePolicy
	@PutMapping("/RetrievePolicy/Update")
	public UUID Update(@RequestBody UpdateRetrievePolicyRequest request) {
		// Send the request to the Mediator
		return _mediator.usend(request);
	}

}
