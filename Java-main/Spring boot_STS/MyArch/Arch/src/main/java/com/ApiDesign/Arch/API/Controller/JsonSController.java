package com.ApiDesign.Arch.API.Controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ApiDesign.Arch.Application.Contact.Command.CreateContactRequest;
import com.ApiDesign.Arch.Application.Domain.Entity.JsonS;
import com.ApiDesign.Arch.Application.JsonS.Command.CreateJsonSRequest;
import com.ApiDesign.Arch.Mediator.Mediator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class JsonSController {
	
	private Mediator _mediator;
	


	public JsonSController(Mediator _mediator) {
		super();
		this._mediator = _mediator;
	}
	
//	@PostMapping("/CreateJson")
//	public Integer AddJson(@RequestBody CreateJsonSRequest request) {
//		
//		
//		
//	   return	_mediator.send(request);
//			
//		
//	}

}
