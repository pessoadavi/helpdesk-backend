package com.projeto.backend.helpdesk.repository;

import com.projeto.backend.helpdesk.models.Ticket;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, String> {

 Page<Ticket> findByUserIdOrderByDateDesc(org.springframework.data.domain.Pageable pages, String userId); 
 /* pagina os tickets do cliente logado por ordenando por data decrescente */

 Page<Ticket> findByTitleIgnoreCaseContaingAndStatusAndPriorityOrderByDateDesc(String title, String status, String priority, org.springframework.data.domain.Pageable pages);
 /* responsavel pela parte da pesquisa a partir dos filtros listados nos parametros */
 
 Page<Ticket> findByTitleIgnoreCaseContaingAndStatusAndPriorityAndUserIdOrderByDateDesc(String title, String status, String priority, Pageable pages);

 Page<Ticket> findByTitleIgnoreCaseContaingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(String title, String status, String priority, org.springframework.data.domain.Pageable pages);

 Page<Ticket> findByNumber(Integer number, org.springframework.data.domain.Pageable pages);

Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(String title, String status, String priority, org.springframework.data.domain.Pageable pages);

Page<Ticket> findAll(org.springframework.data.domain.Pageable pages);


} 

/* atencaopara as mudancas que fez na tipagem do pages */