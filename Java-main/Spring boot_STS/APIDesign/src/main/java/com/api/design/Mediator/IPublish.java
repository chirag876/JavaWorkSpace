package com.api.design.Mediator;

public interface IPublish {
	void Publish(Object notification);

	// <T> Task Publish(Notification notification);
	public <TNotification extends Notification> Notification Publish(TNotification notification);
	// Implementation code here

}
