package com.ApiDesign.Arch.Application.RetrievePolicy.Request.RequestHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.RetrievePolicy.Request.CreateRetrievePolicyRequest;

import com.ApiDesign.Arch.Infrasturture.DataAccess.RetrievePolicyDataAccess;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.RetrievePolicy;

import com.ApiDesign.Arch.Application.Domain.Events.RetrievePolicyCompletedEvent;
import com.ApiDesign.Arch.Application.Domain.Events.RetrievePolicyCreatedEvent;
import com.ApiDesign.Arch.Mediator.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Component
public class CreateRetrievePolicyHandler implements RequestHandler<CreateRetrievePolicyRequest, Integer> {

	@Autowired
	private RetrievePolicyDataAccess policy;

	public CreateRetrievePolicyHandler(RetrievePolicyDataAccess policy) {

		this.policy = policy;

	}

	// Assign Requested Contact value
	public Integer handle(CreateRetrievePolicyRequest request) {
		
		
		 /*Object to JSON Convertor 
		Gson gson = new Gson();
		
		String json = gson.toJson(request);
		
		
		try (FileWriter writer = new FileWriter("file.json")) {
		    writer.write(json);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		*/
		RetrievePolicy entity = new RetrievePolicy();
		
		UUID newId = UUID.randomUUID();
		entity.setId(newId);
		//entity.setName(request.getName());
		entity.setRetrievePolicyJsonB(request.getRetrievePolicyJson());
		
		entity.domainEvents().add(new RetrievePolicyCreatedEvent(entity));
		RetrievePolicyCreatedEvent retrievePolicyCreatedEvent = new RetrievePolicyCreatedEvent(entity);
		
		

		// Adding DomainEvent to RetrievePolicy Object
		entity.domainEvents().add(new RetrievePolicyCreatedEvent(entity));

		// Add Requested to Contact
		policy.AddPolicy(entity);

		entity.domainEvents().add(new RetrievePolicyCompletedEvent(entity));
		return 1;

	}

	@Override
	public UUID uhandle(CreateRetrievePolicyRequest request) {
		RetrievePolicy entity = new RetrievePolicy();
		
		UUID newId = UUID.randomUUID();
		entity.setId(newId);
		//entity.setName(request.getName());
		
		
		entity.setRetrievePolicyJsonB(request.getRetrievePolicyJson());

		
		// Adding DomainEvent to RetrievePolicy Object
		entity.domainEvents().add(new RetrievePolicyCreatedEvent(entity));
		
		

		// Add Requested to Contact
		policy.AddPolicy(entity);

		entity.domainEvents().add(new RetrievePolicyCompletedEvent(entity));
		return newId;
	}

}
