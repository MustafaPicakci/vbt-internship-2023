package com.example.link3.service;

import com.example.link3.entity.Link;

import java.util.List;

public interface LinkService {
    void addLink(Link link);
    List<Link> findByUsername(String username) throws Exception;
}
