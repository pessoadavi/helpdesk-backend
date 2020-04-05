package com.projeto.backend.helpdesk.security.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/* Autenticacao stateless, nao dependendo da sessao e guarda os dados de acesso em um token
api`s restfull eficientes nao devem manter estado e permitam que podem ser escalados horizontalmente para que sejam de alta perfomance. por nao manter sessao em nenhnum local
os dados sao guardados em algum lugar que pode ser compaortilhado entre as requisicoes e isso serve o jwt.
jwt eh um formato de token seguro que mantem a integridade dos dados guardados e possui assinatura digital.*/

/* CLasse dedicada para manipular  token */

@Component
public class JwtTokenUtil implements Serializable {


    private static final long serialVersionUID = 1L;

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "created";
    static final String CLAIM_KEY_EXPIRED = "exp";

    @Value("${jwt.secret}")  /* toma o valor definito em application.properties */
    private String secret;

    @Value("${jwt.expiration}") /* toma o valor definito em application.properties */
    private Long expiration;

    /* metodo pra obter o email (login) do usoario e jogar dentro do token */
    public String getUsernameFromToken(String token) {
        
        String username;

        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception exception) {
            username = null;
        }
        return username;
    }

    /* metodo para retornar a data de expiracao do token jwt */
    public Date getExpirationDateFromToken(String token) {

        Date expiration;

        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception exception) {
            expiration = null;
        }
        return expiration;
    }

    /* metodo que realiza o passe do toke jwt para extrair as informa;'oes contidas no corpo dele */
    private Claims getClaimsFromToken(String token) {
        
        Claims claims;

        try {
            claims = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJwt(token)
            .getBody();
        } catch (Exception exception) {
            claims = null;
        }
        return claims;
    }

    /* metodo para verificar se o token esta expirado */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /* metodo que gerara o token */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

        final Date createDate = new Date();
        claims.put(CLAIM_KEY_CREATED, createDate);
        return doGenerateToken(claims);   
    }

    /* metodo auxiliar para o generateToken */
    private String doGenerateToken(Map<String, Object> claims) {
        final Date createDate = (Date) claims.get(CLAIM_KEY_CREATED);
        final Date expirationDate = new Date(createDate.getTime() + expiration * 1000);
        
        return Jwts.builder()
               .setClaims(claims)
               .setExpiration(expirationDate)
               .signWith(SignatureAlgorithm.HS512, secret)
               .compact();   
    }

    /* metodo para verificar se o token pode ser atualizado */
    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token));
    }

    /* metodo para atualizar o token */
    public String refreshToken(String token) {
        
        String refreshedToken;
        
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = doGenerateToken(claims);
        } catch (Exception exception) {
            refreshedToken = null;
        }
        return refreshedToken;
    } 

    /* metodo para verificar se o token esta valido */
    public Boolean validateToken(String token, UserDetails userDetails) {

        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        return ( username.equals(user.getUsername())
                 && !isTokenExpired(token));

    }
}
