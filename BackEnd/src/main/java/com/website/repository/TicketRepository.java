package com.website.repository;

import com.website.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    Iterable<Ticket> findByFanID(int id);
    Iterable<Ticket> findByMatchID(int id);
    Iterable<Ticket> findByFanIDAndPaid(int id, int paid);
}
