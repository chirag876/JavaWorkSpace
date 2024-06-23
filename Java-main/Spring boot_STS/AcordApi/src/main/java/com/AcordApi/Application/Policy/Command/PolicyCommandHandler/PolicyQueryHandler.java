package com.AcordApi.Application.Policy.Command.PolicyCommandHandler;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AcordApi.Application.Common.Interface.IPolicyDataAccess;
import com.AcordApi.Application.Policy.Query.GetPolicy.GetPolicyQuery;
import com.AcordApi.Application.Policy.Query.GetPolicy.PolicyDTO;
import com.AcordApi.Application.Policy.Query.GetPolicy.PolicyVm;
import com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy.GetRetrievePolicyQuery;
import com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyDTO;
import com.AcordApi.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyVm;
import com.AcordApi.Mediator.RequestHandler;

@Component
public class PolicyQueryHandler implements RequestHandler<GetPolicyQuery, PolicyVm>{
	
	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	private IPolicyDataAccess _dataAccess;

	@Override
	public PolicyVm handle(GetPolicyQuery request) {
//		RetrievePolicyVm retrievePolicyVm = new RetrievePolicyVm();
//		retrievePolicyVm.setLists(mapper.map(_dataAccess.GetList(), new TypeToken<List<RetrievePolicyDTO>>() {
//		}.getType()));
		PolicyVm policyVm = new PolicyVm();
		policyVm.setLists(mapper.map(_dataAccess.GetList(), new TypeToken<List<PolicyDTO>>() {}.getType()));
		return policyVm;
	}

	@Override
	public UUID uhandle(GetPolicyQuery request) {
		// TODO Auto-generated method stub
		return null;
	}

}
