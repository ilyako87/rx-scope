package io.kovalkov.rx.boot.rxserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
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

	@GetMapping("/server-rx-api")
	public Mono<ResponseEntity<String>> monoTest() {
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Response from Server", HttpStatus.ACCEPTED);
		return Mono.just(responseEntity);
	}

	@GetMapping("/server-standard-api")
	public ResponseEntity<String> standardTest() {
		return new ResponseEntity<>("Response from Server", HttpStatus.ACCEPTED);
	}

}
