package com.ApiDesign.Arch.Application.Common.Interface;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;
import com.ApiDesign.Arch.Application.Domain.Entity.Contact;


@Repository
@Transactional
public interface IContact {
	
	
	public Contact AddContact(Contact contact);

	public List<Contact> GetList();
	
	public Contact GetById(int id);
	
	public Integer Update(Contact contact);
	
	public int Delete(int id);

}
