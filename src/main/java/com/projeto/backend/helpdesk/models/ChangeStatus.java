package com.projeto.backend.helpdesk.models;

import java.util.Date;

import com.projeto.backend.helpdesk.enums.StatusEnum;

import org.springframework.data.annotation.Id;

public class ChangeStatus {

    @Id
    private String id;

    private Ticket ticket;

    private User userChange;

    private Date dateChangeStatus;

    private StatusEnum status;

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUserChange() {
        return userChange;
    }

    public void setUserChange(User userChange) {
        this.userChange = userChange;
    }

    public Date getDateChangeStatus() {
        return dateChangeStatus;
    }

    public void setDateChangeStatus(Date dateChangeStatus) {
        this.dateChangeStatus = dateChangeStatus;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}