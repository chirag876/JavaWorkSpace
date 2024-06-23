package com.ApiDesign.Arch.Application.Contact.Query.GetContact;

import java.util.List;

public class ContactVm {
	
	public List<ContactDTO> lists;
	
	public ContactVm() {}
	public ContactVm(List<ContactDTO> lists) {
		
		this.lists = lists;
	}

	public List<ContactDTO> getLists() {
		return lists;
	}

	public void setLists(List<ContactDTO> lists) {
		this.lists = lists;
	}
	
	
}
