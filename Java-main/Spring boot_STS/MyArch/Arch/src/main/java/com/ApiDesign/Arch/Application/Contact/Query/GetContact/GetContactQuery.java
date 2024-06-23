package com.ApiDesign.Arch.Application.Contact.Query.GetContact;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Infrasturture.DataAccess.ContactDataAccess;
import com.ApiDesign.Arch.Infrasturture.Services.DomainEventService;
import com.ApiDesign.Arch.Mediator.Request;
import com.ApiDesign.Arch.Mediator.RequestHandler;

public class GetContactQuery implements Request<ContactVm> {
	

}

