package com.website.repository;

import com.website.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Ticket findByFanID(int id);
    Ticket findByMatchID(int id);
}
