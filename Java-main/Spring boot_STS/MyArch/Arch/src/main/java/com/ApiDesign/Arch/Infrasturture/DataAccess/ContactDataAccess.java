package com.ApiDesign.Arch.Infrasturture.DataAccess;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ApiDesign.Arch.Application.Common.DAO.ContactDAO;
import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Application.Common.Interface.IDomainEventService;
import com.ApiDesign.Arch.Application.Common.Interface.ILogger;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.ContactVm;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Infrasturture.Services.DomainEventService;



@Service 
public class ContactDataAccess implements IContact {
	//Logger 
	Logger _logger = LoggerFactory.getLogger(ContactDataAccess.class);	
	
	@Autowired 
	private ContactDAO contactDao;
	@Autowired
	private IDomainEventService domainEventService;	
	
	@Override
	public Contact AddContact(Contact contact) {
		
		try {
		 _logger.trace("ContactDataAccess.AddContact - In process");		
		
		
		contactDao.save(contact);
		
		}
		catch(Exception ex) {
			 _logger.error("ContactDataAccess.AddContact"+ex.getMessage());
			
		}
		DispatchEvents(contact);
		 return contact;
	}	
	
	@Override
	public  List<Contact> GetList() {
		
		return contactDao.findAll();		
		
	}
	
	@Override
	public Contact GetById(int id) {
		
		try {
			 _logger.trace("ContactDataAccess.GetById - In process");	
		return contactDao.getById(id);
		}
		
		catch(Exception ex) {
			 _logger.error("ContactDataAccess.GetById"+ex.getMessage());
			
		}
		
		return contactDao.getById(id);
	}
	
	@Override
	public Integer Update(Contact contact) {
		
		try {
			 _logger.trace("ContactDataAccess.Update - In process");		
			
			
			contactDao.save(contact);
			
			}
			catch(Exception ex) {
				 _logger.error("ContactDataAccess.Update"+ex.getMessage());
				
			}
			DispatchEvents(contact);
		 
		return contact.getId();
	}	
		
	public void DispatchEvents(Contact entity) {
	         
             domainEventService.Publish( (List<DomainEvent>) entity.domainEvents());
	
	}

	@Override
	public int Delete(int id) {
		contactDao.deleteById(id);
		return id;
	}
}
