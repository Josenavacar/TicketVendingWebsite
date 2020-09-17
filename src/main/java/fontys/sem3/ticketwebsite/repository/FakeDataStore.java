package fontys.sem3.ticketwebsite.repository;

import fontys.sem3.ticketwebsite.model.Ticket;

import java.util.*;

public class FakeDataStore {

    private final List<Ticket> ticketList = new ArrayList<Ticket>();

    public FakeDataStore()
    {
        Ticket ticket1 = new Ticket("Gregorio Mistasas", "12345678A");
        Ticket ticket2 = new Ticket("Frank Castle", "23456789B");
        Ticket ticket3 = new Ticket("John Rambo", "34567890C");

        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
    }

    public Ticket getTicket(int seat)
    {
        for(int i = 0; i < ticketList.stream().count(); i++)
        {
            if(ticketList.get(i).getSeat() == seat)
            {
                return ticketList.get(i);
            }
        }
        return null;
    }

    public List<Ticket> getTickets() {
        return this.ticketList;
    }
}
