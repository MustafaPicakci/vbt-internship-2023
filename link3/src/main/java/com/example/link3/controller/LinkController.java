package com.example.link3.controller;

import com.example.link3.entity.Link;
import com.example.link3.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private LinkService linkService;


    @PostMapping
    public void addLink(@RequestBody Link link) {
        linkService.addLink(link);
    }

    @GetMapping("/u/{username}")
    public ResponseEntity list(@PathVariable String username) throws Exception {

        return ResponseEntity.ok(linkService.findByUsername(username));

    }

}
