package com.somosbooking.somosBack.model;

public class Token {

    private final String accesToken;

    public Token(String accesToken) {
        this.accesToken = accesToken;
    }

    public String getAccesToken() {
        return accesToken;
    }
}
