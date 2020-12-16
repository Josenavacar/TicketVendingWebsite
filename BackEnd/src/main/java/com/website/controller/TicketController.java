package com.website.controller;

import com.website.model.Ticket;
import com.website.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path="/api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketRepository repository;

    @PostMapping
    public @ResponseBody String addNewTicket (@RequestBody Ticket ticket) {
        repository.save(ticket);
        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Ticket> getAllTickets() {
        return repository.findAll();
    }

    @GetMapping("/id/{id}")
    public @ResponseBody Ticket getTicketById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/match/{id}")
    public @ResponseBody Ticket getTicketByMatchId(@PathVariable int id) {
        return repository.findByMatchID(id);
    }

    @GetMapping("/fan/{id}")
    public @ResponseBody Ticket getTicketByFanId(@PathVariable int id) {
        return repository.findByFanID(id);
    }

    @PutMapping("{id}")
    public @ResponseBody String updateTicket(@PathVariable int id, @RequestBody Ticket newTicket) {
        Ticket existingTicket = repository.findById(id).orElse(null);
        existingTicket.setFanID(newTicket.getFanID());
        existingTicket.setMatchID(newTicket.getMatchID());
        repository.save(existingTicket);
        return "Ticket with id " + id + " has been updated";
    }

    @DeleteMapping("{id}")
    public @ResponseBody String deleteTicket(@PathVariable int id) {
        repository.deleteById(id);
        return "Ticket with id " + id + " has been deleted";
    }
}
