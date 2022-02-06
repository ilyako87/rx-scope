package io.kovalkov.rx.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ComponentScan
@RestController
public class RxController {

	@Autowired
	private WebClient googleClient;

	@GetMapping("/mono-test")
	public Mono<String> monoTest() {
		return googleClient.get().uri("https://google.com")
				.exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class));
	}

}
