package com.ApiDesign.Arch.Application.Contact.Command;

import com.ApiDesign.Arch.Mediator.Request;


//class CreateContactRequest extends the Request interface of MediatR
public class CreateContactRequest implements Request<Integer> {
	
	private int Id;
	private String Name;
	private String Phone;
	public CreateContactRequest(int id, String name, String phone) {
		super();
		Id = id;
		Name = name;
		Phone = phone;
	}
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



