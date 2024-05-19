package com.api.design.Application.SystemDate;
//package com.ApiDesign.Arch.Application.SystemDate;
//
//import java.util.Date;
//import java.util.UUID;
//
//import com.ApiDesign.Arch.Mediator.Request;
//import com.ApiDesign.Arch.Mediator.RequestHandler;
//
//public class GetSystemDateQuery implements Request<Date>   {
//	
//	private Date SystemDate;
//
//	public Date getSystemDate() {
//		return SystemDate;
//	}
//	public void setSystemDate(UUID date) {
//		SystemDate = date;
//	}	
//}
//class GetSystemDateQueryHandler implements RequestHandler<GetSystemDateQuery,Date>{
//
//	@Override
//	public UUID handle(GetSystemDateQuery request) {
//		UUID date = new Date();
//		request.setSystemDate(date);
//		return date;
//	}
//	
//	
//}
