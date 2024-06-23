package com.ApiDesign.Arch.Infrasturture.Services;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ApiDesign.Arch.Application.Common.Interface.IDomainEventService;
import com.ApiDesign.Arch.Application.Common.Model.DomainEventNotification;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;
import com.ApiDesign.Arch.Infrasturture.DataAccess.ContactDataAccess;
import com.ApiDesign.Arch.Mediator.IPublish;
import com.ApiDesign.Arch.Mediator.Notification;

import aj.org.objectweb.asm.Type;
@Component
public class DomainEventService implements IDomainEventService {
	
	
	private IPublish _meditor;
	
	Logger _logger = LoggerFactory.getLogger(DomainEventService.class);	
	
	
	public DomainEventService(IPublish _meditor) {
		this._meditor = _meditor;
		
	}
	public DomainEventService() {}
	

	@Override
	public  void Publish(List<DomainEvent> domainEvent) {
		 _logger.info("Publishing domain event. Event -"+domainEvent);
		 GetNotificationCorrespondingToDomainEvent(domainEvent);
		// _meditor.Publish(GetNotificationCorrespondingToDomainEvent(domainEvent));
		
		 
	}	
	 private Notification GetNotificationCorrespondingToDomainEvent(List<DomainEvent> domainEvent)
     {
		
		 DomainEventNotification<DomainEvent> notification = new DomainEventNotification<>(domainEvent);
              
     return notification;
     
     
     }
	 
	 
	


}
