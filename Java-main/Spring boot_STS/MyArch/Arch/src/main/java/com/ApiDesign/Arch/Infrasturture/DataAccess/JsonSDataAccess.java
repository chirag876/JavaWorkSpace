package com.ApiDesign.Arch.Infrasturture.DataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiDesign.Arch.Application.Common.DAO.JsonDAO;
import com.ApiDesign.Arch.Application.Common.Interface.IDomainEventService;
import com.ApiDesign.Arch.Application.Common.Interface.IJsonS;
import com.ApiDesign.Arch.Application.Domain.Entity.JsonS;
@Service 
public class JsonSDataAccess implements IJsonS  {
	
	
	@Autowired
	private JsonDAO jsodao; 
	@Autowired
	private IDomainEventService domainEventService;	

	@Override
	public JsonS AddJson(JsonS jsons) {
		return jsodao.save(jsons);
	}

}
