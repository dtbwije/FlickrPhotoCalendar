package org.photo.flickralbum;

import com.github.scribejava.core.builder.api.DefaultApi10a;

public class CustomOAuth1Api extends DefaultApi10a {
    @Override
    public String getRequestTokenEndpoint() {
        return "https://www.flickr.com/services/oauth/request_token";
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://www.flickr.com/services/oauth/access_token";
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://www.flickr.com/services/oauth/authorize";
    }
}
