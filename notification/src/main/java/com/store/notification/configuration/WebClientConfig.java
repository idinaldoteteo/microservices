package com.store.notification.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	@Async
	WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("http://localhost:8082/api").build();
	}
}
