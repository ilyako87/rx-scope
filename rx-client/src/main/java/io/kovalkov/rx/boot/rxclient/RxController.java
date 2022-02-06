package io.kovalkov.rx.boot.rxclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${rx-server.host-name}")
	private String rxServerHostName;

	@Value("${rx-server.port}")
	private String rxServerPort;

	@GetMapping("/client-api")
	public Mono<ResponseEntity<String>> monoTest() {
		System.out.println(rxServerHostName);
		System.out.println(rxServerPort);
		return googleClient.get()
				.uri(uriBuilder ->
						uriBuilder
								.scheme("http")
								.host(rxServerHostName)
								.port(rxServerPort)
								.pathSegment("server-api")
								.build())
				.exchangeToMono(clientResponse -> clientResponse.toEntity(String.class));
	}

}
