package com.projeto.backend.helpdesk.models;

import java.util.Date;
import java.util.List;

import com.projeto.backend.helpdesk.enums.PriorityEnum;
import com.projeto.backend.helpdesk.enums.StatusEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Ticket {

    @Id
    private String id;

    private User user;

    private Date date;

    private String title;

    private Integer number;

    private StatusEnum status;

    private PriorityEnum priority;

    private User assignerUser;

    private String description;

    private String image;

    @Transient   // não gera representação no banco de dados
    private List<ChangeStatus> changes;

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public User getAssignerUser() {
        return assignerUser;
    }

    public void setAssignerUser(User assignerUser) {
        this.assignerUser = assignerUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ChangeStatus> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeStatus> changes) {
        this.changes = changes;
    }


}

