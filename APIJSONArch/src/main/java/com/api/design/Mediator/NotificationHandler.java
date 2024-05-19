package com.api.design.Mediator;

import java.util.List;

public interface NotificationHandler<TNotification extends Notification> {
	void handle(List<TNotification> notification);

}
