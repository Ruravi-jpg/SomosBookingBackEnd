package com.somosbooking.somosBack.model;

public class Token {

    private final String accessToken;

    public Token(String accesToken) {
        this.accessToken = accesToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
