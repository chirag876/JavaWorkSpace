package com.AcordApi.Application.RetrievePolicy.Command.RetrievePolicyCommandHandler;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.RetrievePolicy.Request.CreateRetrievePolicyRequest;
import com.AcordApi.Infrastructure.DataAccess.RetrievePolicyDataAccess;
import com.AcordApi.Application.Domain.Entity.PolicyDataExtration;
import com.AcordApi.Application.Domain.Entity.RetrievePolicy;
import com.AcordApi.Application.Domain.Events.RetrievePolicy.RetrievePolicyCompletedEvent;
import com.AcordApi.Application.Domain.Events.RetrievePolicy.RetrievePolicyCreatedEvent;
import com.AcordApi.Mediator.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class CreateRetrievePolicyHandler implements RequestHandler<CreateRetrievePolicyRequest, Integer>{
	
	// An instance of the RetrievePolicyDataAccess object is injected through constructor injection
    @Autowired
    private RetrievePolicyDataAccess policy;

    // Constructor for CreateRetrievePolicyHandler that takes in an instance of RetrievePolicyDataAccess
    public CreateRetrievePolicyHandler(RetrievePolicyDataAccess policy) {

        this.policy = policy;

    }

    // This method creates a new RetrievePolicy entity, sets its properties and saves it to the database
    public UUID uhandle(CreateRetrievePolicyRequest request) {

		// Creating a new RetrievePolicy entity
		RetrievePolicy entity = new RetrievePolicy();
		
		// Generating a new UUID for the RetrievePolicy entity
		UUID newId = UUID.randomUUID();
		
		
		
		
  /*------------------------ JSON field extract and store in database ---------------------*/
        
		PolicyDataExtration policydataextr = new PolicyDataExtration();
        Gson gson = new Gson();
        String jsonString = gson.toJson(request);
        
        JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
		JsonObject jsDataMain = jsonObject.getAsJsonObject("retrievePolicyJson");
//		JsonObject jsDataRequest = jsDataMain.getAsJsonObject("RetrievePolicyRequest");
//		
//		
//		JsonObject jsData2  = jsDataRequest.getAsJsonObject("policy");
//		
//
//		String policy_id = jsData2.get("id").getAsString();
//		quote.setPolicy_id(policy_id);
		
		
		JsonObject RetrievePolicyResponse = jsDataMain.getAsJsonObject("RetrievePolicyResponse");
		JsonObject jsonPolicyData  = RetrievePolicyResponse.getAsJsonObject("policy");
		String CancellationDate = jsonPolicyData.get("cancellationDate").getAsString();
		policydataextr.setCancellationDate(CancellationDate);
//		String claimedAmount = jsonClaimData.get("amount").getAsString();
//		
//		JsonObject jsonQuoteData  = RetrievePolicyResponse.getAsJsonObject("Quote");
//		String quote_id = jsonClaimData.get("id").getAsString();
//		
		
        
        /*------------------------ JSON field extract and store in database ---------------------*/
		
		
		
		// Setting the id property of the RetrievePolicy entity
		entity.setId(newId);
		
		UUID newRetrievePolicyId = UUID.randomUUID();
		
		entity.setRetrievePolicyId(newRetrievePolicyId);
		
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
		return request.getId();
	}

	@Override
	public Integer handle(CreateRetrievePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
