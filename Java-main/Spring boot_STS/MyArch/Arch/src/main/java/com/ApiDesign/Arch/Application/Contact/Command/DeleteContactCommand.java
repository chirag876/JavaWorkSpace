package com.ApiDesign.Arch.Application.Contact.Command;

import org.springframework.stereotype.Component;

import com.ApiDesign.Arch.Application.Common.Interface.IContact;
import com.ApiDesign.Arch.Mediator.Request;
import com.ApiDesign.Arch.Mediator.RequestHandler;

public class DeleteContactCommand implements Request<Integer> {
	
	private int Id;

	public DeleteContactCommand(int Id) {
	this.Id = Id;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
}


