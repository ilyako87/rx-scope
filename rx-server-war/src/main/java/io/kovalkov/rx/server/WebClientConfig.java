package io.kovalkov.rx.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	public WebClient googleClient() {
		return WebClient.builder()
				.baseUrl("https://google.com")
				.build();
	}
}
