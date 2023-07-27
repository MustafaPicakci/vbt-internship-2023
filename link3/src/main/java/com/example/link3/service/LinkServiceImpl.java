package com.example.link3.service;

import com.example.link3.entity.Link;
import com.example.link3.entity.User;
import com.example.link3.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LinkServiceImpl implements LinkService{


    @Autowired
    LinkRepository linkRepository;

    @Autowired
    UserService userService;


    @Override
    public void addLink(Link link) {
        linkRepository.save(link);
    }

    @Override
    public List<Link> findByUsername(String username) throws Exception {
        User user=userService.findByUsername(username);
        return linkRepository.findByUser(user);

    }
}
