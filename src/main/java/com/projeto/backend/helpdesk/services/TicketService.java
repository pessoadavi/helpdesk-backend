package com.projeto.backend.helpdesk.services;

import java.util.Optional;

import com.projeto.backend.helpdesk.models.ChangeStatus;
import com.projeto.backend.helpdesk.models.Ticket;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface TicketService {

    Ticket creatOrUpdate(Ticket ticket);

    Optional<Ticket> findById(String id);

    void delete(String id);

    Page<Ticket> listTicket(int page, int count);

    ChangeStatus createChangeStatus(ChangeStatus changeStatus);
    
    Iterable<ChangeStatus> listChangeStatus(String ticketId);

    Page<Ticket> findByCurrentUser(int page, int count, String userId);

    Page<Ticket> findByParametersAndCurrentUser(int page, int count, String title, String status, String priority);

    Page<Ticket> findByNumber(int page, int count, Integer number);

    Iterable<Ticket> findAll();

    Page<Ticket> findByParametersAndAssignedUser(int page, int count, String title, String status, String priority, String assignedUser);

}