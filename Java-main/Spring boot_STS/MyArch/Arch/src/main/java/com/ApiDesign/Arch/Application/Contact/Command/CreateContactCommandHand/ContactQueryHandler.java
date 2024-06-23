package com.ApiDesign.Arch.Application.Contact.Command.CreateContactCommandHand;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.ContactDTO;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.ContactVm;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.GetContactQuery;

import com.ApiDesign.Arch.Infrasturture.DataAccess.ContactDataAccess;
import com.ApiDesign.Arch.Mediator.RequestHandler;

@Component
 public class ContactQueryHandler implements RequestHandler<GetContactQuery,ContactVm>{
	
	Logger _logger = LoggerFactory.getLogger(ContactQueryHandler.class);	
	ModelMapper mapper = new ModelMapper();
	@Autowired
	private IContact _dataAcces;
//	@Override
//	public ContactVm handle(GetContactQuery request) {
//		
//		//return (ContactVm)((_dataAcces.GetList()));
//		
//		mapper.map(_dataAcces.GetList(), ContactDTO )
//		
//	}
	@Override
	public ContactVm handle(GetContactQuery request) {
		ContactVm ContactVm = new ContactVm();
		ContactVm.setLists(mapper.map(_dataAcces.GetList(), new TypeToken<List<ContactDTO>>() {}.getType()));
	    return ContactVm;
	}
	@Override
	public UUID uhandle(GetContactQuery request) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

		
}

