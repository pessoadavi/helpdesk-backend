package com.projeto.backend.helpdesk.security.jwt;

import java.util.ArrayList;
import java.util.List;

import com.projeto.backend.helpdesk.enums.ProfileEnum;
import com.projeto.backend.helpdesk.models.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/* classe para converter nosso usuario em um usuario do spring security*/
public class JwtUserFactory {

    private JwtUserFactory() {
    
    }

    /* Metodo que gera um jwtUser com base nos dados do usuario */
    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
    }

    /* Metodo converte o perfil do usuario para o formato do spring security */
    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
        return authorities;
    }

}