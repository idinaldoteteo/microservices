package com.store.notification.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.notification.service.IEmailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {

	@Autowired
	private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String emailFrom;
	
	public Map<String, Object> convertToObject(String jsonS) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(jsonS, Map.class);
			
			return map;
			
		} catch (JsonProcessingException e) {
			return null;		
		}
	}
	public void sendEmail(String content, String email, String subject) {
		
		SimpleMailMessage message = new SimpleMailMessage();		
		message.setFrom(emailFrom);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(content);
		
		mailSender.send(message);
	}	
}
