package com.projeto.backend.helpdesk.services.impl;
import java.util.Optional;

import com.projeto.backend.helpdesk.models.User;
import com.projeto.backend.helpdesk.repository.UserRepository;
import com.projeto.backend.helpdesk.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
/* classe que contem os metodos da interface UserService */
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    /* faz injecao de dependencia do repositorio de CRUD para ser usado nesta classe */

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User createOrUpdate(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String id) {
        return this.userRepository.findById(id);
    }
    
    @Override
    public void delete(String id) {
        this.userRepository.deleteById(id);;
    
    }


    public Page<User> findAll(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return this.userRepository.findAll(pages);
    }
  
}   
