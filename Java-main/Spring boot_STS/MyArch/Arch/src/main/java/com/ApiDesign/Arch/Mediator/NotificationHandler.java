package com.ApiDesign.Arch.Mediator;

import java.util.List;

import org.springframework.scheduling.config.Task;

public interface NotificationHandler<TNotification extends Notification> {
		 void handle(List<TNotification> notification);		

		}


