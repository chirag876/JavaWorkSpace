package com.ApiDesign.Arch.Application.Contact.Query.GetContact;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ApiDesign.Arch.Application.Domain.Entity.Contact;

public class ContactDTO {
	

	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private Contact contact;
	//ContactDTO userDTO = mapper.map(contact ,ContactDTO.class );
	
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
	
}
