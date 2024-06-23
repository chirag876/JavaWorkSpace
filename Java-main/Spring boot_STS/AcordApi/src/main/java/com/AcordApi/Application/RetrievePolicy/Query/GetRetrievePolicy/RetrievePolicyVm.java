package com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy;

import java.util.List;

import com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyDTO;

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
