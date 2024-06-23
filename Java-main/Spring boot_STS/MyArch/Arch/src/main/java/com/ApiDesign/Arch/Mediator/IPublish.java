package com.ApiDesign.Arch.Mediator;

import org.springframework.scheduling.config.Task;

public interface IPublish {
	void Publish(Object notification);
	//<T> Task Publish(Notification notification);
	
	public <TNotification extends Notification> Notification Publish(TNotification notification);

}
