package org.photo.flickralbum;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.photo.flickralbum.model.Address;
import org.photo.flickralbum.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

//http://localhost:8080/hello?oauth_token=72157720963145342-62edeea4d6640cb2&oauth_verifier=fa6a7cfeb109facd

@Component
public class AuthRequestHandler {
    final OAuth10aService oAuth10aService ;
    OAuth1RequestToken requestToken;
    public AuthRequestHandler(OAuth10aService oAuth10aService) {
        this.oAuth10aService = oAuth10aService;
    }
    public Mono<ServerResponse> requestTokenHandler(ServerRequest request) {
        System.out.println("This worked");
        return request.session().flatMap(session->{
            try {
                requestToken = oAuth10aService.getRequestTokenAsync().get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            session.getAttributes().put("Request_token", request);
            String authUrl = oAuth10aService.getAuthorizationUrl(requestToken);
            return ServerResponse.temporaryRedirect(URI.create(authUrl)).build();
        });
    }

    public Mono<ServerResponse> authTokenHandler(ServerRequest request){
        return request.session().flatMap(session -> {
            requestToken =
                    (OAuth1RequestToken) session.getAttribute("Request_token");
            OAuth1AccessToken accessToken = null;
            try {
                accessToken = oAuth10aService.getAccessToken(requestToken, request.queryParam("verifier").get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Access Token: " + accessToken.getToken());
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON
            ).body(BodyInserters.fromValue(new User("Tharanga Wijethilake" , new Address( "10", "Hakkuritie", "Oulu"))));
        });
    }
}
