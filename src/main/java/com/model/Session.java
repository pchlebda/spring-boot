package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Piotr on 27.12.2015.
 */
public class Session {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }
}
