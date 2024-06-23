package com.ApiDesign.Arch.Application.JsonS.Command;

import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ApiDesign.Arch.Mediator.Request;
import com.fasterxml.jackson.databind.JsonNode;

import io.swagger.v3.core.util.Json;

public class CreateJsonSRequest implements Request<Integer> {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID id;

	    @Column(columnDefinition = "jsonb")
	    private Map<String, Object> retrievePolicyJson;
		

		public CreateJsonSRequest(UUID id, Map<String, Object> retrievePolicyJson) {
			this.id = id;
			this.retrievePolicyJson = retrievePolicyJson;
		}


		public UUID getId() {
			return id;
		}


		public void setId(UUID id) {
			this.id = id;
		}


		public Map<String, Object> getRetrievePolicyJson() {
			return retrievePolicyJson;
		}
		
		public void setRetrievePolicyJson(Map<String, Object> retrievePolicyJson) {
			this.retrievePolicyJson = retrievePolicyJson;
		}
		
		
		
	}
	
