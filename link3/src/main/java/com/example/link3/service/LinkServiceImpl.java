package com.example.link3.service;

import com.example.link3.dto.LinkDto;
import com.example.link3.dto.UserDto;
import com.example.link3.entity.Link;
import com.example.link3.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final UserService userService;

    public LinkServiceImpl(LinkRepository linkRepository, UserService userService) {
        this.linkRepository = linkRepository;
        this.userService = userService;
    }

    @Override
    public LinkDto addLink(LinkDto dto) {
        Link link = linkRepository.save(toEntity(dto));
        LinkDto linkDto = toDto(link);
        return linkDto;
    }

    @Override
    public List<LinkDto> findByUsername(String username) throws Exception {
        UserDto user = userService.findByUsername(username);
        List<LinkDto> dtos = linkRepository.findByUser(userService.toEntity(user)).stream().map(i -> toDto(i)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public LinkDto update(Link link) throws Exception {
        Optional<Link> op=linkRepository.findById(link.getId());
        if(op.isEmpty()){
            throw new Exception("Link not found ");
        }
        return toDto(linkRepository.save(link));
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Link> op=linkRepository.findById(id);
        if(op.isEmpty()){
            throw new Exception("Link not found ");
        }
        linkRepository.delete(op.get());
    }

    @Override
    public Link toEntity(LinkDto dto) {
        Link link = new Link(dto.getId(), dto.getName(), dto.getUrl(), dto.getDescription(), userService.toEntity(dto.getUser()));
        return link;

    }

    @Override
    public LinkDto toDto(Link link) {
        LinkDto dto = new LinkDto(link.getId(), link.getName(), link.getUrl(), link.getDescription(), userService.toDto(link.getUser()));
        return dto;
    }
}
