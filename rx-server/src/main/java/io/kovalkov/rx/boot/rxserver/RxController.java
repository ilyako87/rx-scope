package io.kovalkov.rx.boot.rxserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ComponentScan
@RestController
public class RxController {

	@Autowired
	private WebClient googleClient;

	@GetMapping("/server-api")
	public Mono<ResponseEntity<String>> monoTest() {
		return googleClient.get().uri("https://www.google.com")
				.exchangeToMono(clientResponse -> clientResponse.toEntity(String.class));
	}

}
