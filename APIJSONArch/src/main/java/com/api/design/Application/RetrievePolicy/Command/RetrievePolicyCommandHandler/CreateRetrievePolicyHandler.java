package com.api.design.Application.RetrievePolicy.Command.RetrievePolicyCommandHandler;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.api.design.Application.RetrievePolicy.Request.CreateRetrievePolicyRequest;

import com.api.design.Infrastructure.DataAccess.RetrievePolicyDataAccess;
import com.api.design.Application.Common.Interface.IPolicyDataAccess;
import com.api.design.Application.Domain.Entity.Policy;
import com.api.design.Application.Domain.Entity.RetrievePolicy;
import com.api.design.Application.Domain.Events.RetrievePolicyCompletedEvent;
import com.api.design.Application.Domain.Events.RetrievePolicyCreatedEvent;
import com.api.design.Mediator.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class CreateRetrievePolicyHandler implements RequestHandler<CreateRetrievePolicyRequest, Integer> {

    // An instance of the RetrievePolicyDataAccess object is injected through constructor injection
    @Autowired
    private RetrievePolicyDataAccess policy;
    
    @Autowired 
    private IPolicyDataAccess myPolicy;

    // Constructor for CreateRetrievePolicyHandler that takes in an instance of RetrievePolicyDataAccess
    public CreateRetrievePolicyHandler(RetrievePolicyDataAccess policy) {

        this.policy = policy;

    }

    // This method creates a new RetrievePolicy entity, sets its properties and saves it to the database
    public UUID uhandle(CreateRetrievePolicyRequest request) {

        // Creating a new RetrievePolicy entity
        RetrievePolicy entity = new RetrievePolicy();
        Policy policyext = new Policy();

        // Generating a new UUID for the RetrievePolicy entity
        UUID newId = UUID.randomUUID();

        // Setting the id property of the RetrievePolicy entity
        entity.setId(newId);
        policyext.setId(newId);
        
        
        /*------------------------ JSON field extract and store in database ---------------------*/
        
        Gson gson = new Gson();
        String jsonString = gson.toJson(request);
        
        JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
		
		JsonObject jsData = jsonObject.getAsJsonObject("retrievePolicyJson");
		
		int Id = jsData.get("id").getAsInt();
		policyext.setpId(Id);
		
		JsonObject jsData2  = jsData.getAsJsonObject("premium");
		

		int amount = jsData2.get("amount").getAsInt();
		policyext.setPremiumAmount(amount);
		
		JsonObject jsData3  = jsData.getAsJsonObject("coverage");

		BigInteger limit = jsData3.get("limit").getAsBigInteger();
		policyext.setCoverageLimit(limit);
		
		myPolicy.addData(policyext);
		
      /* ------------- Json Completed ---------------*/  

        // Setting the retrievePolicyJsonB property of the RetrievePolicy entity
        entity.setRetrievePolicyJsonB(request.getRetrievePolicyJson());

        // Adding a new RetrievePolicyCreatedEvent to the RetrievePolicy entity's domainEvents list
        // This event represents the creation of a new RetrievePolicy entity
        entity.domainEvents().add(new RetrievePolicyCreatedEvent(entity));

        // Saving the RetrievePolicy entity to the database using the policy object from the data access layer
        policy.AddPolicy(entity);

        // Adding a new RetrievePolicyCompletedEvent to the RetrievePolicy entity's domainEvents list
        // This event represents the completion of the RetrievePolicy creation process
        entity.domainEvents().add(new RetrievePolicyCompletedEvent(entity));

        // Returning the UUID of the newly created RetrievePolicy entity
        return newId;
    }

	@Override
	public Integer handle(CreateRetrievePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
