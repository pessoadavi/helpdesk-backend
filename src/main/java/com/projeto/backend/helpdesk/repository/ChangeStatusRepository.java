package com.projeto.backend.helpdesk.repository;

import com.projeto.backend.helpdesk.models.ChangeStatus;

import org.springframework.data.repository.CrudRepository;

public interface ChangeStatusRepository extends CrudRepository<ChangeStatus, String> {

    Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);
}