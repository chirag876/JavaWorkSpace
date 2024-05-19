package com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy;

import java.util.List;


public class RetrievePolicyVm {
	
	public List<RetrievePolicyDTO> lists;
	
	public RetrievePolicyVm() {}

	public List<RetrievePolicyDTO> getLists() {
		return lists;
	}

	public void setLists(List<RetrievePolicyDTO> lists) {
		this.lists = lists;
	}
	
}
