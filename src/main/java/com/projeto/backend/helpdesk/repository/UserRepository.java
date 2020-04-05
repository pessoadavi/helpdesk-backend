package com.projeto.backend.helpdesk.repository;

import com.projeto.backend.helpdesk.models.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    /* interface que utiliza a classe CRUD para o banco de dados */
    
    public User findByEmail(String email); /* metodo que nao existe no crud. serve para achar email */

	public Page<User> findAll(Pageable pages); /* metodo que nao existe no crud. serve para mostrar todos da lista */

}