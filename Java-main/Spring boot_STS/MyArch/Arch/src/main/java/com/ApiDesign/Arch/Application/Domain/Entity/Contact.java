package com.ApiDesign.Arch.Application.Domain.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

import com.ApiDesign.Arch.Application.Common.Interface.IHasDomainEvent;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Application.Domain.Events.ContactCreatedEvent;

@Entity
public class Contact  {
	
	@javax.persistence.Id
	private int Id;

	private String Name;
	
	private String Phone;	
	
	
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	
	
	//@ElementCollection(targetClass=Integer.class)
	//private 
	
	
	public List<DomainEvent> domainEvents() {
		List<DomainEvent> domainEvent = new ArrayList<DomainEvent>();
		return domainEvent;
	}
	


	
	
}