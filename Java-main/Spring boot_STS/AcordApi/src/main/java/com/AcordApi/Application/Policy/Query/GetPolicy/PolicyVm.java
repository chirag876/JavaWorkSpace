package com.AcordApi.Application.Policy.Query.GetPolicy;

import java.util.List;

import com.AcordApi.Application.Policy.Query.GetPolicy.PolicyDTO;

public class PolicyVm {
	
	public List<PolicyDTO> lists;
	
	public PolicyVm() {}

	public List<PolicyDTO> getLists() {
		return lists;
	}

	public void setLists(List<PolicyDTO> lists) {
		this.lists = lists;
	}

}
