package com.projeto.backend.helpdesk.services;

import java.util.Optional;

import com.projeto.backend.helpdesk.models.User;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    User findByEmail(String email);
    
    User createOrUpdate(User user);

    Optional<User> findById(String id);

    void delete(String id);

    Page<User> findAll(int page, int count);
}