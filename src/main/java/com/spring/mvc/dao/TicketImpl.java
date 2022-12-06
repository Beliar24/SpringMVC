package com.spring.mvc.dao;

import com.spring.mvc.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketImpl implements Ticket {

    private Long id;
    private EventImpl eventId;
    private UserImpl userId;
    private int place;
    private Category category;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getEventId() {
        return eventId.getId();
    }

    @Override
    public void setEventId(long eventId) {
        this.eventId.setId(eventId);
    }

    @Override
    public long getUserId() {
        return userId.getId();
    }

    @Override
    public void setUserId(long userId) {
        this.userId.setId(userId);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public void setPlace(int place) {
        this.place = place;
    }
}
