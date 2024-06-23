package com.AcordApi.Application.Policy.Command.PolicyCommandHandler;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.AcordApi.Application.Policy.Request.CreatePolicyRequest;
import com.AcordApi.Infrastructure.DataAccess.PolicyDataAccess;
import com.AcordApi.Infrastructure.DataAccess.PolicyDataExtrationDataAccess;
import com.AcordApi.Application.Domain.Entity.Policy;
import com.AcordApi.Application.Domain.Entity.PolicyDataExtration;
import com.AcordApi.Application.Domain.Events.Policy.PolicyCompletedEvent;
import com.AcordApi.Application.Domain.Events.Policy.PolicyCreatedEvent;
import com.AcordApi.Mediator.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opencsv.CSVWriter;
@Component
public class CreatePolicyHandler implements RequestHandler<CreatePolicyRequest, Integer>{
	
	// An instance of the RetrievePolicyDataAccess object is injected through constructor injection
    @Autowired
    private PolicyDataAccess policy;
    
    @Autowired
    private PolicyDataExtrationDataAccess policyextrdata;

    // Constructor for CreateRetrievePolicyHandler that takes in an instance of RetrievePolicyDataAccess
    public CreatePolicyHandler(PolicyDataAccess policy) {

        this.policy = policy;

    }






    // This method creates a new RetrievePolicy entity, sets its properties and saves it to the database
    public UUID uhandle(CreatePolicyRequest request) {

		// Creating a new RetrievePolicy entity
		Policy entity = new Policy();
		
		// Generating a new UUID for the RetrievePolicy entity
		UUID newId = UUID.randomUUID();
		
		
		
		
		
  /*------------------------ JSON field extract and store in database ---------------------*/
        
		PolicyDataExtration policydataextr = new PolicyDataExtration();
        Gson gson = new Gson();
        String jsonString = gson.toJson(request);
        
        JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
		JsonObject jsDataMain = jsonObject.getAsJsonObject("PolicyJson");
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
		
		
		
		String PolicyId = jsonPolicyData.get("id").getAsString();
		policydataextr.setId(PolicyId);
		
		String claimsCount = jsonPolicyData.get("claimsCount").getAsString();
		policydataextr.setClaimsCount(claimsCount);
		
		String CancellationDate = jsonPolicyData.get("cancellationDate").getAsString();
		policydataextr.setCancellationDate(CancellationDate);
		
		String EffectiveDate = jsonPolicyData.get("effectiveDate").getAsString();
		policydataextr.setEffectiveDate(EffectiveDate);
		String ExpirationDate = jsonPolicyData.get("expirationDate").getAsString();
		policydataextr.setExpirationDate(ExpirationDate);
		
		String LineofBusinessCode = jsonPolicyData.get("lineofBusinessCode").getAsString();
		policydataextr.setLineOfBusinessCode(LineofBusinessCode);
		
		Double TotalPremium = jsonPolicyData.get("totalPremium").getAsDouble();
		policydataextr.setTotalPremium(TotalPremium);

		Double renewalPremium = jsonPolicyData.get("renewalPremium").getAsDouble();
		policydataextr.setRenewalPremium(renewalPremium);

		String numberOfEmployees = jsonPolicyData.get("numberOfEmployees").getAsString();
		policydataextr.setNumberOfEmployees(numberOfEmployees);
		String businessIndustry = jsonPolicyData.get("businessIndustry").getAsString();
		policydataextr.setBusinessIndustry(businessIndustry);

		Double annualRevenue = jsonPolicyData.get("annualRevenue").getAsDouble();
		policydataextr.setAnnualRevenue(annualRevenue);

		String paymentMethod = jsonPolicyData.get("paymentMethod").getAsString();
		policydataextr.setPaymentMethod(paymentMethod);

		String durationInMonths = jsonPolicyData.get("durationInMonths").getAsString();
		policydataextr.setDurationInMonths(durationInMonths);

		JsonObject PolicyHolderData  = RetrievePolicyResponse.getAsJsonObject("policyHolder");

		String customerid = PolicyHolderData.get("CustomerID").getAsString();
		policydataextr.setCustomerId(customerid);

		String customername = PolicyHolderData.get("CustomerName").getAsString();
		policydataextr.setCustomerName(customername);


		JsonObject jsonClaimData  = RetrievePolicyResponse.getAsJsonObject("claim");
		
		Double Amount = jsonClaimData.get("amount").getAsDouble();
		policydataextr.setClaimAmount(Amount);
		
		
		
		String renewalDate = jsonPolicyData.get("RenewalDate").getAsString();
		policydataextr.setRenewalDate(renewalDate);
		String renewalStatus = jsonPolicyData.get("renewalStatus").getAsString();
		policydataextr.setRenewalStatus(renewalStatus);
		
		
		
	    try {
	    	
	        // create FileWriter object with file as parameter
//	        FileWriter outputfile = new FileWriter("data/policydata.csv",true);

	  
	        // create CSVWriter object filewriter object as parameter
	        
	  
	       
	    	   CSVWriter writer = new CSVWriter(new FileWriter("data/policydata.csv",true));
	        // adding header to csv
//	        String[] header = {"id","customerId","customerName"
//	        		,"lineOfBusinessCode","totalPremium","effectiveDate","cancellationDate","expirationDate","RenewalDate","renewalPremium",
//	        		"numberOfEmployees","businessIndustry","annualRevenue","paymentMethod","claimsCount","claimAmount",
//	        		"durationInMonths","RenewalStatus"
//}; 
//	        writer.writeNext(header);
	       
	    
	       
	        
	      
	        String[] data1 = {PolicyId,customerid,customername,LineofBusinessCode,String.valueOf(TotalPremium),EffectiveDate,
	        		CancellationDate,ExpirationDate,renewalDate,String.valueOf(renewalPremium) ,numberOfEmployees,businessIndustry,String.valueOf(annualRevenue),paymentMethod,
	        		claimsCount,String.valueOf(Amount),durationInMonths,renewalStatus
	        };
	        List list = new ArrayList();
	        list.add(data1);
	        writer.writeAll(list);
	  
	        // closing writer connection
	        writer.close();
	       
	    
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
		
		
//		policyextrdata.addData(policydataextr);
		
		
		
//		String claimedAmount = jsonClaimData.get("amount").getAsString();
//		
//		JsonObject jsonQuoteData  = RetrievePolicyResponse.getAsJsonObject("Quote");
//		String quote_id = jsonClaimData.get("id").getAsString();
//		
		
        
        /*------------------------ JSON field extract and store in database ---------------------*/
		
		
		
		
		// Setting the id property of the RetrievePolicy entity
		entity.setId(newId);
		
		UUID newPolicyId = UUID.randomUUID();
		
		entity.setPolicyId(newPolicyId);
		
		UUID newQuoteId = UUID.randomUUID();
		
		entity.setQuoteId(newQuoteId);
		
		// Setting the retrievePolicyJsonB property of the RetrievePolicy entity
		entity.setPolicyJsonB(request.getPolicyJson());
		
		// Adding a new RetrievePolicyCreatedEvent to the RetrievePolicy entity's domainEvents list
		// This event represents the creation of a new RetrievePolicy entity
		//entity.domainEvents().add(new PolicyCreatedEvent(entity));

		entity.domainEvents.add(new PolicyCreatedEvent(entity));
		
		// Saving the RetrievePolicy entity to the database using the policy object from the data access layer
//		policy.AddPolicy(entity);
		
		// Adding a new RetrievePolicyCompletedEvent to the RetrievePolicy entity's domainEvents list
		// This event represents the completion of the RetrievePolicy creation process
		entity.domainEvents.add(new PolicyCompletedEvent(entity));
		
		// Returning the UUID of the newly created RetrievePolicy entity
		return newPolicyId;
	}

	@Override
	public Integer handle(CreatePolicyRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
