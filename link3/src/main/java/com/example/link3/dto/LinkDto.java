package com.example.link3.dto;

import com.example.link3.entity.User;


public class LinkDto {

    private Long id;
    private String name;
    private String url;
    private String description;
    private UserDto user;

    public LinkDto() {
    }

    public LinkDto(Long id, String name, String url, String description, UserDto user) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
