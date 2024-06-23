package com.ApiDesign.Arch.API.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ApiDesign.Arch.Application.Common.DAO.ContactDAO;
import com.ApiDesign.Arch.Application.Contact.Command.CreateContactRequest;
import com.ApiDesign.Arch.Application.Contact.Command.DeleteContactCommand;
import com.ApiDesign.Arch.Application.Contact.Command.UpdateContactRequest;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.ContactVm;
import com.ApiDesign.Arch.Application.Contact.Query.GetContact.GetContactQuery;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;
import com.ApiDesign.Arch.Infrasturture.DataAccess.ContactDataAccess;
import com.ApiDesign.Arch.Infrasturture.Services.DomainEventService;

import com.ApiDesign.Arch.Mediator.Mediator;

@RestController
public class ContactController {
	
	private Mediator _mediator;
	
	//public DomainEventService domainEventService; 
		
	public ContactController(Mediator _mediator) {
		
		this._mediator = _mediator;	
		
	}

	@PostMapping("/Create")
	public Integer Create(@RequestBody CreateContactRequest request) {
		//return this.contactDataAccess.AddContact(request);
	
	   return	_mediator.send(request);
			
		
	}
	
	// Get all Value from DataBase
	@GetMapping("/GetContact")
	public ContactVm getAllContact(){
		
		
		return _mediator.send(new GetContactQuery());
		
	}
	
	@DeleteMapping("/Delete")
	public Integer Delete(@PathVariable int Id)
     {
          return _mediator.send(new DeleteContactCommand(Id));
		      	
     }
	
	@PutMapping("/Update")
	public Integer  Update( @RequestBody UpdateContactRequest request){
		 return _mediator.send(request);
		 
		 
	}
	
	
	
	
	
	
	

}
