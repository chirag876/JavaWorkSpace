package com.api.design.Application.RetrievePolicy.EventHandlers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.api.design.Application.Common.Model.DomainEventNotification;
import com.api.design.Application.Domain.Events.RetrievePolicyCreatedEvent;
import com.api.design.Mediator.NotificationHandler;

@Component
public class RetrievePolicyCreatedEventHandler implements NotificationHandler<DomainEventNotification<RetrievePolicyCreatedEvent>> {
	Logger _logger = LoggerFactory.getLogger(RetrievePolicyCreatedEventHandler.class);

	RetrievePolicyCreatedEventHandler() {
	}

	public RetrievePolicyCreatedEventHandler(Logger _logger) {
		this._logger = _logger;
	}

	// Handler will receive Response

	@Override
	public void handle(List<DomainEventNotification<RetrievePolicyCreatedEvent>> notification) {

		_logger.info("Domain Event: " + notification);

	}
}