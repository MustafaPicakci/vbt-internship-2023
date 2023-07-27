package com.example.link3.dto;

public class AuthResponseDto {
    private UserDto user;
    private String jwt;

    public AuthResponseDto() {
    }

    public AuthResponseDto(UserDto user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
