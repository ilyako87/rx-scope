package io.kovalkov.rx.boot.rxclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Value("${rx-server.host-name}")
	private String rxServerHostName;

	@Bean
	public WebClient googleClient() {
		return WebClient.builder()
				.build();
	}
}
