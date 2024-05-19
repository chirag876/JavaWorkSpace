package com.springrest.springrest.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.springrest.springrest.Dao.PolicyDAO;
import com.springrest.springrest.Dao.PolicyDataExtrationDAO;
import com.springrest.springrest.Entity.PolicyDataExtration;
import com.springrest.springrest.Entity.policy;

@Service
public class policyServiceImp implements PolicyQuoteService {
	
	@Autowired 
	private PolicyDataExtrationDAO policymexter; 
	

	@Autowired
	private PolicyDAO policydao;

	@Override
	public policy AddPolicy(policy policy1) {
		String folderPath = "C:\\WorkSpaces\\CodeSpaces\\DataGenerator\\Insurance Data Generator\\Excel to json\\Policytrainjson";

		// Create a File object for the folder
		File folder = new File(folderPath);

		// Get the list of files in the folder
		File[] files = folder.listFiles();

		// Iterate over the files and print their names
		for (File file : files) {
			if (file.isFile()) {
				System.out.print(file.getName());
				String jsonFilePath = file.getPath();

				try {
					// Read the JSON file as a String
					String jsonString = Files.readString(Paths.get(jsonFilePath));

					// Convert the JSON string to an entity object using Gson
//		            Gson gson = new Gson();
					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode jsonNode = objectMapper.readTree(jsonString);

//					policy entity = new policy();
//					entity.setPolicyJsonB(jsonNode);

		            PolicyDataExtration policydataextr = new PolicyDataExtration();
		            Gson gson = new Gson();
//		            String jsonString = gson.toJson(request);
		            
		            JsonParser parser = new JsonParser();
		    		JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
		    		JsonObject jsDataMain = jsonObject.getAsJsonObject("PolicyJson");
		    		JsonObject jsDataRequest = jsonObject.getAsJsonObject("RetrievePolicyRequest");
		    		
//		    		
		    		JsonObject jsData2  = jsDataRequest.getAsJsonObject("policy");
		    		
		    //
		    		String policy_id = jsData2.get("id").getAsString();
//		    		quote.setPolicy_id(policy_id);
		    		
		    		
		    		JsonObject RetrievePolicyResponse = jsonObject.getAsJsonObject("RetrievePolicyResponse");
		    		JsonObject jsonPolicyData  = RetrievePolicyResponse.getAsJsonObject("policy");
		    		
		    		
		    		
		    		String PolicyId = jsonPolicyData.get("id").getAsString();
		    		policydataextr.setId(PolicyId);;
		    		
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
		    		
		    		String renewalDate = jsonPolicyData.get("RenewalDate").getAsString();
		    		policydataextr.setRenewalDate(renewalDate);
		    		int renewalStatus = jsonPolicyData.get("renewalStatus").getAsInt();
		    		policydataextr.setRenewalStatus(renewalStatus);
		    		
		    		

		    		JsonObject PolicyHolderData  = RetrievePolicyResponse.getAsJsonObject("policyHolder");

		    		String customerid = PolicyHolderData.get("CustomerID").getAsString();
		    		policydataextr.setCustomerId(customerid);

		    		String customername = PolicyHolderData.get("CustomerName").getAsString();
		    		policydataextr.setCustomerName(customername);


		    		JsonObject jsonClaimData  = RetrievePolicyResponse.getAsJsonObject("claim");
		    		
		    		
		    		
		    		Double Amount = jsonClaimData.get("amount").getAsDouble();
		    		policydataextr.setClaimAmount(Amount);
		    		
		    		
		    		policymexter.save(policydataextr);
		    		

					// System.out.print(entity.getPolicyJsonB());

//					policydao.save(entity);

//		    		

					// System.out.print(entity.getPolicyJsonB());

					//policydao.save(entity);
					
					System.out.print(file.getName());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// policydao.save(policy1);
		return null;
	}



}
