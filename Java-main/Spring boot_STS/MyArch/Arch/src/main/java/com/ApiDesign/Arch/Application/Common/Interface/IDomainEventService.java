package com.ApiDesign.Arch.Application.Common.Interface;

import java.util.List;

import org.springframework.scheduling.config.Task;
import com.ApiDesign.Arch.Application.Domain.Common.DomainEvent;

public interface IDomainEventService {
	//void Publish(List<DomainEvent> domainEvent);

	void Publish(List<DomainEvent> domainEvent);
}
