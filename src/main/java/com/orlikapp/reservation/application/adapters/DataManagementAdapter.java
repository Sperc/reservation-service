package com.orlikapp.reservation.application.adapters;

import com.orlikapp.reservation.application.adapters.dto.UserData;
import com.orlikapp.reservation.infrastrucutre.ConfigProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataManagementAdapter {
    private final WebClient.Builder webClientBuilder;
    private final ConfigProperties configProperties;
    private final RestTemplate restTemplate;

    public Mono<UserData> getUser(String email) {
//        final URI uri = URI.create(configProperties.getDataManagementUrl() + "/" + email);
//        final ResponseEntity<UserData> exchange = restTemplate.exchange(uri, HttpMethod.GET, null, ParameterizedTypeReference.forType(UserData.class));
//        log.info("response: {}", exchange);
//        return exchange.getBody();
        final WebClient build = webClientBuilder.baseUrl(configProperties.getDataManagementUrl())
                                                .build();
        return build.method(HttpMethod.GET)
                    .uri(email)
                    .retrieve()
                    .bodyToMono(UserData.class);
    }

}
