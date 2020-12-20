package com.website.controller;

import com.website.model.Ticket;
import com.website.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(path="/api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketRepository repository;

    @PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
    @GetMapping("/fan/{id}/{paid}")
    public @ResponseBody Iterable<Ticket> getTicketByFanId(@PathVariable int id, @PathVariable int paid) {
        return repository.findByFanIDAndPaid(id, paid);
    }

    @PreAuthorize("hasRole('USER') or  hasRole('ADMIN')")
    @PostMapping
    public @ResponseBody String addNewTicket (@RequestBody Ticket ticket) {
        repository.save(ticket);
        return "Saved";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public @ResponseBody Iterable<Ticket> getAllTickets() {
        return repository.findAll();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/id/{id}")
    public @ResponseBody Ticket getTicketById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/match/{id}")
    public @ResponseBody Iterable<Ticket> getTicketByMatchId(@PathVariable int id) {
        return repository.findByMatchID(id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/fan/{id}")
    public @ResponseBody Iterable<Ticket> getTicketByFanId(@PathVariable int id) {
        return repository.findByFanID(id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("{id}")
    public @ResponseBody String updateTicket(@PathVariable int id, @RequestBody Ticket newTicket) {
        Ticket existingTicket = repository.findById(id).orElse(null);
        existingTicket.setFanID(newTicket.getFanID());
        existingTicket.setMatchID(newTicket.getMatchID());
        repository.save(existingTicket);
        return "Ticket with id " + id + " has been updated";
    }

    @PutMapping("/buy/{id}")
    public @ResponseBody String purchaseTicket(@PathVariable int id) {
        Ticket existingTicket = repository.findById(id).orElse(null);
        existingTicket.setPaid(1);
        repository.save(existingTicket);
        return "Ticket with id " + id + " has been purchased";
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public @ResponseBody String deleteTicket(@PathVariable int id) {
        repository.deleteById(id);
        return "Ticket with id " + id + " has been deleted";
    }
}
