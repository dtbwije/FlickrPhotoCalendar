package org.photo.flickralbum;

import org.photo.flickralbum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class UserClient {
    @Autowired
    private final WebClient webClient;

    public UserClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getRequestToken() {
        return this.webClient.get().uri("/request_token").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(User.class).map(User::name);
    }
}
