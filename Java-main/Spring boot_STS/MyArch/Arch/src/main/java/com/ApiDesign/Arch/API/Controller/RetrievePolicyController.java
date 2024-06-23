package com.ApiDesign.Arch.API.Controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;
import com.ApiDesign.Arch.Application.RetrievePolicy.Query.GetRetrivePolicy.GetRetrievePolicy;
import com.ApiDesign.Arch.Application.RetrievePolicy.Query.GetRetrivePolicy.RetrievePolicyVm;
import com.ApiDesign.Arch.Application.RetrievePolicy.Request.CreateRetrievePolicyRequest;
import com.ApiDesign.Arch.Application.RetrievePolicy.Request.DeleteRetrievePolicyRequest;
import com.ApiDesign.Arch.Mediator.Mediator;
import com.google.gson.Gson;

@RestController
public class RetrievePolicyController {

	private Mediator _mediator;

	// public DomainEventService domainEventService;

	public RetrievePolicyController(Mediator _mediator) {

		this._mediator = _mediator;

	}

	@PostMapping("/CreatePolicy")
	public Integer Create(@RequestBody CreateRetrievePolicyRequest request) {
		// return this.contactDataAccess.AddContact(request);
		

		
		return _mediator.send(request);

	}

	// Get all Value from DataBase
	@GetMapping("/Get")
	public RetrievePolicyVm getAll() {
		return _mediator.send(new GetRetrievePolicy());

	}
	
//	@GetMapping("/{id}")
//	public RetrievePolicyVm GetById(@PathVariable UUID id) {
//		RetrievePolicy policy = _mediator.send(new GetPolicyByIdQuery(id));
//	    // Convert the Policy object to a RetrievePolicyVm object and return it
//	}


	@DeleteMapping("/{id}")
	public UUID deleteContact(@PathVariable UUID id) {
		return _mediator.usend(new DeleteRetrievePolicyRequest(id));
		
	}

//	@PutMapping("/Update")
//	public Integer Update(Integer id, @RequestBody UpdateRetrievePolicyRequest request) {
//		return _mediator.send(request);
//
//	}

}
