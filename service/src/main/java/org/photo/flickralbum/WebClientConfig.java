package org.photo.flickralbum;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:8080").build();
    }

    @Bean
    public OAuth10aService oAuth10aService() {
        return new ServiceBuilder("6595effb028e9829852460fb7ac994e9")
                .apiSecret("5ad4cf75756280b7")
                .callback("http://localhost:8080/access_token")
                .build(new CustomOAuth1Api());
    }
}
