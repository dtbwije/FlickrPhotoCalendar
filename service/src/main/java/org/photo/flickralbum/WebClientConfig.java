package org.photo.flickralbum;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public OAuth10aService oAuth10aService() {
        //These two should be in a secret properties file
        return new ServiceBuilder("6595effb028e9829852460fb7ac994e9")
                .apiSecret("5ad4cf75756280b7")
                .callback("http://localhost:8080/access_Token")
                .build(new CustomOAuth1Api());
    }

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        CookieWebSessionIdResolver resolver = new CookieWebSessionIdResolver();
        resolver.addCookieInitializer(builder ->
                builder.sameSite("None").secure(true));
        return resolver;
    }

}
