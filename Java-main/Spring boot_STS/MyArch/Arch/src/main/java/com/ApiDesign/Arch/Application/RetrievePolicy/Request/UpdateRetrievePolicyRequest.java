//package com.ApiDesign.Arch.Application.RetrievePolicy.Request;
//
//import java.util.UUID;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import com.ApiDesign.Arch.Mediator.Request;
//
//public class UpdateRetrievePolicyRequest implements Request<Integer> {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//
//    @Column(columnDefinition = "jsonb")
//    private String retrievePolicyJson;
//	
//
//	public UUID getId() {
//		return id;
//	}
//
//
//	public void setId(UUID id) {
//		this.id = id;
//	}
//
//
//	public String getRetrievePolicyJson() {
//		return retrievePolicyJson;
//	}
//	
//	public void setRetrievePolicyJson(String retrievePolicyJson) {
//		this.retrievePolicyJson = retrievePolicyJson;
//	}
//	
//
//}
