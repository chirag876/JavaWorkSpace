package com.ApiDesign.Arch.Application.SystemDate;

import java.util.Date;
import java.util.UUID;

import com.ApiDesign.Arch.Mediator.Request;
import com.ApiDesign.Arch.Mediator.RequestHandler;

public class GetSystemDateQuery implements Request<Date>   {
	
	private Date SystemDate;

	public Date getSystemDate() {
		return SystemDate;
	}
	public void setSystemDate(Date systemDate) {
		SystemDate = systemDate;
	}	
}
class GetSystemDateQueryHandler implements RequestHandler<GetSystemDateQuery,Date>{

	@Override
	public Date handle(GetSystemDateQuery request) {
		Date date = new Date();
		request.setSystemDate(date);
		return date;
	}

	@Override
	public UUID uhandle(GetSystemDateQuery request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
