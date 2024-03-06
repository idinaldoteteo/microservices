package com.store.notification.component.impl;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.store.notification.component.IRabbitMqComponent;
import com.store.notification.service.IEmailService;

@Component
public class RabbitMqComponent implements IRabbitMqComponent {
	
	@Autowired
	private IEmailService emailService;
	
	@Autowired
	private WebClient webClient; 
	
	@Value("${queue.name}")
	private String queue;
	
	@RabbitListener(queues = "order_notification")	
	public void handleMessage(String message) {		
		try {
			System.out.println("mensagem:" + message);
			
			Map<String, Object> map = emailService.convertToObject(message);
			
			int user_id = (int)map.get("user_id");
			String productName = map.get("orderItems").toString();
			
			String response = webClient.get()
											.uri("/user/" + user_id)
											.retrieve()
											.bodyToMono(String.class)
											.block();
			
			System.out.println(response);
			
			map = emailService.convertToObject(response);
			
			String email = map.get("email").toString();
			
			emailService.sendEmail("MENSAGEM CORPO vc comprou o produto id: " + productName, email, "Produto XPTO");
			
			System.out.println("email enviado para: " + email);	
			
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());
		}
		
	}
}
