package com.store.notification.service;

import java.util.Map;

public interface IEmailService {

	void sendEmail(String content, String email, String subject);

	Map<String, Object> convertToObject(String jsonS);
}
