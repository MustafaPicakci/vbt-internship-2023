package com.example.link3.repository;

import com.example.link3.entity.Link;
import com.example.link3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link,Long> {
    List<Link> findByUser(User user);
    void deleteByUser(User user);
}
