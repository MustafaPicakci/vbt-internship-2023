package com.example.link3.service;

import com.example.link3.dto.LinkDto;
import com.example.link3.entity.Link;

import java.util.List;

public interface LinkService {
    LinkDto addLink(LinkDto link);
    List<LinkDto> findByUsername(String username) throws Exception;

    LinkDto update(Link link) throws Exception;

    void delete(Long id) throws Exception;

    Link toEntity(LinkDto dto);
    LinkDto toDto(Link link);
}
