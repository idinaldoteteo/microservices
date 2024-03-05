package com.store.notification.component;

public interface IRabbitMqComponent {

	void handleMessage(String message);
}
