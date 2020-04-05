package com.projeto.backend.helpdesk.security.service;

import com.projeto.backend.helpdesk.models.User;
import com.projeto.backend.helpdesk.security.jwt.JwtUserFactory;
import com.projeto.backend.helpdesk.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/* Servico para manipular a interface do userDetail */
@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

@Autowired
private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        } else {
        
        return JwtUserFactory.create(user);
        }
    }
   
}