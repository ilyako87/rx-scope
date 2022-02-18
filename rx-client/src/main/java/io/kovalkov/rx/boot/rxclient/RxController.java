package io.kovalkov.rx.boot.rxclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
@ComponentScan
@RestController
public class RxController {

	@Autowired
	private WebClient googleClient;

	@Value("${rx-server.host-name}")
	private String rxServerHostName;

	@Value("${rx-server.port}")
	private String rxServerPort;

	@GetMapping("/rx-test")
	public Mono<ResponseEntity<String>> monoTest() {
		log.debug(rxServerHostName);
		log.debug(rxServerPort);
		return googleClient.get()
				.uri(uriBuilder ->
						uriBuilder
								.scheme("http")
								.host(rxServerHostName)
								.port(rxServerPort)
								.pathSegment("server-rx-api")
								.build())
				.exchangeToMono(clientResponse -> clientResponse.toEntity(String.class));
	}

	@GetMapping("/standard-test")
	public ResponseEntity<String> standardTest() {
		final RestTemplate restTemplate = new RestTemplateBuilder().build();
		final URI uri = new DefaultUriBuilderFactory().builder()
				.scheme("http")
				.host(rxServerHostName)
				.port(rxServerPort)
				.pathSegment("server-standard-api")
				.build();
		return restTemplate.getForEntity(uri, String.class);
	}

}
