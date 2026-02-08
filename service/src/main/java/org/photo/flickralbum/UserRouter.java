package org.photo.flickralbum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration()
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> route(AuthRequestHandler authRequestHandler) {
        return RouterFunctions.route()
                .GET("/request_token", authRequestHandler::requestTokenHandler)
                .GET("/access_Token", authRequestHandler::authTokenHandler)
                .build();

    }


}
