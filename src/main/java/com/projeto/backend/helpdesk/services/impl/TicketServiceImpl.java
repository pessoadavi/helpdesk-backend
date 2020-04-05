package com.projeto.backend.helpdesk.services.impl;

import java.util.Optional;

import com.projeto.backend.helpdesk.models.ChangeStatus;
import com.projeto.backend.helpdesk.models.Ticket;
import com.projeto.backend.helpdesk.repository.ChangeStatusRepository;
import com.projeto.backend.helpdesk.repository.TicketRepository;
import com.projeto.backend.helpdesk.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;


@Component
/* classe que contem os metodos da interface TicketService */
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    /* faz injecao de dependencia do repositorio de CRUD para ser usado nesta classe */

    @Autowired
    private ChangeStatusRepository changeStatusRepository;
    /* faz injecao de dependencia do repositorio de CRUD para ser usado nesta classe */

    @Override
    public Ticket creatOrUpdate(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(String id) {
        return this.ticketRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        this.ticketRepository.deleteById(id);
    }

    @Override
    public Page<Ticket> listTicket(int page, int count) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findAll(pages);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Page<Ticket> findByCurrentUser(int page, int count, String userId) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findByUserIdOrderByDateDesc(pages, userId);
    }

    @Override
    public ChangeStatus createChangeStatus(ChangeStatus changeStatus) {
        return this.changeStatusRepository.save(changeStatus);
    }

    @Override
    public Iterable<ChangeStatus> listChangeStatus(String ticketId) {
        return this.changeStatusRepository.findByTicketIdOrderByDateChangeStatusDesc(ticketId);
    }

    public Page<Ticket> findByParameters(int page, int count,String title,String status,String priority) {
		Pageable pages = PageRequest.of(page, count);
		return this.ticketRepository.findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(
				title,status,priority,pages);
	}

    @Override
    public Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findByTitleIgnoreCaseContaingAndStatusAndPriorityOrderByDateDesc(title, status, priority, pages);
    }

    @Override
    public Page<Ticket> findByNumber(int page, int count, Integer number) {
        Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findByNumber(number, pages);
    }

    
    @Override
    public Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status,
            String priority, String assignedUser) {
                Pageable pages = PageRequest.of(page, count);
        return this.ticketRepository.findByTitleIgnoreCaseContaingAndStatusAndPriorityAndAssignedUserIdOrderByDateDesc(title, status, priority, pages);
    }


    /* atencao que retiramos os erros deste arquivo alterando parametros de variaveis da interface no ticketservice */

}