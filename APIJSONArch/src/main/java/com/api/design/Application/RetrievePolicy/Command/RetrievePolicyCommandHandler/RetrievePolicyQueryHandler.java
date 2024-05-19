package com.api.design.Application.RetrievePolicy.Command.RetrievePolicyCommandHandler;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy.GetRetrievePolicyQuery;
import com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyDTO;
import com.api.design.Application.RetrievePolicy.Query.GetRetrievePolicy.RetrievePolicyVm;
import com.api.design.Mediator.RequestHandler;
import com.api.design.Application.Common.Interface.IRetrievePolicyDataAccess;

@Component
public class RetrievePolicyQueryHandler implements RequestHandler<GetRetrievePolicyQuery, RetrievePolicyVm> {

	private final ModelMapper mapper = new ModelMapper();
	@Autowired
	private IRetrievePolicyDataAccess _dataAccess;

	@Override
	public RetrievePolicyVm handle(GetRetrievePolicyQuery request) {
//		RetrievePolicyVm retrievePolicyVm = new RetrievePolicyVm();
//		retrievePolicyVm.setLists(mapper.map(_dataAccess.GetList(), new TypeToken<List<RetrievePolicyDTO>>() {
//		}.getType()));
		RetrievePolicyVm retrievePolicyVm = new RetrievePolicyVm();
		retrievePolicyVm.setLists(mapper.map(_dataAccess.GetList(), new TypeToken<List<RetrievePolicyDTO>>() {}.getType()));
		return retrievePolicyVm;
	}

	@Override
	public UUID uhandle(GetRetrievePolicyQuery request) {
		// TODO Auto-generated method stub
		return null;
	}
}
