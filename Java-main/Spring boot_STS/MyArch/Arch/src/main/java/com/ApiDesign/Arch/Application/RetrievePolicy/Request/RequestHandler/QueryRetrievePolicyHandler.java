package com.ApiDesign.Arch.Application.RetrievePolicy.Request.RequestHandler;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Common.Interface.IRetrievePolicyDataAccess;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.ContactDTO;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.ContactVm;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.GetContactQuery;
import com.ApiDesign.Arch.Application.RetrievePolicy.Query.GetRetrivePolicy.GetRetrievePolicy;
import com.ApiDesign.Arch.Application.RetrievePolicy.Query.GetRetrivePolicy.RetrievePolicyDTO;
import com.ApiDesign.Arch.Application.RetrievePolicy.Query.GetRetrivePolicy.RetrievePolicyVm;
import com.ApiDesign.Arch.Mediator.RequestHandler;
@Component
public class QueryRetrievePolicyHandler implements RequestHandler<GetRetrievePolicy,RetrievePolicyVm> {

	
	@Autowired
	private IRetrievePolicyDataAccess _dataAcces;
	
	ModelMapper mapper = new ModelMapper();
	@Override
	public RetrievePolicyVm handle(GetRetrievePolicy request) {
		RetrievePolicyVm retrievePolicyVm = new RetrievePolicyVm();
		retrievePolicyVm.setLists(mapper.map(_dataAcces.GetList(), new TypeToken<List<RetrievePolicyDTO>>() {}.getType()));
	    return retrievePolicyVm;
	}
	@Override
	public UUID uhandle(GetRetrievePolicy request) {
		// TODO Auto-generated method stub
		return null;
	}

}
