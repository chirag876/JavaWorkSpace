package com.api.design.Application.RetrievePolicy.EventHandlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.design.Application.Common.Model.DomainEventNotification;
import com.api.design.Application.Domain.Events.RetrievePolicyUpdatedEvent;
import com.api.design.Mediator.NotificationHandler;

public class RetrievePolicyUpdatedEventHandler implements NotificationHandler<DomainEventNotification<RetrievePolicyUpdatedEvent>> {

	Logger _logger = LoggerFactory.getLogger(RetrievePolicyUpdatedEventHandler.class);

	public RetrievePolicyUpdatedEventHandler(Logger _logger) {
		this._logger = _logger;
	}

	// Handler will receive Response

	@Override
	public void handle(List<DomainEventNotification<RetrievePolicyUpdatedEvent>> notification) {

		_logger.info("Domain Event: " + notification);

	}

}