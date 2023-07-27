package com.example.link3.controller;

import com.example.link3.dto.LinkDto;
import com.example.link3.entity.Link;
import com.example.link3.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<LinkDto> addLink(@RequestBody LinkDto dto) {
        return ResponseEntity.ok(linkService.addLink(dto));
    }

    @GetMapping("/u/{username}")
    public ResponseEntity<List<LinkDto>> list(@PathVariable String username) throws Exception {
        return ResponseEntity.ok(linkService.findByUsername(username));
    }

    @PutMapping
    public ResponseEntity<LinkDto> update(@RequestBody Link link) throws Exception {
        return ResponseEntity.ok(linkService.update(link));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        linkService.delete(id);
        return ResponseEntity.ok().build();
    }

}
